# GovermentPermit

## This spring boot project has the following web services for both electricalPermit and StructuralPermit:

- to persist the request(using HTTP Post)
- to get the status of the permit request ( using HTTP GET)
- to delete the permit request incase of denial ( using HTTP DELETE)
- also,it has the timer service which will scan the database for every 60 seconds to get the pending permit requests and update those requests with APPROVED status.
(This is for just testing purpose)

## DB Details:
(change the configuration as you need in application-properties)

* **url**     :  jdbc:oracle:thin:@localhost:1521:xe
* **username**: test_database
* **password**: asdf123

## How to Run?

This project has internal tomcat server.So,just pass the below commands to make those services available.

- Java –jar GovernmentPermit.jar  (or) mvn spring-boot:run

