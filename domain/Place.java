package flightControl.domain;

public class Place {
    private String id;

    public Place(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
