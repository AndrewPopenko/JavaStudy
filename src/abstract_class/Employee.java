package abstract_class;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends Person {
    public Employee(String name, String surname, double salary, int year, int month, int day) {
        super(name, surname);

        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public double getSalary() { return salary; }

    public Date getHireDay() { return hireDay; }

    @Override
    public String getDescription() {
        return String.format("Сотрудник с зарплатой $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Employee other = (Employee) otherObject;

        return getFullName().equals(other.getFullName()) && getSalary() ==  other.getSalary() && hireDay.equals(other.hireDay);
    }

    @Override
    public int hashCode() {
        return 7 * getFullName().hashCode() + 11 * new Double(getSalary()).hashCode() + 13 * hireDay.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + "[salary=" + salary + "][hire day=" + hireDay.toString() + "]";
    }

    private double salary;
    private Date hireDay;
}
