public class Patient implements Comparable<Patient> {
    private final String name;
    private final String condition;
    private int priority;

    Patient(String patientsName, String condition){
        this.name = patientsName;
        this.condition = condition;
    }

    Patient(String patientsName, String condition, int priority){
        this.name = patientsName;
        this.condition = condition;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient's Name: '" + name + '\'' +
                ", condition: '" + condition + '\'' +
                ", priority level: " + priority;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.priority, other.priority);
    }
}
