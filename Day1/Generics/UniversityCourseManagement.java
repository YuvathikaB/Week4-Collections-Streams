import java.util.*;
abstract class CourseType {
    abstract String getEvaluationType();
}
class ExamCourse extends CourseType {
    @Override
    String getEvaluationType() {
        return "Exam-Based Evaluation";
    }
}
class AssignmentCourse extends CourseType {
    @Override
    String getEvaluationType() {
        return "Assignment-Based Evaluation";
    }
}
class ResearchCourse extends CourseType {
    @Override
    String getEvaluationType() {
        return "Research-Based Evaluation";
    }
}
class Course<T extends CourseType> {
    private String courseName;
    private String instructor;
    private T courseType;
    public Course(String courseName, String instructor, T courseType) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.courseType = courseType;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getInstructor() {
        return instructor;
    }
    public T getCourseType() {
        return courseType;
    }
    @Override
    public String toString() {
        return "Course Name: " + courseName + "\nInstructor: " + instructor + "\nEvaluation Type: " + courseType.getEvaluationType();
    }
}
class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();
    public <T extends CourseType> void addCourse(Course<T> course) {
        courses.add(course);
    }
    public void displayCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
            System.out.println();
        }
    }
    public void getCourseByEvaluationType(String evaluationType) {
        evaluationType = evaluationType.toLowerCase().trim();
        for (Course<? extends CourseType> course : courses) {
            if (course.getCourseType().getEvaluationType().toLowerCase().contains(evaluationType)) {
                System.out.println(course);
                System.out.println();
            }
        }
    }
}
public class UniversityCourseManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseCatalog catalog = new CourseCatalog();
        try {
            boolean continueAddingCourses = true;
            while (continueAddingCourses) {
                System.out.println("Enter course details:");
                System.out.print("Enter Course Name: ");
                String courseName = scanner.nextLine();
                System.out.print("Enter Instructor Name: ");
                String instructor = scanner.nextLine();
                System.out.println();
                System.out.println("Select evaluation type:");
                System.out.println("1. Exam-Based");
                System.out.println("2. Assignment-Based");
                System.out.println("3. Research-Based");
                System.out.print("Enter your choice (1/2/3): ");
                int evaluationChoice = scanner.nextInt();
                scanner.nextLine();
                CourseType courseType = null;
                switch (evaluationChoice) {
                    case 1:
                        courseType = new ExamCourse();
                        break;
                    case 2:
                        courseType = new AssignmentCourse();
                        break;
                    case 3:
                        courseType = new ResearchCourse();
                        break;
                    default:
                        System.out.println("Invalid choice. Defaulting to Exam-Based Evaluation.");
                        courseType = new ExamCourse();
                        break;
                }
                Course<? extends CourseType> course = new Course<>(courseName, instructor, courseType);
                catalog.addCourse(course);
                System.out.print("Do you want to add another course? (yes/no): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    continueAddingCourses = false;
                }
            }
            System.out.println("\nAll Courses in the Catalog:");
            catalog.displayCourses();
            System.out.print("Enter evaluation type to filter courses (e.g., exam-based, assignment-based, research-based): ");
            String evaluationType = scanner.nextLine();
            System.out.println("\nFiltered Courses by \"" + evaluationType + "\":");
            catalog.getCourseByEvaluationType(evaluationType);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
