package laba3.gibdd;

public class Car {
    private String name;
    private int fine;

    public Car(String name, int fine) {
        this.name = name;
        this.fine = fine;
    }

    public String getName() {
        return name;
    }

    public int getFine() {
        return fine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
