package ZadanieAdwance2.biegpolesie;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import ZadanieAdwance2.biegpolesie.ludzie.BagiennyBiegacz;
import ZadanieAdwance2.biegpolesie.ludzie.StudentWETIOrazLesnik;
import ZadanieAdwance2.biegpolesie.roboty.RobotMobilny;
import ZadanieAdwance2.biegpolesie.roboty.Terminator;

/**
 *
 * @author TB
 */
public class Javalab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Set<Uczestnik> uczestnicy = new HashSet<>();
        uczestnicy.add(new BagiennyBiegacz("Krzysztof", "Kowalski", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new StudentWETIOrazLesnik("Gertruda", "Janosik", Czlowiek.Plec.KOBIETA));
        uczestnicy.add(new Terminator("Terminator", 10));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Witaj w aplikacji Bieg po Lesie. Wybierz bieg: ");
            System.out.println("1. Górki");
            System.out.println("2. Na przełaj z Matematyką");
            System.out.println("3. Bagienny miks naukowy");
            System.out.println("4. Wybierz sam");
            int wybor = scanner.nextInt();

            BiegPoLesie bieg;

            switch (wybor) {
                default:
                    System.out.println("Niezany wybór. Wybieranie opcji nr 1.");
                case 1:
                    bieg = gorki(System.out, System.out);
                    break;
                case 2:
                    bieg = naPrzelajZMatematyka(System.out, System.out);
                    break;
                case 3:
                    bieg = bagiennyMiks(System.out, System.out);
                    break;
                case 4:
                    bieg = wyborUzytkownika(System.out, System.out);

            }

            for (Uczestnik u : uczestnicy) {
                bieg.dodajUczestnika(u);
            }

            bieg.przeprowadzImpreze();
        }
    }

    private static BiegPoLesie wyborUzytkownika(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie biegPoLesie = new BiegPoLesie("Z Twoimi wybranymi trasami!", mikrofon, przestrzenWLesie);
        System.out.println("Masz możliwośc podania rodzaju terenu z pośród listy poniżej :");
        System.out.println("    Teren:");
        Arrays.stream(RodzajTerenu.values()).forEach(teren -> System.out.println(teren.getName()));
        System.out.println("    Zadania: ");
        Arrays.stream(DziedzinaZadania.values()).forEach(zadanie -> System.out.println(zadanie.getName()));
        Scanner scanner = new Scanner(System.in);
        String koniecWprowadznia = "";
        int counter = 1;
        while (!koniecWprowadznia.equals("y")) {
            System.out.println("wprowadz element trasy nr" + counter + " :");
            String wybor = scanner.nextLine().toLowerCase();
            try {
                biegPoLesie.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(wybor));
                counter++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(
                    "Czy chcesz skonczyc wporwadzanie \n jezeli tak to wporwadz znak Y \n jezeli nie to dowolny znak");
            koniecWprowadznia = scanner.nextLine().toLowerCase();
        }
        return biegPoLesie;
    }

    private static BiegPoLesie gorki(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie gorki_ = new BiegPoLesie("Górki", mikrofon, przestrzenWLesie);

        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.INFORMATYKA));
        gorki_.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));

        return gorki_;
    }

    private static BiegPoLesie naPrzelajZMatematyka(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie naPrzelaj = new BiegPoLesie("Na przełaj z matematyką", mikrofon, przestrzenWLesie);

        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.NISKI_LAS));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        naPrzelaj.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.WYSOKI_LAS));

        return naPrzelaj;
    }

    private static BiegPoLesie bagiennyMiks(PrintStream mikrofon, PrintStream przestrzenWLesie) {
        BiegPoLesie miks = new BiegPoLesie("Bagienny miks naukowy", mikrofon, przestrzenWLesie);

        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.DROGA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.SCIEZKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.MATEMATYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.FIZYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.INFORMATYKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.SZTUKA));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.BAGNO));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(DziedzinaZadania.NAUKI_LESNE));
        miks.dodajElementTrasy(FabrykaElementowTrasy.utworzElementTrasy(RodzajTerenu.WYSOKI_LAS));

        return miks;
    }

}
