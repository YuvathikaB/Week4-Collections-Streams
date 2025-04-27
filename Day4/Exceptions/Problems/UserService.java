package problems;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class UserAlreadyExistsException extends Exception {
   public UserAlreadyExistsException(String message) {
       super(message);
   }
}
class UserNotFoundException extends Exception {
   public UserNotFoundException(String message) {
       super(message);
   }
}
public class UserService {
   private Set<String> users = new HashSet<>();
   public void registerUser(String username) throws UserAlreadyExistsException {
       if (users.contains(username)) {
           throw new UserAlreadyExistsException("User already exists");
       }
       users.add(username);
   }
   public void checkUserExistence(String username) throws UserNotFoundException {
       if (!users.contains(username)) {
           throw new UserNotFoundException("User not found");
       }
   }
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       UserService userService = new UserService();
       System.out.print("Enter a username to register: ");
       String usernameToRegister = scanner.nextLine();
       try {
           userService.registerUser(usernameToRegister);
           System.out.println("User registered successfully");
           System.out.print("Enter a username to check: ");
           String usernameToCheck = scanner.nextLine();
           userService.checkUserExistence(usernameToCheck);
           System.out.println("User exists in the system");
       } catch (UserAlreadyExistsException e) {
           System.out.println("Exception: " + e.getMessage());
       } catch (UserNotFoundException e) {
           System.out.println("Exception: " + e.getMessage());
       }
   }
}

