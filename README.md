# Task-1 Java REST API
This is a Spring Boot application that provides a RESTful API for performing operations on a MongoDB database.

## Prerequisites
To run this application, you will need:
- Java 11 or above
- MongoDB

## Installation
Clone the repository to your local machine:
> https://github.com/Anant1711/Task-1-Java-Rest-API.git

## Usage
Once the application is running, you can access the RESTful API endpoints using a tool like curl or Postman. Here are the available endpoints:

- `GET /`:  returns a list of all items in the database
- `GET /{ID}`:returns a single item with the specified ID
- `GET /name/{name}`: returns a list of items with the specified name
- `POST /`:creates a new Server detail with the provided data
- `DELETE /{ID}`:deletes the item with the specified ID

## Getting Started
The application will start up on port 8080 now 
Start your MongoDB Server, by this command in cmd
   > mongod

      By default, the application is configured to connect to a MongoDB instance running on `localhost` with the default port `27017`. You can change the connection settings by modifying the `application.properties` file.

Now you can access the API endpoints using a tool like cURL, Postman or a web browser.
## API Documentation
### GET /
Returns a list of all items in the database.
```java
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        List<Server> Allserver = ServerRepository.findAll();
        if(Allserver.size() > 0){
            return new ResponseEntity<List<Server>>(Allserver, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("404",HttpStatus.NOT_FOUND);
        }
    }

```
The method calls the findAll() method of a ServerRepository object to retrieve all server objects from a database. It then checks if the list of servers is not empty by calling the size() method.

If its Empty it will return `404 NOT FOUND`, and if size of List is greater than 0 it will return all list with  `200 status code`.


<img src="/ScreenShots/get.jpg" alt="GET"/>

### GET /{ID}

