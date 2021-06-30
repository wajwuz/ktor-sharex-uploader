# ktor-sharex-uploader
uploader zdjec napisany w kotlinie przy uzyciu ktor

# pobierak
gotowa jarka jest do pobrania [tutaj](https://github.com/marszello/ktor-sharex-uploader/releases)

# config apki
konfiguracje apki macie [tutaj](https://github.com/marszello/ktor-sharex-uploader/blob/master/src/main/resources/application.conf)

# uzycie jarki
tradycyjnie `java -jar jarka.jar` lub mozecie odpalic w screen (zeby ciagle odpalona byla) `cd sciezka/ && screen -dmS ktor-sharex java -jar plik.jar`

# uzycie sharex

| rzecz | wartosc |
| --------- | -----:|
| request | POST -> http://ip:port/upload |
| body | form data (multipart/form-data) |
| post data | clientSecret -> token |
| response | URL -> https://domena/katalog/$response$ |
