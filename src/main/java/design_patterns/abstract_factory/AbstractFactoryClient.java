package design_patterns.abstract_factory;

import java.util.Scanner;

public class AbstractFactoryClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String vehicleType = scanner.nextLine().toLowerCase();

        Factory factory;

        try {
            factory = Factory.getFactory(vehicleType);

            Engine engine = factory.getEngine();
            engine.design();
            engine.manufacture();
            engine.test();

            Tyre tyre = factory.getTyre();
            tyre.design();
            tyre.manufacture();
        } catch (UnknownVehicleException e) {
            System.out.println("Invalid vehicle type entered!");
        }

        scanner.close();
    }
}
