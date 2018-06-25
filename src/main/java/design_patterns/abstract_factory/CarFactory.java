package design_patterns.abstract_factory;

public class CarFactory extends Factory {
    @Override
    public Engine getEngine() {
        return new CarEngine();
    }

    @Override
    public Tyre getTyre() {
        return new CarTyre();
    }
}
