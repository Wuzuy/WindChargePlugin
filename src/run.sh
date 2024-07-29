#!/bin/bash

# Caminho para a pasta do projeto
PROJECT_DIR="/path/to/your/project"

# Caminho para a pasta do servidor Minecraft
MINECRAFT_SERVER_DIR="/path/to/your/minecraft"

# Caminho para o arquivo JAR do plugin
PLUGIN_JAR="$PROJECT_DIR/build/libs/windcharge-1.0.jar"

# Nome do arquivo JAR do Spigot
SPIGOT_JAR="spigot-1.21.jar"

# Verifica se o diretório do projeto existe
if [ ! -d "$PROJECT_DIR" ]; then
    echo "Diretório do projeto não encontrado: $PROJECT_DIR"
    exit 1
fi

# Navega para o diretório do projeto
cd "$PROJECT_DIR" || exit

# Compila o projeto usando Gradle
echo "Compilando o projeto com Gradle..."
./gradlew clean build

# Verifica se o JAR do plugin foi gerado
if [ ! -f "$PLUGIN_JAR" ]; then
    echo "Arquivo JAR do plugin não encontrado: $PLUGIN_JAR"
    exit 1
fi

# Verifica se o diretório do servidor Minecraft existe
if [ ! -d "$MINECRAFT_SERVER_DIR" ]; then
    echo "Diretório do servidor Minecraft não encontrado: $MINECRAFT_SERVER_DIR"
    exit 1
fi

# Copia o JAR do plugin para a pasta de plugins do servidor Minecraft
echo "Copiando o JAR do plugin para a pasta de plugins do servidor Minecraft..."
cp "$PLUGIN_JAR" "$MINECRAFT_SERVER_DIR/plugins/"

# Verifica se o arquivo JAR do Spigot existe
if [ ! -f "$MINECRAFT_SERVER_DIR/$SPIGOT_JAR" ]; then
    echo "Arquivo JAR do Spigot não encontrado: $SPIGOT_JAR"
    exit 1
fi

# Navega para o diretório do servidor Minecraft
cd "$MINECRAFT_SERVER_DIR" || exit

# Inicia o servidor Minecraft
echo "Iniciando o servidor Minecraft..."
java -Xmx2048M -Xms1024M -jar "$SPIGOT_JAR" nogui
