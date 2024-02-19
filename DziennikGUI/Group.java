import java.util.*;

public class Group {
    private static final int MAX_STUDENTS = 16;

    private String courseName;
    private List<Student> students;
    private double capacityRatio;

    public Group(String courseName, double capacityRatio) throws IllegalArgumentException {
        if(capacityRatio <= 0.0 || capacityRatio > 1.0) {
            throw new IllegalArgumentException("Bledna pojemnosc");
        }
        this.courseName = courseName;
        this.capacityRatio = capacityRatio;
        this.students = new ArrayList<>();
    }

    public boolean enrollStudent(Student student) {
        if(students.size() >= (int)(MAX_STUDENTS * capacityRatio)) {
            System.err.println("Liczba studentow przekroczona");
            return false;
        }
        if(students.contains(student)) {
            System.out.println("Ten student juz istnieje");
            return false;
        }
        students.add(student);
        return true;
    }

    public boolean increaseStudentPoints(Student student, double points) {
        if(!students.contains(student)) {
            return false;
        }
        student.addPoints(points);
        return true;
    }

    public Student retrieveStudent(Student student) {
        if(student.getPoints() <= 0.0) {
            System.out.println("Usun studenta");
            students.remove(student);
        }
        return student;
    }

    public boolean updateCondition(Student student, StudentCondition condition) {
        if(!students.contains(student)) {
            return false;
        }
        student.setCondition(condition);
        return true;
    }

    public boolean decreaseStudentPoints(Student student, double points) {
        if(!students.contains(student)) {
            return false;
        }
        student.deductPoints(points);
        return true;
    }

    public Student findStudent(String surname) {
        return students.stream().filter(student -> student.getSurname().equals(surname)).findFirst().orElse(null);
    }

    public ArrayList<Student> findStudents(String phrase) {
        ArrayList<Student> result = new ArrayList<>();
        for(Student student : students) {
            if(student.getSurname().toLowerCase().contains(phrase.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    public int countStudentsByCondition(StudentCondition condition) {
        return (int) students.stream().filter(student -> student.getCondition() == condition).count();
    }

    public void displaySummary() {
        students.forEach(Student::print);
    }

    public List<Student> sortStudentsBySurname() {
        students.sort(Comparator.comparing(Student::getSurname));
        return students;
    }

    public List<Student> sortStudentsByPoints() {
        students.sort(Comparator.comparingDouble(Student::getPoints));
        return students;
    }

    public List<Student> sortStudentsByIndexNumber() {
        students.sort(Comparator.comparing(Student::getIndeks));
        return students;
    }

    public Student getTopScoringStudent() {
        return students.stream().max(Comparator.comparingDouble(Student::getPoints)).orElse(null);
    }

    public int getStudentCount() {
        return students.size();
    }

    public double getCapacityRatio() {
        return capacityRatio;
    }

    public double getCurrentRatio() {
        return (double) getStudentCount() / (double) MAX_STUDENTS;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void removeStudentById(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
