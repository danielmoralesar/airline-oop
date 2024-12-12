package org.ies.airline.componets;

import org.ies.airline.model.Flight;
import org.ies.airline.model.Passenger;

import java.util.Scanner;

public class FlightReader {
    private final Scanner scanner;
    private final PassengerReader passengerReader;

    public FlightReader(Scanner scanner, PassengerReader passengerReader) {
        this.scanner = scanner;
        this.passengerReader = passengerReader;
    }

    public Flight read(){
        System.out.println("Ingrese los datos del vuelo");
        System.out.println("Ingrese el número del vuelo:");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el origen del vuelo:");
        String origin = scanner.nextLine();
        System.out.println("Ingrese el destino del vuelo:");
        String destination = scanner.nextLine();
        System.out.println("Ingrese la puerta de embarque del vuelo:");
        int gateNumber = scanner.nextInt();
        scanner.nextLine();

        int howManyPassengers;
        do {
            System.out.println("¿Cúantos pasajeros tendrá el vuelo?");
            howManyPassengers = scanner.nextInt();
            scanner.nextLine();
            if (howManyPassengers < 1){
                System.out.println("No puede haber un vuelo vacío, inténtelo de nuevo");
            }
        } while (howManyPassengers < 1);

        Passenger[] passengers = new Passenger[howManyPassengers];
        for (int i = 0; i < howManyPassengers; i++) {
            passengers[i] = passengerReader.read();
        }

        return new Flight(
                flightNumber,
                origin,
                destination,
                gateNumber,
                passengers
        );
    }
}
