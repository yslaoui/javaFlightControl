package flightControl.logic;

import com.sun.security.jgss.GSSUtil;
import flightControl.domain.Airplane;
import flightControl.domain.Flight;
import flightControl.domain.Place;

import java.util.HashMap;
import java.util.Map;

public class FlightManager {
    private int flightNumber;
    private Map<String, Airplane> airplanes;
    private Map<String, Place> places;
    private Map<Integer, Flight> flights;

    public FlightManager() {
        this.airplanes = new HashMap<>();
        this.places = new HashMap<>();
        this.flights = new HashMap<>();
        flightNumber = 0;
    }

    public Map<String, Airplane> getAirplanes() {
        return airplanes;
    }

    public Map<String, Place> getPlaces() {
        return places;
    }

    public Map<Integer, Flight> getFlights() {
        return flights;
    }

    public void addAirplane(String id, int capacity) {
        this.airplanes.put(id, new Airplane(id, capacity));
    }

    public void addFlight(String airplaneId, String departureAirportId, String destinationAirportId) {
        Airplane airplane = this.airplanes.getOrDefault(airplaneId, null);
        Place departure =  new Place(departureAirportId);
        Place destination = new Place(destinationAirportId);
        Flight flight = new Flight(airplane, departure, destination);
        flights.putIfAbsent(flightNumber, flight);
        places.putIfAbsent(departure.getId(), departure);
        places.putIfAbsent(destination.getId(), destination);
        this.flightNumber += 1;
    }

    public void printAirPlanes() {
        for (Airplane airplane : this.airplanes.values()) {
            System.out.println(airplane);
        }
    }

    public void printFlights() {
        for (Flight flight: this.flights.values()) {
            System.out.println(flight);
        }
    }
}
