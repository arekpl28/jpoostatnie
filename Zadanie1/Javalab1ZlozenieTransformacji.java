package Zadanie1;

public class Javalab1ZlozenieTransformacji {
  public static void main(String[] args) {

    try {
      Punkt p1 = Punkt.E_X;
      // Punkt p1 = new Punkt(2, 2);
      System.out.println(p1);

      Transformacja[] transformacje = new Transformacja[] {
          new Skalowanie(2, 3),
          new Translacja(2, 2),
          new Obrot(180)
      };

      Transformacja tr4 = new ZlozenieTransformacji(transformacje);
      System.out.println(tr4);

      Punkt p2 = tr4.transformuj(p1);
      System.out.println(p2);

      Transformacja trr4 = tr4.getTransformacjaOdwrotna();
      System.out.println(trr4);

      Punkt p3 = trr4.transformuj(p2);
      System.out.println(p3);
    } catch (BrakTransformacjiOdwrotnejException ex) {
      ex.printStackTrace();
    }
  }
}