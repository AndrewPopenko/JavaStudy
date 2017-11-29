package abstract_class;

public class Manager extends Employee {
    public Manager(String name, String surname, double salary, int year, int month, int day, double bonus) {
        super(name, surname, salary, year, month, day);

        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;

        Manager other = (Manager) otherObject;
        return  bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 15 * new Double(bonus).hashCode();
    }

    double bonus;
}
