# Bootsschule X Quiz

## Anforderungen
JAVA: >= 25 (Benutzt: 25.0.2)

NODE: >= 25 (Benutzt: 25.6.1)

## Starten der Applikation

### Allgemein

Als erstes sollte die *docker-compose.yml* ausgeführt werden mit

    docker compose up -d

Dies erstellt den Datenbank server mit den Properties

    MYSQL_ROOT_PASSWORD: root<br/>
    MYSQL_DATABASE: quizdb<br/>
    MYSQL_USER: quizuser<br/>
    MYSQL_PASSWORD: quizpassword123<br/>

### Backend

Das backend kann gestartet werden mit 

    cd backend && ./gradlew bootRun 

Das backend erstellt automatisch die Benötigten Tabellen und seeded die Datenbank beim ersten hochfahren

### Frontend

Um das Frontend zu starten muss erst in den frontend ordner gewechselt werden

    cd frontend

Nun müssen erstmal alle dependencys installiert werden

    npm install

Danach kann das Frontend gestartet werden mit

    npm run dev

Npm run dev sollte die lokale adresse anzeigen. Ist dies nicht der fall sollte die standart adresse folgende sein:

    http://localhost:3000


 
