public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("Jan", "Kowalski", StudentCondition.NIEOBECNY, 1999, 100, 424100);
        Student s2 = new Student("Stanislaw", "Nowak", StudentCondition.CHORY, 1999, 50, 424101);
        Student s3 = new Student("Robert", "Lis", StudentCondition.CHORY, 1999, -50, 424191);

        Class c1 = new Class("grupa 1", 50);
        Class c2 = new Class("grupa 2", 20);
        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);
        c1.addStudent(new Student("x", "y", StudentCondition.NIEOBECNY, 2000, 20, 424102));
        c1.changeCondition(s1, StudentCondition.CHORY);
        System.out.println(c1.countByCondition(StudentCondition.CHORY));

        ClassContainer container = new ClassContainer();
        container.addClass(c1);
        container.addClass(c2);
        System.out.println(c1.countStudents());
        System.out.println(container.findEmpty());
        container.summary();
        container.removeClass("c2");
        container.summary();


        System.out.println(s1.getNumerIndeksu());
        s2.print();

    }
}
