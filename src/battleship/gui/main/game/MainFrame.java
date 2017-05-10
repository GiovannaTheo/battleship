package battleship.gui.main.game;

/**
 * Created by arthurdeschamps and theogiovanna on 05.05.17.
 */

import battleship.gui.main.start.StartView;
import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.JFrame;
import javax.swing.*;

public class MainFrame {

    // View
    private final static MainView mainView = new MainView();

    public MainFrame(){
        JFrame frame = new JFrame("MigLayout Basic");

        frame.setTitle("Battleship - WarZone");
        frame.setSize(1200,800); //Set size for new panel
        frame.setLocationRelativeTo(null); //Center
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(mainView); //Set main panel
        frame.setVisible(true);

    }

    public static MainView getMainView() {
        return mainView;
    }
}



