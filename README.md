

# Coding challenge


## Scenario

Receptionists have to accomplish various tasks throughout the day when operating a hotel. One of those tasks is to accept parcels for guests.

1. It happens, that receptionists accept parcels for guests, that were already checked out of the hotel.
2. It happens from time to time, that guests forget to pick up their parcels before check-out and even forget it then.


## Requirements

1. The receptionist needs a tracking tool that knows to any given time which guests are checked into the hotel and have not checked out, in order to allow the receptionist to make the decision of whether to accept the parcelRequest or not.
2. The tracking tool should further the allow the receptionist to check for parcels available for pick-up when the guest is checking out.

## Tasks

- Document the usability and the design of your solution in a PDF file.
- Build a RESTful JSON-API that supports the following use cases. Your implementation should based on the Microservices architecture approach.
- Document your solution with a Swagger file served by the API.


## Deliverable

Please ship a zip file named firstname-lastname.zip to us that contains:

- The source code (buildable and runnable without changes) with an Ant, Maven or Gradle build script
- A compiled and executable Jar
- Your documentation PDF file


## In Scope

We're interested to see how you produce production-ready code. By that we focus on naming conventions, coding style, sensible design and
meaningful commenting. Perfect code ships at a shape, that enables colleagues to quickly understand the domain and code base.

We love TDD, so including unit tests is a good idea!

We understand writing even a trivial application and having it production-ready is a lot of work. Please limit writing a lot of boilerplate - showing the
intent and leaving "to-do" comments in your code is okay. However, make sure your solution works!


## Out of Scope

We don't expect you to use every design pattern you've ever heard of - only apply patterns when it makes sense to do so.

We don't expect you to build a user interface.

We're not expecting you to have optimized the solution for performance or memory size - readability is more important than performance


## Run Spring boot service with gradle
```
./gradlew eureka-server:bootRun
./gradlew guest-tracking:bootRun
./gradlew parcel-service:bootRun
```

## Build
```
./gradlew eureka-server:build
./gradlew guest-tracking:build
./gradlew parcel-service:build
```

## Run compiled and executable Jar
After building you can run each service like that:
```
java -jar eureka-server/build/libs/eureka-server-0.0.1-SNAPSHOT.jar
java -jar guest-tracking/build/libs/guest-tracking-0.0.1-SNAPSHOT.jar
java -jar parcel-tracking/build/libs/parcel-tracking-0.0.1-SNAPSHOT.jar
```

## Check health

Guest service: `http://localhost:8080/actuator/health`

Parcel service: `http://localhost:8081/actuator/health`

Eureka registry and discovery: `http://localhost:8761`

## API with Swagger

Guest service: `http://localhost:8080/swagger-ui.html#/guest-controller`

Parcel service: `http://localhost:8081/swagger-ui.html#/parcel-controller`

There is a endpoint for tracking all checked-in guest or a specific guest (by name).
The first part is to be able to match upcoming parcels to current guests. 
If that's the case the parcel can be accepted. 

```
POST http://localhost:8080/guest-tracking/guests/{lastname}/{firstName}
RequestBody:
{
    "firstName": "Bob",
    "lastName": "Marley",
    "parcelCode": "12345X",
    "deliveryService": "DHL"
}
```

The second part is to inform guest about existing parcels before checking out.
Afterwards declare that guest as checked-out and the parcel as picked up.

`PUT http://localhost:8080/guest-tracking/guests/{id}/checkout`

