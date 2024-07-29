FROM openjdk:17-jdk-slim

# Configurações do Minecraft
ENV MINECRAFT_VERSION 1.21
ENV SPIGOT_FILE spigot-$MINECRAFT_VERSION.jar

# Diretório de trabalho
WORKDIR /minecraft

# Copiar arquivos necessários
COPY build/libs/windcharge-1.0.jar /minecraft/plugins/
COPY run.sh /minecraft/run.sh

# Baixar e configurar o servidor Spigot
RUN apt-get update && \
    apt-get install -y wget && \
    wget -O $SPIGOT_FILE https://cdn.getbukkit.org/spigot/spigot-$MINECRAFT_VERSION.jar && \
    chmod +x run.sh

# Porta do servidor
EXPOSE 25565

# Comando para iniciar o servidor
CMD ["./run.sh"]
