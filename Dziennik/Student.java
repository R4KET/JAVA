public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private StudentCondition cond;
    private int birthYear;
    private double points;
    private int numerIndeksu;

    public Student(String name, String surname, StudentCondition cond, int birthYear, double points, int numerIndeksu) {
        this.name = name;
        this.surname = surname;
        this.cond = cond;
        this.birthYear = birthYear;
        this.points = points;
        this.numerIndeksu = numerIndeksu;
    }

    public void print() {
        System.out.println("\nImie: " + this.name +
                " \nNazwisko: " + this.surname +
                " \nStan: " + this.cond +
                " \nRok urodzenia: " + this.birthYear +
                " \nIlosc punktow: " + this.points +
                " \nNumer indeksu: " + this.numerIndeksu);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudentCondition getCond() {
        return cond;
    }

    public void setCond(StudentCondition cond) {
        this.cond = cond;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getNumerIndeksu() {
        return numerIndeksu;
    }

    public void setNumerIndeksu(int numerIndeksu) {
        this.numerIndeksu = numerIndeksu;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public int compareTo(Student student) {
        return this.surname.compareTo(student.getSurname());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cond=" + cond +
                ", birthYear=" + birthYear +
                ", points=" + points +
                '}';
    }
}
