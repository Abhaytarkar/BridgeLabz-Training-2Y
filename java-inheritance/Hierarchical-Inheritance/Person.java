class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolTest {
    public static void main(String[] args) {
        Teacher t = new Teacher("Mrs. Kapoor", 40, "Mathematics");
        Student s = new Student("Riya", 16, "10th Grade");
        Staff st = new Staff("Mr. Verma", 35, "Administration");

        System.out.println("-----");
        t.displayDetails();
        t.displayRole();

        System.out.println("-----");
        s.displayDetails();
        s.displayRole();

        System.out.println("-----");
        st.displayDetails();
        st.displayRole();
    }
}