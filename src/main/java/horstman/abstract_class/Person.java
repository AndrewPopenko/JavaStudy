package horstman.abstract_class;

public abstract class Person {
    public Person(String name, String surname) { this.name = name; this.surname = surname; }
    public String getName() { return name;}
    public String getSurname() { return surname; }
    public String getFullName() {return name + " " + surname; }

    public abstract String getDescription();

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + "]" + "[surname=" + surname + "]";
    }

    private String name;
    private String surname;
}
