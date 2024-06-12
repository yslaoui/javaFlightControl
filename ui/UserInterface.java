package flightControl.ui;

import flightControl.domain.Airplane;
import flightControl.logic.FlightManager;

import java.util.Scanner;

public class UserInterface {

    String airplaneId;
    int airPlaneCapacity;
    String departureAirportId;
    String destinationAirportId;
    FlightManager flightManager;

    public UserInterface() {

        flightManager = new FlightManager();

        System.out.println("Choose an action");
        System.out.println("[1] Add an airplane");
        System.out.println("[2] Add a flight");
        System.out.println("[3] Print airplanes");
        System.out.println("[4] Print flights");
        System.out.println("[5] Print airplane details");
        System.out.println("[x] Exit Airport Asset Control");




        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();

        while(!(choice.equals("x"))) {

            if (!(choice.equals("1")
                    || !(choice.equals("2"))
                    || !(choice.equals("3"))
                    || !(choice.equals("4"))
                    || !(choice.equals("5")))) {
                System.out.println("Choices must be either 1 or 2");
            }

            if (choice.equals("1")) {
                // Adding airplane
                System.out.println("Give the airplane id:");
                airplaneId = in.nextLine();

                System.out.println("Give the airplane capacity");
                airPlaneCapacity = Integer.parseInt(in.nextLine());

                this.flightManager.addAirplane(airplaneId, airPlaneCapacity);
                System.out.println("Choose an action");
                choice = in.nextLine();
            }

            if (choice.equals("2")) {
                // Adding flight
                System.out.println("Give the airplane id:");
                airplaneId = askForAirPlane(in);
                System.out.println("Give the departure airport id");
                departureAirportId = in.nextLine();
                System.out.println("Give the destination airport id");
                destinationAirportId = in.nextLine();
                this.flightManager.addFlight(airplaneId,
                                        departureAirportId,
                                        destinationAirportId);
                System.out.println("Choose an action");
                choice = in.nextLine();
            }

            if (choice.equals("3")) {
                this.flightManager.printAirPlanes();
                System.out.println("Choose an action");
                choice = in.nextLine();
            }

            if (choice.equals("4")) {
                this.flightManager.printFlights();
                System.out.println("Choose an action");
                choice = in.nextLine();
            }
            if (choice.equals("5")) {
                System.out.println("Give the airplane id:");
                airplaneId = askForAirPlane(in);
                System.out.println(this.flightManager.getAirplanes().get(airplaneId));
                System.out.println("Choose an action");
                choice = in.nextLine();
            }
        }


    }

    private String askForAirPlane(Scanner in) {
        airplaneId = in.nextLine();
        while(!(this.flightManager.getAirplanes().containsKey(airplaneId))) {
            System.out.println("Airplane not found. Please enter a valid airplane id");
            airplaneId = in.nextLine();
        }
        return airplaneId;
    }
}



