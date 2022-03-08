# talking-clock

Brief intro:
I want to apoligize to not submitting the solution in time. I got an so I had to put it on hold. Also, there was a misunderstanding from my side when tried to submit the test.
I can explain if you decide to proceed me further.

Solutions:

Objective 1
  #To run the application, you can simply:
    - open the **command line** of the pom file location (location which includes pom, src, target, .idea files/folders)
    - run the following code:  
          mvn spring-boot:run
Objective 2
   - open the **command line** of the pom file location (location which includes pom, src, target, .idea files/folders)
      // this is the structure of the command -->  mvn spring-boot:run -Dspring-boot.run.arguments=<HH:mm>
   - run the command example :  mvn spring-boot:run -Dspring-boot.run.arguments=00:00

Objective 3
   Run this request in the web browser, or application like postman, insomnia, etc. (just any time at the end of the url)
    http://localhost:8080/talking-clock/print-time-human-friendly?time=00:01
