#Playlist Service
Playlist Service is a service where users can create music lists and share them with others.

##Local Docker Setup
###Build
```
docker build -t playlist:dev .
```
###Setup
```docker network create --driver bridge playlist-net```
```docker run --name playlist_pg -e POSTGRES_PASSWORD=open -e POSTGRES_DB=playlist_db --network playlist-net -d postgres```
###Run
```docker run --name playlist1 --network playlist-net -p 9000:8080 -d -e SPRING_PROFILES_ACTIVE=postgres playlist:dev```

Instructions
This assessment focuses on the configuration of Docker to manage the deployment of your application both locally and remotely. Keep it simple. Use the stories and acceptance criteria to develop the Playlist Service.

###Create a repository.
Submit the link to your repository.
Submit the URL to your live app.
Hint: Baby Steps!!

###Requirements
Must have API specs for all endpoints, use Spring RestDocs.
Must have integration tests and unit tests.
As always TDD is expected.
Utilize Spring Profiles and Docker enable multiple run environments.
A local application running in Docker that uses Docker Postgres as DB. Provide instructions on how to run this.
A deployed application on Heroku that uses Heroku Postgres as DB.

###User Stories
***
Rule: Playlist names are unique.
Rule: Song is just the name of the song.


When a playlist is created with a name
Then a confirmation is returned that it was successful.
And the playlist is empty.

When a playlist is created with existing name
Then a message is returned that it was unsuccessful.

When a playlist is created without a name
Then a message is returned that a name is required.

Given a playlist
When a song is added
Then the playlist have one more song

Given a playlist has songs
When a song is removed
Then the playlist have one less song

Given a playlist has songs
When retrieve the playlist
Then see the songs on the playlist
***