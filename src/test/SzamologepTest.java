package test;

import main.Szamologep;

public class SzamologepTest {

    public static void main(String[] args) {
        SzamologepTest tesztek = new SzamologepTest();
        tesztek.futtat();
    }

    void futtat() {
        helyesHasznalat();
        hibasHasznalat();
    }

    private void helyesHasznalat() {
        testOsszead0_0();
        testOsszead2_2();
        testOsszead2_3();
        testOsztas6_2();
        testOsztas7_3();

    }

    private void hibasHasznalat() {
        //testOsztas7_0();
    }

    void testOsszead0_0() {
        System.out.println("összead: 0+0");
        int kapott = Szamologep.osszead("0", "0");
        int vart = 0;
        assert kapott == vart : "hibás összeadás";
    }

    void testOsszead2_2() {
        String a = "2";
        String b = "2";
        System.out.printf("összead: %s+%s\n", a, b);
        int kapott = Szamologep.osszead(a, b);
        int vart = 4;
        String hiba = "hibás összeadás --> %s+%s\n".formatted(a, b);
        hiba += "várt: %d, kapott: %d\n".formatted(vart, kapott);
        assert kapott == vart : hiba;
    }

    void testOsszead2_3() {
        String a = "2";
        String b = "3";
        System.out.printf("összead: %s+%s\n", a, b);
        int kapott = Szamologep.osszead(a, b);
        int vart = 5;
        String hiba = "hibás összeadás --> %s+%s\n".formatted(a, b);
        hiba += "várt: %d, kapott: %d\n".formatted(vart, kapott);
        assert kapott == vart : hiba;
    }

    void testOsztas6_2() {
    String a = "6";
    String b = "2";
    System.out.printf("osztás: %s/%s\n", a, b);
    double kapott = Szamologep.osztas(a, b);
    int vart = 3;
    double elteres = 0.0001;
    String hiba = "hibás osztás --> %s/%s\n".formatted(a, b);
    hiba += "várt: %d, kapott: %f\n".formatted(vart, kapott);
    assert Math.abs(kapott - vart) <= elteres : hiba;
}


    void testOsztas7_0() {
        String a = "7";
        String b = "0";
        System.out.printf("osztás: %s/%s\n", a, b);

        boolean voltMegfeleloKivetel = false;
        try {
            Szamologep.osztas(a, b);
        } catch (ArithmeticException e) {
            voltMegfeleloKivetel = true;
        } catch (Exception e) {
            voltMegfeleloKivetel = false;
        }

    }
    void testOsztas7_3() {
        String a = "7";
        String b = "3";
        System.out.printf("osztás: %s/%s\n", a, b);
        double kapott = Szamologep.osztas(a, b);
        double vart = 7.0/3;
        double elteres= 0.001;
        String hiba = "hibás osztás --> %s/%s\n".formatted(a, b);
        hiba += "várt: %f, kapott: %f\n".formatted(vart, kapott);
        assert Math.abs(kapott-vart)<=elteres:hiba;
    }

}
