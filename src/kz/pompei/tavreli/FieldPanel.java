package kz.pompei.tavreli;

import java.awt.Graphics;
import javax.swing.JPanel;

public class FieldPanel extends JPanel {

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    g.drawLine(10, 10, 100, 100);
  }
}
