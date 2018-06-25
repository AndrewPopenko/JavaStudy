package horstman.clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class CloneTest {
    public static void main(String[] args) {

        try {
            Employee original = new Employee("John Q. public", 50000);
            original.setHireDate(2000, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDate(2002, 12, 31);
            System.out.println("original = " + original);
            System.out.println("copy = " + copy);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    static class Employee implements Cloneable {
        Employee(String name, double s) {
            fullName = name;
            salary = s;
            hireDate = new Date();
        }

        public Employee clone() throws CloneNotSupportedException {
            // call Object.clone()
            Employee cloned = (Employee) super.clone();

            cloned.hireDate = new Date();

            return cloned;
        }

        /*
         * Set date of hire
         * @param year
         * @param month
         * @param day
         */
        public void setHireDate(int year, int month, int day) {
            hireDate = new GregorianCalendar(year, month - 1, day).getTime();
        }

        public void raiseSalary(double byPercent) {
            double raise = salary * byPercent / 100;
            salary += raise;
        }

        public String toString() {
            return "Employee[name = " + fullName + ", salary = " + salary + ", hireDay = " + hireDate + "]";
        }

        Date hireDate;
        String fullName;
        double salary;
    }
}
