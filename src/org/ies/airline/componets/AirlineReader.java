package org.ies.airline.componets;

import org.ies.airline.model.Airline;
import org.ies.airline.model.Flight;

import java.util.Scanner;

public class AirlineReader {
    private final Scanner scanner;
    private final FlightReader flightReader;

    public AirlineReader(Scanner scanner, FlightReader flightReader) {
        this.scanner = scanner;
        this.flightReader = flightReader;
    }

    public Airline read(){
        System.out.println("Ingrese los datos de la aerolinea");
        System.out.println("Ingrese el nombre de la aerolinea:");
        String name = scanner.nextLine();

        int howManyFlights;
        do{
            System.out.println("¿Cúantos vuelos tiene la aerolinea?");
            howManyFlights = scanner.nextInt();
            scanner.nextLine();
            if (howManyFlights < 1){
                System.out.println("Debe haber mínimo un vuelo");
            }
        } while (howManyFlights < 1);

        Flight[] flights = new Flight[howManyFlights];
        for (int i = 0; i < howManyFlights; i++) {
            flights[i] = flightReader.read();
        }

        return new Airline(
                name,
                flights
        );
    }
}
