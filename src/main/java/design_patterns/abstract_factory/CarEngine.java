package design_patterns.abstract_factory;

public class CarEngine implements Engine {
    @Override
    public void design() {
        System.out.println("Designing Car Engine");
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing Car Engine");
    }

    @Override
    public void test() {
        System.out.println("Testing Car Engine");
    }
}
