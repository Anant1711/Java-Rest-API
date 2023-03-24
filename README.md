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

<img src="/ScreenShots/get.jpg" alt="GET"/>

