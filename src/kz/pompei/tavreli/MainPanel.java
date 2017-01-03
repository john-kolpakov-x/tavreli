package kz.pompei.tavreli;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

  public MainPanel() {

    setLayout(null);

    TextField textField = new TextField(30);
    textField.setLocation(100, 100);
    Dimension ps = textField.getPreferredSize();
    textField.setSize(200, 10);

    add(textField);

    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        textField.setSize(200, textField.getPreferredSize().height);
      }
    });

  }

}
