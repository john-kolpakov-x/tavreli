package kz.pompei.tavreli.model;

public class Pos {
  public final int row, col;

  public Pos(int row, int col) {
    this.row = row;
    this.col = col;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pos pos = (Pos) o;

    if (row != pos.row) return false;
    return col == pos.col;
  }

  @Override
  public int hashCode() {
    int result = row;
    result = 31 * result + col;
    return result;
  }
}
