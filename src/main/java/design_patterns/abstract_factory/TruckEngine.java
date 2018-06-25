package design_patterns.abstract_factory;

public class TruckEngine implements Engine {
    @Override
    public void design() {
        System.out.println("Designing Truck Engine");
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing Truck Engine");
    }

    @Override
    public void test() {
        System.out.println("Testing Truck Engine");
    }
}
