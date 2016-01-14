import javax.swing.*;
// Importing the package that contains all the Swing Components and Classes.

public class Gui {

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Create and set up the frame.
        //The string passed as an argument will be displayed
        //as the title.

        JFrame frame = new JFrame("Company");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }
}