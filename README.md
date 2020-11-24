# product_service_aggregator

# Docker Enviroment Setup
## Create docker network
Please create a docker network by below command.
```sh
$ docker network create --driver bridge myRetail-network
```
## Download mongo db image for centralize configuration server
Please download mongo db image
```sh
$ docker run -it -d -p 27019:27017 --name myRetail-conf-mongo --network=myRetail-network mongo
 ```
Configure mongo db image
```sh
$ docker exec -it myRetail-conf-mongo mongo
$ use config-server
$ db.createUser( { user: "microservice_admin", pwd: "microservice_admin", roles: [ { role: "readWrite", db: "config-server" } ] } );
$ db.configProfile.insert({
    "_class": "com.myRetail.test.configserver.entity.ConfigProfile",
    "application": "product-aggregator",
    "profile": "default",
    "version": 1,
    "properties":
        [
            {"key":"product.details.url.template", "value": "http://localhost:38080/product?id=%s&amp;country=%s"},
            {"key":"product.price.url.template", "value": "http://localhost:28080/productPrice?id=%s&amp;country=%s"},
			{"key":"product.default.currency", "value": "USD"}
        ]
});
 ```

## Setup keycloak identity server

 - Go to [Keycloak Identity Provider](./Keycloak-Identity-Provider)  
 - Run below command 
```sh 
$ docker-compose up -d 
```
 - Setup user 
# Setup Product details and product price mock service
 - Download SOAP UI  
 - Import project REST-Project-1-soapui-project.xml from [here](./REST-Project-1-soapui-project.xml)


# Start all instances

Start all instance in below sequence

 - Product details and pricing mock server 
 - Config server 
 - Product agreegator 
 - Gateway server

# Testing
You can get all product details by below API
```sh 
/v1/product/123
```
You can also enable keycloak security and access API via gateway with JWT security 

You can also check error handling by shutting down one mock service.

# Future enhancement
 - Move all services to service registry
 - Disable product agreegator post and only access via gateway port.
