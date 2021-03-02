# desafio_sincredi_back_end
Desafio Técnico para o Banco Sincredi Digital

# Instuções:

## Ubuntu

  * Rodar o script init.sh (./init.sh). Se houver errro de permissão, rodar chmod +x init.sh antes
  * Rodar docker-compose up -d na pasta src/resources/docker



## Windows

Rodar:

  * gradlew.bat assemble
  * copiar /buiild/libs/desafio-sincredi-0.1.0-SNAPSHOT.jar para /src/resources/docker/
  * na pasta /src/resources/docker rodar os comandos (nessa sequência):
    * docker build -t java-app .
    * docker-compose up -d
  
# Observações

  O sistema estará funcionando em localhost:8080

