package laba3;

import laba3.gibdd.Car;
import laba3.gibdd.GIBBD;
import laba3.gibdd.Inspector;

import java.util.Scanner;

public class Laba3 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер отдела ГИББД: ");
        int numberOfDep = scanner.nextInt();
        GIBBD gibbd = new GIBBD(numberOfDep);

        System.out.print("Сколько хотите добавить инспекторов в отдел: ");
        int numOfInspectors = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOfInspectors; i++) {
            System.out.print((i+1) + "# Имя инспектора: ");
            String name = scanner.nextLine().trim();
            System.out.print((i+1) + "# Размер зарплаты: ");
            int salary = scanner.nextInt();
            scanner.nextLine();
            Inspector newInspector = new Inspector(name, salary);

            gibbd.addNewInspector(newInspector);
        }

        System.out.println();

        System.out.print("Сколько хотите добавить оштрафованых машин: ");
        int numOfFined = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOfFined; i++) {
            System.out.print((i+1) + "# Название машины: ");
            String name = scanner.nextLine();

            System.out.print((i+1) + "# Размер штрафа: ");
            int fine = scanner.nextInt();
            scanner.nextLine();
            Car finedCar = new Car(name, fine);

            gibbd.addFinedCar(finedCar);
        }

        System.out.println("\n---------------------------------------");
        System.out.println("ОТДЕЛ ГИББД №" + gibbd.getNumberOfDepartment());
        gibbd.printFinedCars();

        System.out.println();

        gibbd.printListOfInspectors();
        System.out.println("---------------------------------------\n");

        System.out.print("Введите имя инспектора, которого нужно найти в базе: ");
        String name = scanner.nextLine().trim();
        System.out.print("\tего зарплата: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        Inspector findInspector = new Inspector(name, salary);
        int foundedIdx = gibbd.findInspector(findInspector);

        System.out.println("---------------------------------------");

        if (foundedIdx != -1) {
            System.out.println("Инспектор - " + findInspector.getName() + " - с з/п " + findInspector.getSalary() + " есть в базе данных!");
        } else {
            System.out.println("Инспектора - " + findInspector.getName() + " - с з/п " + findInspector.getSalary() + " - нет в базе данных!");
        }
    }
}
