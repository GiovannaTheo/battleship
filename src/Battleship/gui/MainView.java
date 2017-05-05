package Battleship.gui;

/**
 * Created by arthurdeschamps on 05.05.17.
 */
import javax.swing.*;


public class MainView {

    public MainView() {
    }

    public void render() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
