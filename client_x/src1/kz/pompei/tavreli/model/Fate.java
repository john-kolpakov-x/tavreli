package kz.pompei.tavreli.model;

public class Fate {
  public final boolean white;

  public final Post post;

  public final boolean reverted;

  public Fate(boolean white, Post post) {
    this(white, post, false);
  }

  public Fate(boolean white, Post post, boolean reverted) {
    this.white = white;
    this.post = post;
    this.reverted = reverted;
  }

  public Fate revert() {
    if (post.canRevert()) return new Fate(white, post, !reverted);
    throw new RuntimeException(post.zvanie + " cannot be reverted");
  }

  public Zvanie zvanie() {
    return reverted ? post.revertedZvanie : post.zvanie;
  }
}
