package laba3.gibdd;

import laba3.linkedList.LinkedList;
import laba3.stack.Stack;

public class GIBBD {
    private int numberOfDepartment;
    private Stack<Car> finedCars = new Stack<>();
    private LinkedList<Inspector> inspectors = new LinkedList<>();

    public GIBBD( int numberOfDepartment) {
        this.numberOfDepartment = numberOfDepartment;
    }

    public void addFinedCar(Car car) {
        finedCars.push(car);
    }

    public void printFinedCars() {
        System.out.println("Оштрафованные машины (сначала недавние): ");
        int i = 1;
        while (finedCars.size() != 0) {
            Car car = finedCars.pop();
            System.out.println("МАШИНА №" + (i++) + ": " + car.getName() + ", размер штрафа: " + car.getFine() + ".");
        }
    }

    public void addNewInspector(Inspector inspector) {
        inspectors.addToEnd(inspector);
    }

    public int findInspector(Inspector inspector) {
        return inspectors.indexOf(inspector);
    }


    public void printListOfInspectors() {
        for(int i = 0; i < inspectors.getSize(); i++) {
            Inspector inspector = inspectors.get(i);
            System.out.println("Список инспекторов: ");
            System.out.println("Инспектор №" + (i+1) + ": " + "имя - " + inspector.getName() + ", зарплата - " + inspector.getSalary() + ". ");
        }
    }

    public int getNumberOfDepartment() {
        return numberOfDepartment;
    }

    public void setNumberOfDepartment(int numberOfDepartment) {
        this.numberOfDepartment = numberOfDepartment;
    }

}
