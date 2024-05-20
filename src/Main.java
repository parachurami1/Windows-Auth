import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class Main {
    private static final String password = "Passw0rd";
    public static String[] comm = {"Rundll32.exe", "user32.dll,LockWorkStation"};
    public static void main(String[] args) throws InterruptedException {
        //Timer timer = new Timer();
        String pass = JOptionPane.showInputDialog("Input the password: ");
        //System.out.println(pass);
        if (Objects.equals(pass, password))
        {
            System.out.print("The password is correct!!!");
        }
        else
        {
            Runtime r = Runtime.getRuntime();
            try
            {
                r.exec(comm);
            }catch (IOException e)
            {
                System.out.print("Error");
            }
        }
    }
}