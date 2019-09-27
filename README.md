# Kamana Irankunda Eliane
# Forest-Service
#### This is application that records animals and adds a sighted animal everytime a ranger sees it, September 27,2019
#### By **Kamana Irankunda Eliane**
## Description
In the Forest-Service application, one can add a non-endangered and an endangered animal in their respective forms which are available through links found in the home page of the application. One can also make a sighting depending on the animal they have seen. If the animal seen is not available in the selector it means it hasn't been added yet and needs to be added first in the add animal section. One also can view all the animals and sightings available in the database. 
## Setup/Installation Requirements
To clone this repository successfully one needs:
#### Dependencies/installations
* The project is based on Apache Spark 2.6.0.
* Installation of IntelliJ IDEA is needed.
* Installation of postgresql is needed.
#### DATABASE installation
*In PSQL:
* CREATE DATABASE wildlife_tracker;
*  \c wildlife_tracker;
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar);
* CREATE TABLE endangeredanimal (id PRIMARY KEY, name varchar, health int, age int);
* CREATE TABLE sightings(id serial PRIMARY KEY,animalName varchar, location varchar, rangerName varchar);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
##### everytime you make changes to your database you must drop and recreate you test database:
* DROP DATABASE wildlife_tracker_test;
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
## Technologies Used
* HTML
* CSS
* Bootstrap
* JAVA
* Spark framework
## Support and contact details
May you encounter any issue or have any questions and suggestions please contact me at **irankundaeliane9@gmail.com**
### License
I hereby grant all access to everyone. 
Copyright (c) 2019 **Eliane**
