package com.spaceship.flightdatabase;

// List of potential Methods:
// - listAllFlights

// - addFlight
// - removeFlight

// - getOpenFlights
// - listOpenFlights
// - getFullFlights
// - listFullFlights

// Method to list all flights (not finished)
//    public static void showFlights (Spaceship[] listOfFlights) {
//        System.out.println(Arrays.toString(listOfFlights));
//    }



// Method to remove person from flight (not finished)
//    public void removePerson (SpaceshipService spaceship1, Person person1) {
//        Person[] passengers = spaceship1.getPassengers();
//        Arrays.asList(passengers).contains(person1.getId());
//        ArrayUtils.remove(passengers, person1);
//    }

import com.spaceship.flight.Flight;
import com.spaceship.person.Person;
import com.spaceship.spaceship.Spaceship;

import java.util.Arrays;
import java.util.UUID;

public class FlightDatabase {
    private Flight[] allFlights;
    private Person[] allUsers;

    public static int count;
    public static int userCount;

    public FlightDatabase(){
        this.allFlights = new Flight[Flight.count];
        this.allUsers = new Person[10];
        this.userCount = 0;
    }

    public void addUser(Person user) {
        allUsers[userCount] = user;
        userCount++;
    }


    //add flight to array and then plus1 to the next spot in the array for the next flight
    public void addFlight(Flight flight1) {
        allFlights[this.count] = flight1;
        this.count++;
        System.out.println("Successfully added flight");
    }



    public void getAllFlights() {
        for (Flight flight: this.allFlights) {
            System.out.println(
                    "Flight Journey = " + flight.getFlightJourney() +
                    ", Spaceship = " + flight.getSpaceship() +
                    ", Seats Taken = " + flight.getNumberOfPassengers()
            );
        }
    }

    public void displayUserFLight(String id){
        boolean flightsExist = false;
        for(Flight flight: this.allFlights){
            for(Person person1:flight.getPassengers()) {
                if(person1 == null) {
                    break;
                }
                if (id.equals(person1.getId())){
                    System.out.println(flight);
                    flightsExist = true;
                }
            }
        }
        if (!flightsExist) {
            System.out.println("No flight booked");
        }
    };

    public void addPerson (Flight flight1, Person person1){
        if (flight1.getNumberOfPassengers() < flight1.getCapacity()){
            Person[] passengers = flight1.getPassengers();
            passengers[flight1.getNumberOfPassengers()] = person1;
            flight1.setNumberOfPassengers(flight1.getNumberOfPassengers()+1);
            System.out.println("Welcome aboard!");
        } else {
            System.out.println("Sorry, we're full");
        }
    }

    public void addPersonUsingID (Flight flight1, String id) {
        Person userToAdd;
        for (Person user : allUsers) {
            if (id.equals(user.getId())) {
                userToAdd = user;
                addPerson(flight1, userToAdd);
                return;
            }
        }
        System.out.println("User not found");
    }

    public Flight getFlightUsingString(String flightName) {
        for (Flight flight: allFlights) {
            if (flightName.equals(flight.getSpaceshipCallSign())) {
                return flight;
            }
        }
        return null;
    }
    public void cancelFLight(Flight flight, String id){
        if (flight == null) {
            System.out.println("Error: flight not found");
            return;
        }
        Person userToRemove;
        for (Person user: allUsers){
            if (id.equals(user.getId())){
                userToRemove = user;
                for(int i = 0; i < flight.getPassengers().length; i++){
                    if(userToRemove.equals(flight.getPassengers()[i])){
                        flight.getPassengers()[i] = null;
                        System.out.println("Your flight has been successfully cancelled");

                        flight.setNumberOfPassengers(0);

                        Person[] updatedPassengers = new Person[flight.getCapacity()];
                        for (Person passenger : flight.getPassengers()) {
                            if (passenger != null) {
                                updatedPassengers[flight.getNumberOfPassengers()] = passenger;
                                flight.setNumberOfPassengers(flight.getNumberOfPassengers() + 1);
                            }
                        }
                        flight.setPassengers(updatedPassengers);
                        return;
                    }
                }
                System.out.println("Error: User not found in flight");
            }
        }

    }

    @Override
    public String toString() {
        return "FlightDatabase{" +
                "allFlights=" + Arrays.toString(allFlights) +
                ", allUsers=" + Arrays.toString(allUsers) +
                '}';
    }
}

