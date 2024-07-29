# Wind Charge Plugin

## Descrição

O plugin `Wind Charge` permite personalizar a força da explosão, adicionar partículas e ajustar a velocidade do projétil no Minecraft 1.21.

## Estrutura do Projeto

A estrutura básica do projeto é a seguinte:

```
windcharge/
|-- src/
| |-- main/
| |-- java/
| |-- com/
| |-- wuzuy/
| |-- WindChargePlugin.java
| |-- WindChargeListener.java
| |-- resources/
| |-- plugin.yml
| |-- config.yml
|-- build.gradle
|-- settings.gradle
|-- Dockerfile
|-- run.sh
|-- README.md
```


## Execução

### Usando Script de Shell

1. Execute o script `run.sh` para compilar o projeto e iniciar o servidor com o plugin:
   ```sh
   ./run.sh

### Usando Docker
Construa a imagem Docker:

docker build -t windcharge .

Execute o contêiner Docker:
docker run -p 25565:25565 windcharge

## Lógica de Implementação
Força da Explosão Configurável: A força da explosão pode ser configurada através do arquivo config.yml usando a chave windcharge.explosionForce.
Opção para Adicionar Partículas: O uso de partículas pode ser ativado ou desativado com a chave windcharge.addParticles no config.yml.
Velocidade do Projétil Configurável: A velocidade do projétil é configurável via windcharge.projectileSpeed no config.yml.

# Autor
## Lucas Matheus


Certifique-se de substituir os detalhes conforme necessário e de atualizar qualquer informação adicional relevante para o seu projeto. Se precisar de mais alguma coisa, estou aqui para ajudar!
