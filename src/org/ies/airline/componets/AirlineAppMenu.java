package org.ies.airline.componets;

import org.ies.airline.model.Airline;

import java.util.Scanner;

public class AirlineAppMenu {
    private final AirlineReader airlineReader;
    private final Scanner scanner;

    public AirlineAppMenu(AirlineReader airlineReader, Scanner scanner) {
        this.airlineReader = airlineReader;
        this.scanner = scanner;
    }

    public void run() {
        var airline = airlineReader.read();

        int option;
        do {
            option = askOption();
            if (option == 1) {
                option1(airline);
            } else if (option == 2) {
                option2(airline);
            } else if (option == 3) {
                option3(airline);
            } else if (option == 4) {
                option4(airline);
            } else if (option == 5) {
                option5(airline);
            } else {
                System.out.println("¡Hasta luego!");
            }
        } while (option != 6);
    }

    private void option5(Airline airline) {
        int flightNumber = askFlightNumber();
        var flight = airline.findFlight(flightNumber);
        String nif = askNif();
        Integer seat = askSeatNumber();
        if (flight != null) {
            airline.changeSeat(nif, seat, flight);
        } else {
            System.out.println("Error, vuelo no encontrado");
        }
    }

    private void option4(Airline airline) {
        int flightNumber = askFlightNumber();
        String nif = askNif();
        Integer seat = airline.findPassengerSeat(flightNumber, nif);
        if (seat != null) {
            System.out.println("El asieto asignado es: " + seat);
        } else {
            System.out.println("Error: el vuelo no existe o el pasajero no está registrado en el vuelo");
        }
    }

    private void option3(Airline airline) {
        String nif = askNif();
        airline.showPassengerFlights(nif);
    }

    private void option2(Airline airline) {
        System.out.println("Ingrese un origen: ");
        String origin = scanner.nextLine();
        airline.showOriginFlights(origin);
    }

    private static void option1(Airline airline) {
        for (var flight : airline.getFlights()) {
            flight.showInfo();
        }
    }

    private int askOption() {
        int option;
        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Mostrar todos los vuelos");
            System.out.println("2. Mostrar vuelos por origen");
            System.out.println("3. Mostrar vuelos de un pasajero");
            System.out.println("4. Mostrar asiento de un pasajero");
            System.out.println("5. Cambian asiento de un pasajero");
            System.out.println("6. Salir");
            option = scanner.nextInt();
            scanner.nextLine();
            if (option < 1 || option > 6) {
                System.out.println("Error: opción inválida, inténtelo de nuevo");
            }
        } while (option < 1 || option > 6);
        return option;
    }

    private String askNif() {
        System.out.println("Ingrese el NIF de un pasajero");
        return scanner.nextLine();
    }

    private int askFlightNumber() {
        System.out.println("Ingrese un número de vuelo: ");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        return flightNumber;
    }

    private Integer askSeatNumber() {
        int seat;
        do {
            System.out.println("Ingrese un número de asiento");
            seat = scanner.nextInt();
            scanner.nextLine();
            if (seat < 1 || seat > 99) {
                System.out.println("El asiento debe ser entre 1 y 99");
            }
        } while (seat < 1 || seat > 99);
        return seat;
    }
}
