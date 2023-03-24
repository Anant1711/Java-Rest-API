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


<img src="/ScreenShots/get.jpg" alt="GETallItems"/>

### GET /{ID}
Returns a single item with the specified ID

```java
@GetMapping("/{id}")
    public ResponseEntity<?> getbyID(@PathVariable("id") String id){
        Optional<Server> optionalSever = ServerRepository.findById(id);
        if(optionalSever.isPresent()){
            return  new ResponseEntity<>(optionalSever.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("404",HttpStatus.NOT_FOUND);
        }
    }
```

It is a controller method that handles HTTP GET requests for a specific server endpoint with an ID parameter ("/{id}").

The method takes in the ID parameter as a @PathVariable annotation and stores it as a string variable called id. It then calls the findById() method of a ServerRepository object to retrieve a server object with the specified ID from a database.

The findById() method returns an Optional object, which is a container object that may or may not contain a non-null value. The method checks if the optionalSever object contains a server object by calling the isPresent() method.

If the optionalSever object contains a server object it return that item from database with `200 ok status` and if not then `404 NOT FOUND`

<img src="/ScreenShots/getbyID.jpg" alt="GETbyID"/>

### GET name/{name}
Returns a list of items with the specified name

```java
@GetMapping("/name/{name}")
    public ResponseEntity<?> getbyName(@PathVariable("name") String name){
        List<Server> s = ServerRepository.findByName(name);
        if(s.size() > 0){
            return new ResponseEntity<>(s,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("404",HttpStatus.NOT_FOUND);
        }

    }
```

It is a controller method that handles HTTP GET requests for a specific server endpoint with a name parameter ("/name/{name}").

The method takes in the name parameter as a @PathVariable annotation and stores it as a string variable called name. It then calls the findByName() method of a ServerRepository object to retrieve all server objects with the specified name from a database.

The findByName() method returns a list of server objects that match the specified name. The method checks if the list `s` is not empty by calling the size() method.

If its empty it shows `404 NOT FOUND`, if found then it shows all items with specified name.

<img src="/ScreenShots/getbyname.jpg" alt="GETbyName"/>