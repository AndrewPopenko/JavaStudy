package abstract_class;

public class Student extends Person {
    public Student(String name, String surname, String major) {
        super(name, surname);

        this.major = major;
    }

    @Override
    public String getDescription() {
        return "студент, изучающий " + major;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Student other = (Student) otherObject;

        return getName().equals(other.getName()) && getSurname().equals(other.getSurname()) && major.equals(other.major);
    }

    @Override
    public int hashCode() {
        return 7 * getName().hashCode() + 11 * getSurname().hashCode() + 13 * major.hashCode();
    }

    private String major;
}
