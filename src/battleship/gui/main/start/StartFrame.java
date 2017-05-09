package battleship.gui.main.start;

import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;

/**
 * Created by arthurdeschamps on 09.05.17.
 */
public class StartFrame {

    // View
    private static StartView startView = new StartView();

    public StartFrame() {
        JFrame startFrame = new JFrame();

        startFrame.setTitle("Battleship - Start");
        startFrame.setSize(300,300);
        startFrame.setLocationRelativeTo(null); //Center
        startFrame.setResizable(true);
        startFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Start view at first
        startFrame.setContentPane(startView); //Set panel
        startFrame.setVisible(true);
    }
}
