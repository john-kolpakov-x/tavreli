package kz.pompei.tavreli.model;

public enum Post {

  RATNIK_VSADNIK(Zvanie.RATNIK, Zvanie.VSADNIK),
  RATNIK_LUCHNIK(Zvanie.RATNIK, Zvanie.LUCHNIK),
  RATNIK_RATOBOREC(Zvanie.RATNIK, Zvanie.RATOBOREC),
  RATNIK_KNYAZ(Zvanie.RATNIK, Zvanie.KNYAZ),
  RATNIK_HEGLI(Zvanie.RATNIK, Zvanie.HEGLI),

  VSADNIK(Zvanie.VSADNIK, null),
  LUCHNIK(Zvanie.LUCHNIK, null),
  RATOBOREC(Zvanie.RATOBOREC, null),
  KNYAZ(Zvanie.KNYAZ, null),
  VOLHV(Zvanie.VOLHV, null);

  public final Zvanie zvanie, revertedZvanie;

  Post(Zvanie zvanie, Zvanie revertedZvanie) {
    this.zvanie = zvanie;
    this.revertedZvanie = revertedZvanie;
  }

  public boolean canRevert() {
    return revertedZvanie != null;
  }
}
