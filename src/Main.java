//import javax.swing.*;
//import java.io.IOException;
//import java.util.Objects;
//
//public class Main {
//    private static final String password = "Passw0rd";
//    public static String[] comm = {"Rundll32.exe", "user32.dll,LockWorkStation"};
//    public static void main(String[] args) throws InterruptedException {
//        //Timer timer = new Timer();
//        String pass = JOptionPane.showInputDialog("Input the password: ");
//        //System.out.println(pass);
//        if (Objects.equals(pass, password))
//        {
//            System.out.print("The password is correct!!!");
//        }
//        else
//        {
//            Runtime r = Runtime.getRuntime();
//            try
//            {
//                r.exec(comm);
//            }catch (IOException e)
//            {
//                System.out.print("Error");
//            }
//        }
//    }
//
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class Main {
    private static final String password = "senbonzakura";
    private static final String[] comm = {"shutdown", "-r"};
    private static final int TIMEOUT = 20000;

    public static void main(String[] args) throws InterruptedException {
        Runtime r = Runtime.getRuntime();
        Timer timer = new Timer(TIMEOUT, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lock the workstation if time runs out

                try {
                    r.exec(comm);
                } catch (IOException ex) {
                    System.out.print("Error executing lock command");
                }
            }
        });


        timer.setRepeats(false);
        timer.start();


        String pass = JOptionPane.showInputDialog("Input the password: ");


        if (Objects.equals(pass, password)) {

            timer.stop();
            System.out.print("The password is correct!!!");
        } else {
            
            System.out.print("Incorrect password");
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
