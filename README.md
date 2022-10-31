# FizzBuzz

### Specifications

Exercise: Write a simple fizz-buzz REST server. 

The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing all multiples of 3 by ""fizz"", all multiples of 5 by ""buzz"", and all multiples of 15 by ""fizzbuzz"". 
The output would look like this: ""1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,...""."

Your goal is to implement a web server that will expose a REST API endpoint that:

Accepts five parameters: three integers int1, int2 and limit, and two strings str1 and str2.
Returns a list of strings with numbers from 1 to limit, where: all multiples of int1 are replaced by str1, all multiples of int2 are replaced by str2, all multiples of int1 and int2 are replaced by str1str2.
 
The server needs to be:  
Ready for production  
Easy to maintain by other developers
 
Bonus: add a statistics endpoint allowing users to know what the most frequent request has been. This endpoint should:  
Accept no parameter  
Return the parameters corresponding to the most used request, as well as the number of hits for this request"


### Developpement

Projet effectué avec Sprint boot / jersey ainsi qu'une base de données h2 pour stocker l'historique des demandes.  
Le projet contient des tests unitiaires : 
 * FizzBuzzServiceTests : Test du business service
 * FizzbuzzApplicationTests : Test des API Rest full
 
Pour lancer le projet, utiliser Sprint boot (runAs -> Spring boot app).  
Attention, par défaut (voir le fichier de configuration `application.properties` pour modifier cela)
 * la base de données est réinitialisé à chaque démarrage
 * le port utilisé est le 8081
 * le context des API Rest est "/api"
 
Les 2 API sont disponibles aux URL suivantes : 
* http://{host}:{port}/api/fizzbuzz/compute/{int1}/{int2}/{limit}/{str1}/{str2}
* http://{host}:{port}/api/fizzbuzz/stats


### Compilation

Pour compiler le projet, lancer la commande suivante :  
`mvn clean install -DskipTests`

Le jar du projet est alors généré dans le répertoire target.


### Usage

Le programme peut être lancé en ligne de commande comme suit (Java 11 au minumum)  :  
`java -jar fizzbuzz-0.0.1-SNAPSHOT.jar` (il conviendrait au préalable de générer une release)

On peut changer les options (BDD, port, context-path, logs) dans le fichier de configuration `application.properties` (à mettre au même endroit que le jar pour surcharger celui d'origine)
Penser notamment à mettre la base de données en mode update (spring.jpa.hibernate.ddl-auto=update) pour conserver les données sur l'arrêt du service.



### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Jersey](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web.servlet.jersey)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

