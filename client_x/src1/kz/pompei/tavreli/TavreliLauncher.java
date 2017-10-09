package kz.pompei.tavreli;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TavreliLauncher {

  public static void main(String[] args) {
    JFrame jFrame = new JFrame();
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    jFrame.setLocation(1000, 200);
    jFrame.setSize(900, 700);

    jFrame.setTitle("Таврели");

    jFrame.setContentPane(new ChemFieldPanel());

    jFrame.setVisible(true);
  }
}
