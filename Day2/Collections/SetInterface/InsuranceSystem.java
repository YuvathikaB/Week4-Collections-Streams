package setInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return this.policyNumber.equals(p.policyNumber);
    }
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    public String toString() {
        return policyNumber +"\n" + policyholderName + " \n " + expiryDate + " \n " + coverageType + " \n " + premiumAmount;
    }
}
public class InsuranceSystem {
    static Set<Policy> hashSet = new HashSet<>();
    static Set<Policy> linkedHashSet = new LinkedHashSet<>();
    static Set<Policy> treeSet = new TreeSet<>();
    static Scanner sc = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static void addPolicy() {
        System.out.print("Policy Number: ");
        String number = sc.next();
        System.out.print("Policyholder Name: ");
        String name = sc.next();
        System.out.print("Expiry Date (yyyy-MM-dd): ");
        LocalDate expiry = LocalDate.parse(sc.next(), formatter);
        System.out.print("Coverage Type: ");
        String coverage = sc.next();
        System.out.print("Premium Amount: ");
        double premium = sc.nextDouble();
        Policy p = new Policy(number, name, expiry, coverage, premium);
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }
    public static void displayPolicies(Set<Policy> set) {
        if (set.isEmpty()) {
            System.out.println("No policies available.");
        }
        for (Policy p : set) {
            System.out.println(p);
        }
    }
    public static void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        boolean found = false;
        for (Policy p : treeSet) {
            if (!p.expiryDate.isAfter(limit)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies are expiring within the next 30 days.");
        }
    }
    public static void policiesByCoverageType() {
        System.out.print("Enter Coverage Type to filter: ");
        String type = sc.next();
        boolean found = false;
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies found for coverage type: " + type);
        }
    }
    public static void findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        boolean foundDuplicate = false;
        for (Policy p : hashSet) {
            if (!seen.add(p.policyNumber)) {
                System.out.println("Duplicate Policy: " + p);
                foundDuplicate = true;
            }
        }
        if (!foundDuplicate) {
            System.out.println("No duplicate policies found.");
        }
    }
    public static void performanceComparison() {
        List<Policy> testData = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            testData.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i), "Auto", i * 100));
        }
        long start, end;
        start = System.nanoTime();
        Set<Policy> hs = new HashSet<>(testData);
        end = System.nanoTime();
        System.out.println("HashSet add time: " + (end - start));
        start = System.nanoTime();
        Set<Policy> lhs = new LinkedHashSet<>(testData);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (end - start));
        start = System.nanoTime();
        Set<Policy> ts = new TreeSet<>(testData);
        end = System.nanoTime();
        System.out.println("TreeSet add time: " + (end - start));
        Policy searchPolicy = new Policy("P9999", "Dummy", LocalDate.now(), "Auto", 0);
        start = System.nanoTime();
        hs.contains(searchPolicy);
        end = System.nanoTime();
        System.out.println("HashSet search time: " + (end - start));
        start = System.nanoTime();
        lhs.contains(searchPolicy);
        end = System.nanoTime();
        System.out.println("LinkedHashSet search time: " + (end - start));
        start = System.nanoTime();
        ts.contains(searchPolicy);
        end = System.nanoTime();
        System.out.println("TreeSet search time: " + (end - start));
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Policy\n2. Display All Policies\n3. Expiring Soon\n4. By Coverage Type\n5. Find Duplicates\n6. Compare Performance\n7. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addPolicy(); break;
                case 2:
                    System.out.println("\n HashSet Policies (Quick Lookup) :");
                    displayPolicies(hashSet);
                    System.out.println("\n LinkedHashSet Policies (Insertion Order) :");
                    displayPolicies(linkedHashSet);
                    System.out.println("\n TreeSet Policies (Sorted by Expiry Date) :");
                    displayPolicies(treeSet);
                    break;
                case 3: policiesExpiringSoon(); break;
                case 4: policiesByCoverageType(); break;
                case 5: findDuplicatePolicies(); break;
                case 6: performanceComparison(); break;
                case 7: System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}