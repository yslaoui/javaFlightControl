package flightControl.domain;

public class Flight {

    Airplane airplane;
    Place departurePlace;
    Place destinationPlace;

    public Flight(Airplane airplane, Place departurePlace, Place destinationPlace) {
        this.airplane = airplane;
        this.departurePlace = departurePlace;
        this.destinationPlace = destinationPlace;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Place getDeparturePlace() {
        return departurePlace;
    }

    public Place getDestinationPlace() {
        return destinationPlace;
    }

    @Override
    public String toString() {
        return this.airplane
                + "(" + this.departurePlace + "-"
                + this.destinationPlace + ")";
    }
}


