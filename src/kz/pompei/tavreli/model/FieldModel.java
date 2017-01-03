package kz.pompei.tavreli.model;

import java.util.*;

public class FieldModel {

  private final Map<Pos, List<Fate>> data = new HashMap<>();

  public int colCount() {
    return 8;
  }

  public int rowCount() {
    return 8;
  }

  public List<Fate> get(int row, int col) {
    List<Fate> list = data.get(new Pos(row, col));
    return list == null ? Collections.EMPTY_LIST : list;
  }

  public void set(int row, int col, List<Fate> tavrel) {
    Pos pos = new Pos(row, col);
    if (tavrel == null || tavrel.size() == 0) {
      data.remove(pos);
    } else {
      List<Fate> list = new ArrayList<>();
      list.addAll(tavrel);
      data.put(new Pos(row, col), Collections.unmodifiableList(list));
    }
  }

  public void put(int row, int col, Fate fate) {
    List<Fate> list = new ArrayList<>();
    list.add(fate);
    list.addAll(get(row, col));
    set(row, col, list);
  }

  public List<Fate> take(int row, int col, int count) {
    List<Fate> ret = new ArrayList<>();
    List<Fate> newCurrent = new ArrayList<>();

    List<Fate> current = get(row, col);
    for (int i = 0, c = current.size(); i < c; i++) {
      (i < count ? ret : newCurrent).add(current.get(i));
    }

    if (ret.size() != count) {
      throw new RuntimeException("No such figures " + count + " in cell (" + row + "," + col + ")");
    }

    set(row, col, newCurrent);
    return ret;
  }

  public void init() {
    data.clear();

    put(0, 0, new Fate(true, Post.RATOBOREC));
    put(0, 1, new Fate(true, Post.VSADNIK));
    put(0, 2, new Fate(true, Post.LUCHNIK));
    put(0, 3, new Fate(true, Post.KNYAZ));
    put(0, 4, new Fate(true, Post.VOLHV));
    put(0, 5, new Fate(true, Post.LUCHNIK));
    put(0, 6, new Fate(true, Post.VSADNIK));
    put(0, 7, new Fate(true, Post.RATOBOREC));

    put(1, 0, new Fate(true, Post.RATNIK_RATOBOREC));
    put(1, 1, new Fate(true, Post.RATNIK_VSADNIK));
    put(1, 2, new Fate(true, Post.RATNIK_LUCHNIK));
    put(1, 3, new Fate(true, Post.RATNIK_KNYAZ));
    put(1, 4, new Fate(true, Post.RATNIK_HEGLI));
    put(1, 5, new Fate(true, Post.RATNIK_LUCHNIK));
    put(1, 6, new Fate(true, Post.RATNIK_VSADNIK));
    put(1, 7, new Fate(true, Post.RATNIK_RATOBOREC));


    put(7, 0, new Fate(false, Post.RATOBOREC));
    put(7, 1, new Fate(false, Post.VSADNIK));
    put(7, 2, new Fate(false, Post.LUCHNIK));
    put(7, 3, new Fate(false, Post.KNYAZ));
    put(7, 4, new Fate(false, Post.VOLHV));
    put(7, 5, new Fate(false, Post.LUCHNIK));
    put(7, 6, new Fate(false, Post.VSADNIK));
    put(7, 7, new Fate(false, Post.RATOBOREC));

    put(6, 0, new Fate(false, Post.RATNIK_RATOBOREC));
    put(6, 1, new Fate(false, Post.RATNIK_VSADNIK));
    put(6, 2, new Fate(false, Post.RATNIK_LUCHNIK));
    put(6, 3, new Fate(false, Post.RATNIK_KNYAZ));
    put(6, 4, new Fate(false, Post.RATNIK_HEGLI));
    put(6, 5, new Fate(false, Post.RATNIK_LUCHNIK));
    put(6, 6, new Fate(false, Post.RATNIK_VSADNIK));
    put(6, 7, new Fate(false, Post.RATNIK_RATOBOREC));

  }

}
