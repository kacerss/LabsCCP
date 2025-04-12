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
        // Create a maxHeap and a scanner, initialize with size 20 default.
            MaxHeap<Patient> patientMaxHeap = new MaxHeap<>(20);
            Scanner kb = new Scanner(System.in);
            var menu = true; // variable to keep track of the loop.

            while (menu) {
                System.out.println();
                System.out.println("""
                        Welcome to the Patient Intake System,
                        select the option that you need...
                        1. Add a patient.
                        2. Dequeue next patient.
                        3. Exit... """);
                // take user's input for the menu
                int input = Integer.parseInt(kb.nextLine());

                switch (input) {
                    case 1:
                        System.out.println("What's the patient's name?");
                        var name = kb.nextLine(); // get patient's name
                        System.out.println("What's the patient's condition?");
                        var condition = kb.nextLine(); // get patient's condition
                        var priority = conditions.get(condition); // get condition's priority
                        // default priority if no priority is found
                        if (priority == 0) {
                            System.out.println("Unknown condition.. therefore assigned default priority of 1.");
                            priority = 1;
                        }
                        Patient patient = new Patient(name, condition, priority); // create patient w the information collected.
                        patientMaxHeap.insert(patient); // insert patient into the maxHeap
                        System.out.println("Patient inserted: " + patient);
                        break;
                    case 2:
                        Patient next = patientMaxHeap.extractMax(); // extract the next patient and hold it into a variable
                        String message = (next == null) ? "No patients in queue" : "Next patient: " + next; // check that patient is not null and print the necessary message.
                        System.out.println(message);
                        break;
                    case 3:
                        System.out.println("Goodbye! ...");
                        menu = false; // exit program
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
    }
}
