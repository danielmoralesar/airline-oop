package org.ies.airline;

import org.ies.airline.componets.*;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var passengerReader = new PassengerReader(scanner);
        var flightReader = new FlightReader(scanner, passengerReader);
        var airlineReader = new AirlineReader(scanner, flightReader);
        var AirlineAppMenu = new AirlineAppMenu(airlineReader, scanner);

        System.out.println("¡Bienvenido!");
        AirlineAppMenu.run();
    }
}