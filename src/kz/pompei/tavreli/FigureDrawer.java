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

      case RATOBOREC:
        drawMainZvanieRATOBOREC(xc, yc, cellSide);
        break;

      case VSADNIK:
        drawMainZvanieVSADNIK(xc, yc, cellSide);
        break;

      case LUCHNIK:
        drawMainZvanieLUCHNIK(xc, yc, cellSide);
        break;

      case KNYAZ:
        drawMainZvanieKNYAZ(xc, yc, cellSide);
        break;

      case VOLHV:
        drawMainZvanieVOLHV(xc, yc, cellSide);
        break;

      case HEGLI:
        drawMainZvanieHEGLI(xc, yc, cellSide);
        break;
    }
  }

  private void drawMainZvanieHEGLI(int xc, int yc, int cellSide) {
    float K = 1.1f;

    int top = Math.round((float) cellSide / 2 * V_top * K);
    int bottom = Math.round((float) cellSide / 2 * V_bottom);

    int left = Math.round((float) cellSide / 2 * V_width * K);
    int right = Math.round((float) cellSide / 2 * V_width * K);

    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(foreground);
    g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER,
      10.0f, null, 0.0f));
    try {

      int d = 3, u = 10;

      g2.drawLine(xc - left, yc - top - d, xc + right, yc + bottom - d);
      g2.drawLine(xc - left, yc + bottom - d, xc + right, yc - top - d);

      g2.drawLine(xc - left, yc, xc + right, yc);
      g2.drawLine(xc, yc - top - d, xc, yc + bottom - d);

      g2.drawLine(xc - left, yc, xc, yc - top - d);
      g2.drawLine(xc, yc - top - d, xc + right, yc);

      g2.drawLine(xc - left, yc, xc, yc + bottom - d);
      g2.drawLine(xc, yc + bottom - d, xc + right, yc);

    } finally {
      g2.dispose();
    }
  }

  private void drawMainZvanieVOLHV(int xc, int yc, int cellSide) {
    float K = 1.1f;

    int top = Math.round((float) cellSide / 2 * V_top * K);
    int bottom = Math.round((float) cellSide / 2 * V_bottom);

    int left = Math.round((float) cellSide / 2 * V_width * K);
    int right = Math.round((float) cellSide / 2 * V_width * K);

    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(foreground);
    g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER,
      10.0f, null, 0.0f));
    try {

      int d = 3, u = 10;

      g2.drawLine(xc - left, yc - top - d, xc + right, yc + bottom - d);
      g2.drawLine(xc - left, yc + bottom - d, xc + right, yc - top - d);

      g2.drawLine(xc - left, yc, xc + right, yc);
      g2.drawLine(xc, yc - top - d, xc, yc + bottom - d);

      int R = Math.round((float) cellSide * V_width / K * 0.4f);

      g2.drawOval(xc - R, yc - R, 2 * R, 2 * R);

    } finally {
      g2.dispose();
    }
  }

  private void drawMainZvanieKNYAZ(int xc, int yc, int cellSide) {
    int top = Math.round((float) cellSide / 2 * V_top);
    int bottom = Math.round((float) cellSide / 2 * V_bottom);

    int left = Math.round((float) cellSide / 2 * V_width);
    int right = Math.round((float) cellSide / 2 * V_width);

    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(foreground);
    g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER,
      10.0f, null, 0.0f));
    try {

      int d = 3, u = 10;

      g2.drawLine(xc - left, yc - top - d, xc + right, yc + bottom - d);
      g2.drawLine(xc - left, yc + bottom - d, xc + right, yc - top - d);

      g2.drawLine(xc - left, yc, xc + right, yc);
      g2.drawLine(xc, yc - top - d, xc, yc + bottom - d);

    } finally {
      g2.dispose();
    }
  }

  private void drawMainZvanieLUCHNIK(int xc, int yc, int cellSide) {
    int top = Math.round((float) cellSide / 2 * V_top);
    int bottom = Math.round((float) cellSide / 2 * V_bottom);

    int left = Math.round((float) cellSide / 2 * V_width);
    int right = Math.round((float) cellSide / 2 * V_width);

    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(foreground);
    g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10.0f,
      null, 0.0f));
    try {

      int d = 3, u = 10;

      g2.drawLine(xc - left, yc - top - d, xc + right, yc + bottom - d);
      g2.drawLine(xc - left, yc + bottom - d, xc + right, yc - top - d);

      g2.drawLine(xc + right, yc - top - d, xc + right - u, yc - top - d);
      g2.drawLine(xc + right, yc - top - d, xc + right, yc - top - d + u);

    } finally {
      g2.dispose();
    }
  }

  private void drawMainZvanieVSADNIK(int xc, int yc, int cellSide) {
    int top = Math.round((float) cellSide / 2 * V_top);
    int bottom = Math.round((float) cellSide / 2 * V_bottom);

    int left = Math.round((float) cellSide / 2 * V_width);
    int right = Math.round((float) cellSide / 2 * V_width);

    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(foreground);
    g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10.0f,
      null, 0.0f));
    try {

      int d = 3;
      int u = 5;

      g2.drawLine(xc - left, yc, xc + right, yc);
      g2.drawLine(xc - left, yc - u, xc - left, yc + u);
      g2.drawLine(xc + right, yc - u, xc + right, yc + u);

      g2.drawLine(xc, yc - top - d, xc, yc + bottom - d);
      g2.drawLine(xc - u, yc - top - d, xc + u, yc - top - d);
      g2.drawLine(xc - u, yc + bottom - d, xc + u, yc + bottom - d);

    } finally {
      g2.dispose();
    }
  }

  private void drawMainZvanieRATOBOREC(int xc, int yc, int cellSide) {
    int top = Math.round((float) cellSide / 2 * V_top);
    int bottom = Math.round((float) cellSide / 2 * V_bottom);

    int left = Math.round((float) cellSide / 2 * V_width);
    int right = Math.round((float) cellSide / 2 * V_width);

    Graphics2D g2 = (Graphics2D) g.create();
    g2.setColor(foreground);
    g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 10.0f,
      null, 0.0f));
    try {

      int d = 3;

      g2.drawLine(xc - left, yc, xc + right, yc);
      g2.drawLine(xc, yc - top - d, xc, yc + bottom - d);

    } finally {
      g2.dispose();
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