class Faculty {
    String name;
    Faculty(String name) {
        this.name = name;
    }
}

class Department {
    String name;
    Department(String name) {
        this.name = name;
    }
}

class University {
    String name;
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();
    University(String name) {
        this.name = name;
    }
    void addDepartment(Department d) {
        departments.add(d);
    }
    void addFaculty(Faculty f) {
        faculties.add(f);
    }
    void deleteUniversity() {
        departments.clear();
    }
}