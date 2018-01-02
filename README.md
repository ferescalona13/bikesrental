# Project Title

Bikes Rental for FDV

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

##Design
The app was developed with SpringBoot
A main class BikesrentalApplication which has a main method

A package called "controller" which has a RestController class BikeRentalRestController with a method called rent to simmulate a bike rental with a RequestMethod POST

A package called "model" with a set of classes to model the domain and logic
	*An abstract class BikeRental with a method to get the price of a rental
	*An interface Rental with a method called rent()
	*An interface FamilyRental with a default method called applyDiscount()
	*Three classes BikeRentalByDay, BikeRentalByHour, BikeRentalByWeek which extends from BikeRental 	and implements Rental, to model the rents depending of the amount of time
	*A class FamilyBikeRental which implements Rental and FamilyRental
	*A class Client to set the data of the client who rents a bike

A package called "exception" with a class NotValidSizeOfRentalsException which extends from Exception to try the cases of invalid number of rentals in a Family Rental.

A set of test classes, all test run with JUnit 4
	*BikeRentalRestControllerTest to test the RestController method rent
	*BikeRentalByDayTest, BikeRentalByHourTest, BikeRentalByWeekTest to test the value of the rental 	is valid
	*FamilyRentalTest which has two tests, one to validate the value of the family rental with the 	disccount, and other to test the NotValidSizeOfRentalsException

## Deployment

Run startup.sh to run the app, and run the tests

## Built With

* [Springboot](https://projects.spring.io/spring-boot/) - The framework used
* [Maven](https://maven.apache.org/) - Dependency Management and building

## Authors

* **Fernando Escalona** 


