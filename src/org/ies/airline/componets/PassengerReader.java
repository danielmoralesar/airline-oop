package org.ies.airline.componets;

import org.ies.airline.model.Passenger;

import java.util.Scanner;

public class PassengerReader {
    private final Scanner scanner;

    public PassengerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Passenger read(){
        System.out.println("Ingrese los datos del pasajero");
        System.out.println("Ingrese el NIF del pasajero:");
        String nif = scanner.nextLine();
        System.out.println("Ingrese el nombre del pasajero:");
        String name = scanner.nextLine();
        System.out.println("Ingrese los apellidos del pasajero");
        String surName = scanner.nextLine();
        System.out.println("Ingrese el número de su asiento");
        Integer seatNumber = scanner.nextInt();
        scanner.nextLine();

        return new Passenger(
                nif,
                name,
                surName,
                seatNumber
        );
    }
}
