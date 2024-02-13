package onlineshopping.administration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class UserData {

    //Attribute
    private File dataUser = new File("userDatabase.txt");

    //Methods

    //Save user information to a txt file
    public void saveUsers(String username, String password) {
        try {
            //Check if the file existts; if not, create a new file
            if (!dataUser.exists()) {
                dataUser.createNewFile();
            }

            //Check if the file writable
            if (dataUser.canWrite()) {
                //Open FileWriter and Formatter to write to the file
                FileWriter fileWriter = new FileWriter(dataUser, true);
                Formatter formatter = new Formatter(fileWriter);

                //Write user information to the file
                writeUserToFile(formatter, username, password);

                System.out.println("User successfully saved.");

                //Close Formatter to flush and close the file
                formatter.close();
            } else {
                System.out.println("Can't write to file. Check file permissions.");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    //Writes user information to the file using the provided Formatter.
    private void writeUserToFile(Formatter formatter, String username, String password) {
        formatter.format("%s,%s%n", username, password);
    }
}
