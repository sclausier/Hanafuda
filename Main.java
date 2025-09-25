// import java.awt.Color;
// import java.awt.Frame;
import javax.swing.*;
// import java.awt.*;

// import java.awt.Color;

// import javax.swing.JFrame;
// import javax.swing.SwingUtilities;

public class Main extends JFrame {
    
    private static void init() {
        JFrame window = new JFrame("Hanafuda");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Default defWindow = new Default();

        window.add(defWindow);

        window.pack();
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                init();
            }
        });
    }

   
}


