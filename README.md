# customer-phone-app
Customer Microservice

Microservicio la gestión del dominio de clientes de la aplicación
Al arrancar el servicio, se crea una base de datos MongoDB en memoria, 
para la gestion de la persistencia de la aplicacion.

#Swagger
http://localhost:8080/swagger-ui.html

#Docker
Create container from shell 
	"mvn package spring-boot:repackage"
	"docker build -t customer-phone-app/v1 ."