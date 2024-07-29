#!/bin/bash

# Compilar o projeto Gradle
./gradlew clean build

# Copiar o JAR gerado para a pasta de plugins do servidor
cp build/libs/windcharge-1.0.jar /path/to/your/minecraft/plugins/

# Iniciar o servidor Minecraft
cd /path/to/your/minecraft/
java -Xmx1024M -Xms1024M -jar spigot-1.21.jar nogui
