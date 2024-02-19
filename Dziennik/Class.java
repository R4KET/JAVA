import java.util.*;

public class Class {
    private String className;
    private List<Student> studentList;
    private double maxCount;

    public Class(String className, double maxCount) {
        this.className = className;
        this.maxCount = maxCount;
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (this.studentList.contains(student)) {
            System.out.println("Student o takim nazwisku juz istnieje.");
        }
        if (this.studentList.size() - 1 < maxCount) {
            studentList.add(student);
        } else {
            System.err.println("Pojemnosc zostala przekroczona");
        }
    }

    public void addPoints(Student student, double points) {
        double current = this.studentList.get(this.studentList.indexOf(student)).getPoints();
        this.studentList.get(this.studentList.indexOf(student)).setPoints(current + points);
    }

    public void getStudent(Student student) {
        this.studentList.remove(student);
        if (student.getPoints() <= 0) {
            student = null;
        }
    }

    public void changeCondition(Student student, StudentCondition cond) {
        this.studentList.get(this.studentList.indexOf(student)).setCond(cond);
    }

    public void removePoints(Student student, double points) {
        double current = this.studentList.get(this.studentList.indexOf(student)).getPoints();
        this.studentList.get(this.studentList.indexOf(student)).setPoints(current - points);
    }

    public Student search(String surname) {
        return this.studentList.stream()
                .filter(student -> student.getSurname().equals(surname))
                .findAny()
                .orElse(null);
    }

    public ArrayList<Student> searchPartial(String part) {
        ArrayList<Student> result = new ArrayList<>();

        this.studentList.stream()
                .filter(student -> student.getName().contains(part))
                .forEach(student -> result.add(student));

        this.studentList.stream()
                .filter(student -> student.getSurname().contains(part))
                .forEach(student -> result.add(student));

        return result;
    }

    public long countByCondition(StudentCondition cond) {
        return this.studentList.stream()
                .filter(student -> student.getCond().equals(cond))
                .count();
    }

    public void summary() {
        this.studentList.stream()
                .forEach(student -> student.print());
    }

    public void sortByNames() {
        this.studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(student -> student.print());
    }

    public void sortByPoints() {
        this.studentList.stream()
                .sorted(Comparator.comparing(Student::getPoints).reversed())
                .forEach(student -> student.print());
    }

    public Student max() {
        return Collections.max(this.studentList);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public double getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(double maxCount) {
        this.maxCount = maxCount;
    }

    public int countStudents() {
        return this.studentList.size();
    }
}
