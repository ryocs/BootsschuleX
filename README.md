# Bootsschule X Quiz

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


 
