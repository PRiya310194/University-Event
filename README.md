# University-Event
IntelliJIDEA
* Serverport: 8080 (use: localhost:8080)
* Java version: 17
* Everything is present in the pom.xml (no need to download any library)

## Steps to run User Management System
* Download the source code and import in intellijIDEA.
* Go to localhost:8080/ URL * Type endpoints in The
* StudentIdURL user will have the following details
* id
* firstName
* LastName
* age
* Department
* EventIdURL user will have the following details
* eventId;
   * eventName;
     * private String locationOfEvent;
      * date;
    * startTime;
    * EndTime;

Student will perform following operations -
### -> Add User Info - 
In AddStudent functionality we Post User info through Postman and it gets added to the User list -
* End point-http://localhost:8080/saveStudent
### -> Get User Info by studentId -
In this functionality we provide a perticular User info by sending the userid in url through @Pathvariable -
* Endpoint-http://localhost:8080/student/studentId
### Get all student Info -
This functionality provides all User info list -
* Endpoint- http://localhost:8080/student
###  Update Studnet department Info by UserId-
This functionality Updates a perticular User info through Postman by sending userid in url -
* Endpoint -> http://localhost:8080/updateStudent/1/dept/{department}

###  Delete Student Info by UserId-
This functionality deletes particular User info through Postman using the Delete method by sending the user-id in URL-
* Endpoint-> http://localhost:8080/deleteStudent/studentId

### -> Add Event Info - 
In AddStudent functionality we Post User info through Postman and it gets added to the event list -
* End point-http://localhost:8080/saveEvent

###  Delete Event Info by eventId-
This functionality deletes particular User info through Postman using the Delete method by sending the user-id in URL-
* Endpoint-> http://localhost:8080/deleteEvent/1

### -> Get Event Info by date -
In this functionality we provide a perticular event info by sending the date in url through @Pathvariable -
* Endpoint-http://localhost:8080/date/date

## Note
* You can change server port by setting properties in application.properties file i.e.
   server.port=8081
