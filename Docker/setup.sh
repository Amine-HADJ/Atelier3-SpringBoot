#!bin/bash

# This script will generate .jar for each application ('mvn clean package') and then run all the neccessary containers for the project.

cd ./applications/auth && mvn clean package && cd -
cd ./applications/card && mvn clean package && cd -
cd ./applications/game && mvn clean package && cd -
cd ./applications/market && mvn clean package && cd -
cd ./applications/room && mvn clean package && cd -
cd ./applications/user && mvn clean package && cd -


docker-compose up --build -d
