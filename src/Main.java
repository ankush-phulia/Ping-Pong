import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Board pongPanel = new Board();
        frame.add(pongPanel, BorderLayout.CENTER);

        frame.setSize(1000, 1000);
        frame.setVisible(true);

    }
}