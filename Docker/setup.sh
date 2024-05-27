#!bin/bash

# This script will generate .jar for each application ('mvn clean package') and then run all the neccessary containers for the project.

cd ./applications/auth && mvn clean package && cd ..
cd ./card && mvn clean package && cd ..
cd ./game && mvn clean package && cd ..
cd ./market && mvn clean package && cd ..
cd ./room && mvn clean package && cd ..
cd ./user && mvn clean package && cd ../..


docker-compose up --build -d
