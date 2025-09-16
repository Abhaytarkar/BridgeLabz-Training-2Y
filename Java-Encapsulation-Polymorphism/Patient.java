abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return patientId + " - " + name + ", Age: " + age;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private String records;

    public InPatient(String patientId, String name, int age, double roomCharge) {
        super(patientId, name, age);
        this.roomCharge = roomCharge;
        this.records = "";
    }

    public double calculateBill() {
        return roomCharge + 2000;
    }

    public void addRecord(String record) {
        records += record + "\n";
    }

    public String viewRecords() {
        return records;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String records;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = "";
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        records += record + "\n";
    }

    public String viewRecords() {
        return records;
    }
}