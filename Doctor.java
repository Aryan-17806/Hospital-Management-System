package HMP;

public class Doctor {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String specialty;

    public Doctor(String name, String specialty) {
        this.id = idCounter++;
        this.name = name;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Specialty: " + specialty;
    }
}
