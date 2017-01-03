package kz.pompei.tavreli;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.JPanel;
import kz.pompei.tavreli.model.Fate;
import kz.pompei.tavreli.model.FieldModel;

public class ChemFieldPanel extends JPanel {

  int leftOffset = 30, topOffset = 30;

  int cellSide = 70;

  private final FieldModel model = new FieldModel();

  {
    model.init();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    paint2((Graphics2D) g);
  }

  public ChemFieldPanel() {
    addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseMoved(MouseEvent e) {
        repaint();
      }
    });
  }

  private static final Color CELL_COLOR_WHITE = new Color(0xe3cfb5);
  private static final Color CELL_COLOR_BLACK = new Color(0x9c6050);

  private void paint2(Graphics2D g) {

    paintBackground(g);

    for (int row = 0, rowCount = model.rowCount(); row < rowCount; row++) {

      for (int col = 0, colCount = model.colCount(); col < colCount; col++) {

        List<Fate> list = model.get(row, col);
        if (list.size() > 0) {

          int top = rowCount - row - 1;
          int left = col;

          int x = leftOffset + left * cellSide;
          int y = topOffset + top * cellSide;

          new FigureDrawer(g, list, x, y, cellSide).draw();

        }

      }

    }

  }


  private void paintBackground(Graphics2D g) {
    for (int i = 0, rows = model.rowCount(); i < rows; i++) {
      for (int j = 0, cols = model.colCount(); j < cols; j++) {
        Color color = ((i + j + 1) % 2 == 0) ? CELL_COLOR_BLACK : CELL_COLOR_WHITE;
        g.setColor(color);
        g.fillRect(leftOffset + j * cellSide, topOffset + i * cellSide, cellSide, cellSide);
      }
    }
  }
}
