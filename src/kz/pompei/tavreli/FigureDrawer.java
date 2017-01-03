package kz.pompei.tavreli;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import kz.pompei.tavreli.model.Fate;
import kz.pompei.tavreli.model.Zvanie;

public class FigureDrawer {
  private final Graphics2D g;
  private final List<Fate> list;
  private final int x, y, cellSide;

  public FigureDrawer(Graphics2D g, List<Fate> list, int x, int y, int cellSide) {
    this.g = g;
    this.list = list;
    this.x = x;
    this.y = y;
    this.cellSide = cellSide;
  }

  public void draw() {
    if (list == null || list.size() == 0) return;
    drawMain(list.get(0));
  }

  private Color foreground, background;
  private boolean white;

  private void drawMain(Fate fate) {
    foreground = Color.WHITE;
    background = Color.BLACK;
    if (fate.white) {
      foreground = Color.BLACK;
      background = Color.WHITE;
    }

    white = fate.white;

    drawMainZvanie(fate.zvanie());
  }

  final static float RK1 = 0.6f;
  final static float RK2 = 0.55f;

  final static float V_top = 0.2f;
  final static float V_bottom = 0.4f;
  final static float V_width = 0.3f;

  private void drawMainZvanie(Zvanie zvanie) {

    int xc = x + cellSide / 2, yc = y + cellSide / 2;

    int R1 = Math.round((float) cellSide / 2f * RK1);

    g.setColor(foreground);
    g.fillOval(xc - R1, yc - R1, R1 * 2, R1 * 2);

    int R2 = Math.round((float) cellSide / 2f * RK2);

    g.setColor(background);
    g.fillOval(xc - R2, yc - R2, R2 * 2, R2 * 2);

    switch (zvanie) {
      case RATNIK:
        drawMainZvanieRATNIK(xc, yc, cellSide);
        break;
    }
  }

  private void drawMainZvanieRATNIK(int xc, int yc, int cellSide) {

    int top = Math.round((float) cellSide / 2 * V_top);
    int bottom = Math.round((float) cellSide / 2 * V_bottom);

    int left = Math.round((float) cellSide / 2 * V_width);
    int right = Math.round((float) cellSide / 2 * V_width);

    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(foreground);
    g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10.0f,
      null, 0.0f));
    try {
      if (white) {
        int d = 5;
        g2.drawLine(xc - left, yc + bottom - d, xc, yc - top - d);
        g2.drawLine(xc, yc - top - d, xc + right, yc + bottom - d);
      } else {
        g2.drawLine(xc - left, yc - top, xc, yc + bottom);
        g2.drawLine(xc, yc + bottom, xc + right, yc - top);
      }
    } finally {
      g2.dispose();
    }

  }

}