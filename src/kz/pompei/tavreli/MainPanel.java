package kz.pompei.tavreli;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

  public MainPanel() {

    GridBagLayout gbl = new GridBagLayout();
    setLayout(gbl);

    GridBagConstraints c = new GridBagConstraints();

    c.anchor = GridBagConstraints.NORTH;
    c.fill = GridBagConstraints.NONE;
    c.gridheight = 1;
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.gridx = GridBagConstraints.RELATIVE;
    c.gridy = GridBagConstraints.RELATIVE;
    c.insets = new Insets(40, 0, 0, 0);
    c.ipadx = 0;
    c.ipady = 0;
    c.weightx = 0.0;
    c.weighty = 0.0;

    TextField textField = new TextField(30);
    gbl.setConstraints(textField, c);
    add(textField);


  }

}
