class Patient {
    String name;
    List<Doctor> doctors = new ArrayList<>();
    Patient(String name) {
        this.name = name;
    }
    void consultDoctor(Doctor d) {
        doctors.add(d);
        d.patients.add(this);
        d.consult(this);
    }
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();
    Doctor(String name) {
        this.name = name;
    }
    void consult(Patient p) {
        System.out.println(name + " is consulting " + p.name);
    }
}

class Hospital {
    String name;
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();
    Hospital(String name) {
        this.name = name;
    }
    void addDoctor(Doctor d) {
        doctors.add(d);
    }
    void addPatient(Patient p) {
        patients.add(p);
    }
}