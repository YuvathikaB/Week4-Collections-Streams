import java.util.*;
abstract class JobRole {
    public abstract String getRoleName();
    public abstract List<String> getRequiredSkills();
}
class SoftwareEngineer extends JobRole {
    public String getRoleName() {
        return "Software Engineer";
    }
    public List<String> getRequiredSkills() {
        return Arrays.asList("Java", "Data Structures", "Algorithms", "System Design", "Git");
    }
}
class DataScientist extends JobRole {
    public String getRoleName() {
        return "Data Scientist";
    }
    public List<String> getRequiredSkills() {
        return Arrays.asList("Python", "Machine Learning", "Statistics", "Data Visualization", "SQL");
    }
}
class ProductManager extends JobRole {
    public String getRoleName() {
        return "Product Manager";
    }
    public List<String> getRequiredSkills() {
        return Arrays.asList("Communication", "Agile", "Market Research", "Leadership", "Product Roadmap");
    }
}
class Resume<T extends JobRole> {
    private String candidateName;
    private List<String> candidateSkills;
    private T jobRole;
    public Resume(String candidateName, List<String> candidateSkills, T jobRole) {
        this.candidateName = candidateName;
        this.candidateSkills = candidateSkills;
        this.jobRole = jobRole;
    }
    public boolean isShortlisted() {
        int matchCount = 0;
        List<String> requiredSkills = jobRole.getRequiredSkills();
        for (String skill : candidateSkills) {
            for (String required : requiredSkills) {
                if (skill.equalsIgnoreCase(required)) {
                    matchCount++;
                    break;
                }
            }
        }
        return matchCount >= 3;
    }
    public void displayResult() {
        System.out.println("\nCandidate: " + candidateName);
        System.out.println("Applying for: " + jobRole.getRoleName());
        if (isShortlisted()) {
            System.out.println("Status: Shortlisted");
        } else {
            System.out.println("Status: Not Shortlisted");
        }
    }
}
class ResumeProcessor {
    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.displayResult();
        }
    }
}
public class AiResumeScreen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Resume<? extends JobRole>> resumeList = new ArrayList<>();
        boolean next = true;
        while (next) {
            System.out.print("Enter Candidate Name: ");
            String name = scanner.nextLine();
            System.out.println("Select Job Role:");
            System.out.println("1. Software Engineer");
            System.out.println("2. Data Scientist");
            System.out.println("3. Product Manager");
            System.out.print("Choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            JobRole role = null;
            switch (choice) {
                case 1:
                    role = new SoftwareEngineer();
                    break;
                case 2:
                    role = new DataScientist();
                    break;
                case 3:
                    role = new ProductManager();
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            List<String> requiredSkills = role.getRequiredSkills();
            System.out.println("Required Skills for " + role.getRoleName() + ": " + requiredSkills);
            System.out.print("Enter your skills (comma separated): ");
            String[] inputSkills = scanner.nextLine().split(",");
            List<String> userSkills = new ArrayList<>();
            for (String skill : inputSkills) {
                userSkills.add(skill.trim());
            }
            Resume<? extends JobRole> resume = new Resume<>(name, userSkills, role);
            resumeList.add(resume);
            System.out.println();
            System.out.print("Add another candidate? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes")) {
                next = false;
            }
        }
        System.out.println("\nScreening Results :");
        ResumeProcessor.processResumes(resumeList);
        scanner.close();
    }
}
