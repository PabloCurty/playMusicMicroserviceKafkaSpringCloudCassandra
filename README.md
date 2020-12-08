# playMusicMicroserviceKafkaSpringCloudCassandra
Async Microservices with Spring Boot, Spring Cloud, Apache Kafka and Cassandra

Async Microservices with Spring Boot, Spring Cloud, Apache Kafka and Cassandra


Use o Windows média player para chamar a API (crt + u - abrir URL ou URI - e digite a URL http://localhost:8080/listen/music)



Instalar o WSL:

1 - No powerShel

$ Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Windows-Subsystem-Linux

$ Enable-WindowsOptionalFeature -Online -FeatureName VirtualMachinePlatform

2 - Na loja do Windons instale uma distribuição linux (ex:Ubuntu 20)

3 - No powerSehel
$ wsl --set-version Ubuntu 2

Instalar o Docker:

sudo apt update
sudo apt install apt-transport-https ca-certificates curl software-properties-common
sudo apt install build-essential
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt update
sudo apt install docker-ce
sudo service docker start
sudo docker run hello-world

Instalar o Docker compose:

sudo curl -L "https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
docker-compose --version
sudo docker-compose up -d

Instalar o Cassandra:

docker run --name cassandra bitnami/cassandra:latest
docker ps (Para pegar o id do serviço que tá rodando)
sudo docker exec -it <id do serviço> /bin/bash
cqlsh -u cassandra -p cassandra

Dentro do Cassandra:

CREATE KEYSPACE IF NOT EXISTS customer_keyspace 
WITH REPLICATION = {'class':'NetworkTopologyStrategy',
'datacenter':3};

use customer_keyspace;

CREATE TABLE Customer (id UUID PRIMARY KEY, name text,
country text, musicStyle text);

select * from Customer

