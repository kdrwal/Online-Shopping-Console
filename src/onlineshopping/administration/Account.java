package onlineshopping.administration;

import java.util.HashMap;
import java.util.Scanner;

public class Account implements AccountManagment {

    //Attributes
    public static HashMap<String, String> users = new HashMap<>();
    protected String username;
    protected String password;
    protected UserData userdata;

    //Constructor
    public Account(UserData userdata) {
        this.userdata = userdata;
    }

    //Methods

    //Registers a new user
    @Override
    public void registerUser(Scanner scanner) {
        System.out.println("Enter your username:");
        username = scanner.nextLine();
        System.out.println("Enter your password:");
        password = scanner.nextLine();

        //Check if the username already exists
        if (users.containsKey(username)) {
            System.out.println("User already exists.");
        } else {
            //Register the user
            users.put(username, password);
            System.out.println("Registration successful.");
            //Save user data to txt file
            userdata.saveUsers(username, password);
        }
    }

    //Logs in a user
    @Override
    public void loginUser(Scanner scanner) {
        System.out.println("Enter your username:");
        username = scanner.nextLine();
        System.out.println("Enter your password:");
        password = scanner.nextLine();

        //Check if the username exists
        if (!users.containsKey(username)) {
            System.out.println("Invalid username or password.");
        } else {
            //Check if the password is correct
            if (users.get(username).equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }
        }
    }
}

