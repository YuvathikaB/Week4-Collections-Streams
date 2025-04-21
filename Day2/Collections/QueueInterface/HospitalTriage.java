package queueInterface;
import java.util.PriorityQueue;
import java.util.Scanner;
class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    public String getName() {
        return name;
    }
    public int getSeverity() {
        return severity;
    }
    @Override
    public String toString() {
        return "(" + name + ", " + severity + ")";
    }
}
public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of patients : ");
        int numPatients = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        for (int i = 0; i < numPatients; i++) {
            System.out.print("Enter patient name : ");
            String name = scanner.nextLine();
            System.out.print("Enter severity level (1-5, 5 is highest) : ");
            int severity = scanner.nextInt();
            scanner.nextLine();
            triageQueue.offer(new Patient(name, severity));
            System.out.println();
        }
        System.out.println("\nTreating patients based on priority:");
        while (!triageQueue.isEmpty()) {
            Patient nextPatient = triageQueue.poll();
            System.out.println("Treating : " + nextPatient.getName() + " (Severity : " + nextPatient.getSeverity() + ")");
        }
        scanner.close();
    }
}
