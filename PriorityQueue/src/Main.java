import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create a hash map for condition priority.
            CCPHashMap conditions = new CCPHashMap();
            conditions.put("Heart Attack", 5);
            conditions.put("Car Accident", 4);
            conditions.put("Broken Bone", 3);
            conditions.put("Flu", 2);
            conditions.put("Small Cut", 1);

            MaxHeap<Patient> patientMaxHeap = new MaxHeap<>(20);
            Scanner kb = new Scanner(System.in);
            var menu = true;

            while (menu) {
                System.out.println();
                System.out.println("""
                        Welcome to the Patient Intake System,
                        select the option that you need...
                        1. Add a patient.
                        2. Dequeue next patient.
                        3. Exit... """);
                int input = Integer.parseInt(kb.nextLine());

                switch (input) {
                    case 1:
                        System.out.println("What's the patient's name?");
                        var name = kb.nextLine();
                        System.out.println("What's the patient's condition?");
                        var condition = kb.nextLine();
                        var priority = conditions.get(condition);
                        // default priority if no priority is found
                        if (priority == 0) {
                            priority = 1;
                        }
                        Patient patient = new Patient(name, condition, priority);
                        patientMaxHeap.insert(patient);
                        System.out.println("Patient inserted: " + patient);
                        break;
                    case 2:
                        Patient next = patientMaxHeap.extractMax();
                        String message = (next == null) ? "No patients in queue" : "Next patient: " + next;
                        System.out.println(message);
                        break;
                    case 3:
                        System.out.println("Goodbye! ...");
                        menu = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
    }
}
