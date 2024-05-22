#!bin/bash

# This script will generate .jar for each application ('mvn clean package')

cd ./applications/auth
mvn clean package

cd ../card
mvn clean package

cd ../game
mvn clean package

cd ../market
mvn clean package

cd ../room
mvn clean package

cd ../user
mvn clean package

cd ../../
docker-compose up --build

