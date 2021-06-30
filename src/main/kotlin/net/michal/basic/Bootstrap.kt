package net.michal.basic

import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.apache.commons.lang3.RandomStringUtils
import java.io.File
import java.io.InputStream

fun Application.main() {
    routing {
        post("/upload") {
            val multipartData = call.receiveMultipart();
            val clientToken = environment.config.propertyOrNull("ktor.deployment.clientSecret")?.getString()
            var clientSecret: String? = null
            var fileExtension: String? = null
            var fileStream: (() -> InputStream)? = null

            multipartData.forEachPart { data ->
                when (data) {
                    is PartData.FormItem -> {
                        if (data.name == "clientSecret") {
                            clientSecret = data.value
                        }
                    }
                    is PartData.FileItem -> {
                        fileExtension = File(data.originalFileName!!).extension
                        fileStream = data.streamProvider
                    }
                }
            }

            if (clientToken == clientSecret) {
                val fileName = "${RandomStringUtils.randomAlphabetic(8)}.${fileExtension}"
                val fileCatalog = File(environment.config.propertyOrNull("ktor.deployment.fileCatalog")?.getString(), fileName)

                fileStream!!().use { file ->
                    fileCatalog.outputStream().buffered().use {
                        fileCatalog.writeBytes(file.readBytes())
                    }

                    call.respondText(fileName)
                    return@post
                }
            }
        }
    }
}