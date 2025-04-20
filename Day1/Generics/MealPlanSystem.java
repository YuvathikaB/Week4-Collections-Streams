import java.util.Scanner;
interface MealPlan {
    String getPlanDetails();
}
class VegetarianMeal implements MealPlan {
    public String getPlanDetails() {
        return "Vegetarian Meal: Includes vegetables, grains, dairy, and fruits.";
    }
}
class VeganMeal implements MealPlan {
    public String getPlanDetails() {
        return "Vegan Meal: Includes vegetables, grains, fruits. No animal products.";
    }
}
class KetoMeal implements MealPlan {
    public String getPlanDetails() {
        return "Keto Meal: High fat, moderate protein, very low carbs.";
    }
}
class HighProteinMeal implements MealPlan {
    public String getPlanDetails() {
        return "High-Protein Meal: Includes lean meats, legumes, and dairy.";
    }
}
class Meal<T extends MealPlan> {
    private String userName;
    private T mealType;
    public Meal(String userName, T mealType) {
        this.userName = userName;
        this.mealType = mealType;
    }
    public String getUserName() {
        return userName;
    }
    public T getMealType() {
        return mealType;
    }
    public void showPlan() {
        System.out.println("\nMeal Plan for " + userName + " :");
        System.out.println(mealType.getPlanDetails());
    }
}
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(String userName, T mealType) {
        return new Meal<>(userName, mealType);
    }
    public static boolean isValidChoice(int choice) {
        return choice >= 1 && choice <= 4;
    }
}
class PersonalizedMealPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean next = true;
        while (next) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            int choice = -1;
            boolean validChoice = false;
            while (!validChoice) {
                System.out.println("\nSelect your preferred meal type:");
                System.out.println("1. Vegetarian");
                System.out.println("2. Vegan");
                System.out.println("3. Keto");
                System.out.println("4. High-Protein");
                System.out.print("Choice (1-4): ");
                choice = scanner.nextInt();
                validChoice = MealPlanGenerator.isValidChoice(choice);
                if (!validChoice) {
                    System.out.println("Invalid selection. Please choose a valid option.");
                }
            }
            Meal<? extends MealPlan> meal = null;
            switch (choice) {
                case 1:
                    meal = MealPlanGenerator.generateMealPlan(name, new VegetarianMeal());
                    break;
                case 2:
                    meal = MealPlanGenerator.generateMealPlan(name, new VeganMeal());
                    break;
                case 3:
                    meal = MealPlanGenerator.generateMealPlan(name, new KetoMeal());
                    break;
                case 4:
                    meal = MealPlanGenerator.generateMealPlan(name, new HighProteinMeal());
                    break;
                default:
                    break;
            }
            if (meal != null) {
                meal.showPlan();
            }
            System.out.print("\nWould you like to create another meal plan? (yes/no): ");
            scanner.nextLine();
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("yes")) {
                next = false;
            }
        }
        scanner.close();
    }
}
