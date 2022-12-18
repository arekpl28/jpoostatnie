package Zadanie1;

import java.util.Arrays;

public class ZlozenieTransformacji implements Transformacja {
  private final Transformacja[] transformacje;

  public ZlozenieTransformacji(Transformacja[] transformacje) {
    this.transformacje = transformacje;
  }

  @Override
  public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException {
    Transformacja[] odwrotneTransformacje = new Transformacja[transformacje.length];

    for (int i = 0; i < odwrotneTransformacje.length; i++)
      odwrotneTransformacje[i] = transformacje[transformacje.length - 1 - i].getTransformacjaOdwrotna();

    return new ZlozenieTransformacji(odwrotneTransformacje);
  }

  @Override
  public Punkt transformuj(Punkt p) {
    Punkt poTransformacji = p;
    for (Transformacja transformacja : transformacje) {
      poTransformacji = transformacja.transformuj(poTransformacji);
    }
    return poTransformacji;
  }

  @Override
  public String toString() {
    return "Zlozenie transformacji: " + Arrays.toString(transformacje);
  }

}
