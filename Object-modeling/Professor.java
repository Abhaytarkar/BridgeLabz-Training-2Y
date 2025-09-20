class Professor {
    String name;
    Professor(String name) {
        this.name = name;
    }
    void assignCourse(Course c) {
        c.professor = this;
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();
    Student(String name) {
        this.name = name;
    }
    void enrollCourse(Course c) {
        courses.add(c);
        c.students.add(this);
    }
}

class Course {
    String name;
    Professor professor;
    List<Student> students = new ArrayList<>();
    Course(String name) {
        this.name = name;
    }
}