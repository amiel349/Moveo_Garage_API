# Moveo_Garage_Rest_API

### Author : Amiel Lejzor

## Decription

This project represent a Garage Managment System.
The garge can manage various types of vehicles while each car has its own properties.

## Installation
For installing the garage system please follow the instructions below:
* Clone this repository.
* open this project in your IDE 
* Run the RestServiceApplication class
* After running the application you will need a client platform like Postman (its better to use the Desktop version) 

## API
*POST*
  To add a new car to the garage,  choose POST, type this url http://localhost:8080/api/1.0/vehicle/{typeCarNumber}
  and add the corresponding number for each vehicle type
  0- Regular motorcycle
  1- Electric motorcycle
  2- Regular car
  3- Electric car
  4- Truck
  then in the body section you choose **raw** and fill the following JSON format
     
      { "modelName": String,
      "licenseNumber": Number (long),
      "energyPercentage": number,
      "tirePressure": number,
      "maxTirePressure": number}
      
      for axample:
      { "modelName": "Ferrari",
      "licenseNumber": 777777,
      "energyPercentage": 78,
      "tirePressure": 30,
      "maxTirePressure": 32 }
      
 
  **put**
  1) To Inflate a the tires to the max pressure choose PUT and type this url http://localhost:8080/api/1.0/vehicle/{lisenceNumber}
  and insert in the brackets in the end the correct lisence number of the car
  note that its impossible to pass the maximum tire pressure.
  2) To  Add energy choose PUT and type this url http://localhost:8080/api/1.0/vehicle/{lisenceNumber}/{energy}
  and insert in the brackets the lisence number of the car and the amount of energy to add
  note that its impossible to pass the 100% of energy.
  
  **get**
  1) To get a car form the garage choose GET and type this url http://localhost:8080/api/1.0/vehicle/{lisenceNumber}
  and insert in the brackets in the end the correct lisence number of the car.
  2) To get all the cars in the garage choose GET and type this url http://localhost:8080/api/1.0/vehicle
  
  **delete**
  1) To delete a car form the garage choose DELETE and type this url http://localhost:8080/api/1.0/vehicle/{lisenceNumber}
  and insert in the brackets in the end the correct lisence number of the car.
  2) To get all the cars in the garage choose DELETE and type this url http://localhost:8080/api/1.0/vehicle
  
  ## Tests
  This ptoject includes a Junits tests : RestServiceApplicationTests
  To run the tests go to the directory - Test -and run this class 




