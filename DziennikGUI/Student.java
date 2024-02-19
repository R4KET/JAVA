public class Student implements Comparable<String> {
    private static int studentID = 0;

    private int id;
    private int birthDate;
    private double points;
    private String name;
    private String surname;
    private int indeks;
    private StudentCondition condition;

    public Student(String name, String surname, StudentCondition condition, int birthDate, double points, int indeks) {
        this.id = studentID;
        this.name = name;
        this.surname = surname;
        this.condition = condition;
        this.birthDate = birthDate;
        this.points = points;
        this.indeks = indeks;
        studentID++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getIndeks() {
        return indeks;
    }

    public StudentCondition getCondition() {
        return condition;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public double getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public void setCondition(StudentCondition condition) {
        this.condition = condition;
    }

    public void setBirthDate(int birthDate) {
        if (birthDate >= 1900) {
            this.birthDate = birthDate;
        }
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void addPoints(double additionalPoints) {
        if (additionalPoints > 0) {
            this.points += additionalPoints;
        }
    }

    public void deductPoints(double pointsToDeduct) {
        if (pointsToDeduct > 0) {
            this.points -= pointsToDeduct;
            if (this.points < 0) {
                this.points = 0.0;
            }
        }
    }

    public void print() {
        System.out.println("Student info:");
        System.out.printf("Imię: %s\nNazwisko: %s\nRok urodzenia: %d\nStan: %s\nPunkty: %.2f\nNumer Indeksu: %s\n",
                name,
                surname, birthDate, condition, points, indeks);
    }

    @Override
    public int compareTo(String other) {
        return this.surname.compareTo(other);
    }
}
