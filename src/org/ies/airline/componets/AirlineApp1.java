package org.ies.airline.componets;

import java.util.Scanner;

public class AirlineApp1 {
    private final Scanner scanner;
    private final AirlineReader airlineReader;

    public AirlineApp1(Scanner scanner, AirlineReader airlineReader) {
        this.scanner = scanner;
        this.airlineReader = airlineReader;
    }

    public void run() {
        var airline = airlineReader.read();

        System.out.print("Ingrese el número de un vuelo: ");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        var flight = airline.findFlight(flightNumber);
        if (flight != null) {
            System.out.print("Ingrese el NIF de un pasajero: ");
            String nif = scanner.nextLine();
            System.out.println("Ahora, ingrese el número del asiento que desee cambiar");
            Integer seatNumber = scanner.nextInt();
            airline.changeSeat(nif, seatNumber, flight);
        } else {
            System.out.println("Error, vuelo no encontrado");
        }

    }
}
