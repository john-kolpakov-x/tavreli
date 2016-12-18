package kz.pompei.tavreli;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TavreliLauncher {

  public static void main(String[] args) {
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    jFrame.setLocation(4000, 100);
    jFrame.setSize(800, 600);

    jFrame.setTitle("Таврели");

    jFrame.setContentPane(new MainPanel());

    jFrame.setVisible(true);
  }

}
