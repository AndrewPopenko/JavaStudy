package horstman.part.oop.abstract_class;

import java.util.ArrayList;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        people[0] = new Employee("Harry", "Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria", "Morris", "computer since");

        for (Person p : people) {
            System.out.println(p.getFullName() + ", " + p.getDescription());
        }

        Employee employee1 = new Employee("Harry", "Hacker", 50000, 1989, 10, 1);
        Employee employee2 = new Employee("John", "Smith", 55000, 1990, 10, 1);
        Employee employee11 = new Employee("Harry", "Hacker", 50000, 1989, 10, 1);
        Manager manager1 = new Manager("Big", "Boss", 50000, 1989, 10, 1, 5);
        Manager manager2 = new Manager("John", "Smith", 55000, 1990, 10, 1, 5);
        Manager manager11 = new Manager("Big", "Boss", 50000, 1989, 10, 1, 5);
        Student student1 = new Student("Tom", "Hanks", "actor");
        Student student2 = new Student("Bill", "Gates", "computer since");
        Student student11 = new Student("Tom", "Hanks", "actor");


        if (employee1.equals(employee11)) System.out.println("employee1 == employee11");
        if (!employee1.equals(employee2)) System.out.println("employee1 != employee2");

        if (manager1.equals(manager11)) System.out.println("manager1 == manager11");
        if (!manager1.equals(manager2)) System.out.println("manager1 != manager2");

        if (student1.equals(student11)) System.out.println("student1 == student11");
        if (!student1.equals(student2)) System.out.println("student1 != student2");

        if (employee1.hashCode() == employee11.hashCode()) {
            System.out.println("employee1.hashCode() == employee11.hashCode()");
            System.out.println("employee1.hashCode() = " + employee1.hashCode());
            System.out.println("employee11.hashCode() = " + employee11.hashCode() + "\n");
        }

        if (employee1.hashCode() != employee2.hashCode()) {
            System.out.println("employee1.hashCode() != employee2.hashCode()");
            System.out.println("employee1.hashCode() = " + employee1.hashCode());
            System.out.println("employee2.hashCode() = " + employee2.hashCode() + "\n");
        }

        if (manager1.hashCode() == manager11.hashCode()) {
            System.out.println("manager1.hashCode() == manager11.hashCode()");
            System.out.println("manager1.hashCode() = " + manager1.hashCode());
            System.out.println("manager11.hashCode() = " + manager11.hashCode() + "\n");
        }

        if (manager1.hashCode() != manager2.hashCode()) {
            System.out.println("manager1.hashCode() != manager2.hashCode()");
            System.out.println("manager1.hashCode() = " + manager1.hashCode());
            System.out.println("manager2.hashCode() = " + manager2.hashCode() + "\n");
        }

        if (student1.hashCode() == student11.hashCode()) {
            System.out.println("student1.hashCode() == student11.hashCode()");
            System.out.println("student1.hashCode() = " + student1.hashCode());
            System.out.println("student11.hashCode() = " + student11.hashCode() + "\n");
        }

        if (student1.hashCode() != student2.hashCode()) {
            System.out.println("student1.hashCode() != student2.hashCode()");
            System.out.println("student1.hashCode() = " + student1.hashCode());
            System.out.println("student2.hashCode() = " + student2.hashCode() + "\n");
        }

        System.out.println("student1.toString() = " + student1.toString());
        System.out.println("manager1.toString() = " + manager1.toString());
        System.out.println("employee1.toString() = " + employee1.toString());

        System.out.println("student1.toString() = " + student1);
        System.out.println("manager1.toString() = " + manager1);
        System.out.println("employee1.toString() = " + employee1);

        ArrayList<Employee> staff = new ArrayList<Employee>();

        staff.add(employee1);
        staff.add(employee2);
        staff.add(employee11);
        staff.add(manager1);

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.println(e.toString());
        }
    }
}
