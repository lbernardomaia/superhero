***SuperHeroes:*** 

Project that exposes json endpoint about Superheroes.

The application was developed using:

 - JDK8
 - Apache Maven
 - MongoDB
 - Spring Boot 1.4.1

The app use these endpoints:

- Create a superhero with the following properties
    Name
    Pseudonym
    The publisher it is from (e.g. DC or Marvel)
    List of "skills" or powers
    List of allies (e.g Batman's ally would be Robin) if the superhero has any
    Date of first appearance (in the format YYYY-MM-DD)
    
    Method Post to: http://superhero.ks23mqvnpu.us-west-2.elasticbeanstalk.com/superhero
    
    ```javascript
    Example:
    [
      {
        name: "Bruce Wayne",
        pseudonym: "Batman",
        publisher: "DC",
        skillsDTO: [
          {
          name: "power"
          },
          {
           name: "speed"
          }
        ],
        alliesDTO: [
          {
           name: "Robin"
          },
          {
           name: "Bat Girl"
          }
        ],
         dateFirstAppearance: "2000-02-03"
       }
     ]
    ```


- Get a list of all superheros in JSON format
     Method Get to: http://superhero.ks23mqvnpu.us-west-2.elasticbeanstalk.com/superhero

- Get the details of a specific superhero in JSON format
     Method Get to: Get to http://superhero.ks23mqvnpu.us-west-2.elasticbeanstalk.com/superhero/5805271b61b93d0c78ba173b