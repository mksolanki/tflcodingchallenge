# TFL Coding Challenge #
TfL Coding Challenge is developed in Java language using SpringBoot.

### Softwares/Tools 
Below Software/Tools used for this coding challenge application:

* Java - version jdk-17.0.9
* Spring Boot - version 3.1.5
* Maven - version 3.9.4
* Intellij used for development, but it is optional to run this coding test.

### Pre-requisite
Below is pre-requisite to run this coding challenge application:
* Java version jdk-17.0.9 is installed. Set environment variable, JAVA_HOME=<path to jdk-17.0.9> and JAVA_HOME/bin is added to Path.
* Maven version 3.9.4 is installed. Set environment variable, MAVEN_HOME=<path to maven 3.9.4> and MAVEN_HOME/bin is added to Path.
* Internet connection or any other in-house maven repository available to download required maven dependencies for this project.
* Clone the code from GitHub public repository below.
  ``` 
  https://github.com/mksolanki/tflcodingchallenge
  ```
### Clone GitHub repository to your local
Please run command below to clone:
  ```
  git clone https://github.com/mksolanki/tflcodingchallenge.git
  ```
### Overview
Java and SpringBoot is used to create REST API.

###### Source Classes Overview
1. RoadController is the main class where REST API mapping is configured.
2. RoadServiceImpl is the class which integrate with Tfl Unified API to get the road status by its id.
3. TflCodingChallengeApplication is spring boot application class to run the application.
4. RoadUtility is the utility class used to build REST API.
5. RoadConstants contains all required costants.
6. RoadNotFoundException is exception class to handle invalid road id.
7. RoadConfiguration is configuration class to configure RestTemplate used to call Tfl Unified API.
8. RoadPropConfiguraiton is a ConfigurationProperties class used to access appId and appKey configured in application.properties file.
9. application.properties contains value for appId and appKey properties.

###### Test Classes Overview
1. RoadControllerTest is the test class for RoadController source class.
2. RoadServiceTest is test class for RoadService source class.

###### REST API URL for this coding challenge
* Below is the new URL for the newly created REST API for this coding challenge.
  ```
  http://{hostname}:{port}/road/{RoadId}/status
  ```
* Below are sample URLs which can be executed using Postman or browser.

    *http://localhost:8080/road/A2/status*

    *http://localhost:8080/road/A406/status*

    *http://localhost:8080/road/A205/status*

    *http://localhost:8080/road/A2mm/status* 
  
### Configuration and Build

* Please ensure to update "road.appId" and "road.appKey" with your values in application.properties available at 2 places below:
    1. ..\tflcodingchallenge\src\main\resources\application.properties
    2. ..\tflcodingchallenge\src\test\resources\application.properties
* Open command prompt or any CLI and goto location tflcodingchallenge where pom.xml file is available.

    Below are maven commands for build, test and package application to jar:
    ```
  1. Command to clean and compile source
      mvn clean compile
  
  2. Command to clean and run test
      mvn clean test

  3. Command to clean and package jar. This command creates TFLCodingChallenge.jar file.
      mvn clean package
  
  4. Command to clean and package jar and exclude tests. This command creates TFLCodingChallenge.jar file excluding tests.
      mvn clean package -DskipTests
  ```
  * Optionally, you can import this source code as maven project in Intellij IDE and run maven commands to build, test and package to create a jar file as well as run the application in Intellij instead of CLI.

### Run the application
Please ensure TFLCodingChallenge.jar is created as per given instruction in "Configuration and Build" section.

* Open command prompt or any CLI and goto location ..\tflcodingchallenge\target where TFLCodingChallenge.jar file is available.
* Next, run the command below to start the application.This command will start the application, and it will be running on default port 8080.
  ```
    java -jar TFLCodingChallenge.jar
  ```




* Below are sample URLs which can be executed using Postman or browser.

    *http://localhost:8080/road/A2/status*

    *http://localhost:8080/road/A406/status*

    *http://localhost:8080/road/A205/status*

    *http://localhost:8080/road/A2mm/status* 

###  Assumptions ###
For the purposes of this coding challenge, I have assumed that:
* When a road id is requested to Tfl Unified API , successful response contains the array of items, however for 
  this coding exercise assumed to use the first item at the index zero.
* No, any security feature is added.
* Payload is in JSON format only.
* Used default 8080 port for running the application.
* I didn't find actual use of appId however it is used as a placeholder only as a requirement.