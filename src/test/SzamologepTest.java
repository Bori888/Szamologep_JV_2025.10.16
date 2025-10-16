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
        testOsszeadAzonos0_0();
        testOsszeadSzovegesAzonos2_2();
        testOsszeadKulonbozoSzamok2_3();
        testOsszeadMaxInt();

        testOsztasSzovegesKulonbozoek6_2();
        testOsztasVegesValosok7_3();
        testOsztasVegtelenValosok5_3();
        testOsztasEgeszek4_2();
        testOsztasSzovegesAzonos2_2();
    }

    private void hibasHasznalat() {
        testOsztasSRTNull7_0();
    }

    // Segédfüggvény az egységes kiíráshoz
    void kiir(String tesztNev, String kifejezes, Object eredmeny) {
        System.out.println(tesztNev + ":");
        System.out.println();
        System.out.printf("                 %s -->%s\n\n", kifejezes, eredmeny.toString());
    }

    void testOsszeadAzonos0_0() {
        String a = "0";
        String b = "0";
        int kapott = Szamologep.osszead(a, b);
        int vart = 0;
        kiir("testOsszeadAzonos0_0", a + "+" + b, kapott);
        assert kapott == vart : "hibás összeadás";
    }

    void testOsszeadSzovegesAzonos2_2() {
        String a = "2";
        String b = "2";
        int kapott = Szamologep.osszead(a, b);
        int vart = 4;
        kiir("testOsszeadSzovegesAzonos2_2", a + "+" + b, kapott);
        assert kapott == vart : "hibás összeadás";
    }

    void testOsszeadKulonbozoSzamok2_3() {
        String a = "2";
        String b = "3";
        int kapott = Szamologep.osszead(a, b);
        int vart = 5;
        kiir("testOsszeadKulonbozoSzamok2_3", a + "+" + b, kapott);
        assert kapott == vart : "hibás összeadás";
    }

    void testOsszeadMaxInt() {
        String a = "" + Integer.MAX_VALUE;
        String b = "1";
        // Figyelem! Az osszeadás metódus int visszatérési értékével túlcsordulhat, ezt vedd figyelembe!
        int kapott = Szamologep.osszead(a, b);
        long vart = Integer.MAX_VALUE + 1L;
        kiir("testOsszeadMaxInt", a + "+" + b, kapott);
        assert kapott == vart : "hibás összeadás (túlcsordulás?)";
    }

    void testOsztasSzovegesKulonbozoek6_2() {
        String a = "6";
        String b = "2";
        double kapott = Szamologep.osztas(a, b);
        int vart = 3;
        double elteres = 0.0001;
        kiir("testOsztasSzovegesKulonbozoek6_2", a + "/" + b, kapott);
        assert Math.abs(kapott - vart) <= elteres : "hibás osztás";
    }

    void testOsztasVegesValosok7_3() {
        String a = "7";
        String b = "3";
        double kapott = Szamologep.osztas(a, b);
        double vart = 7.0 / 3;
        double elteres = 0.001;
        kiir("testOsztasVegesValosok7_3", a + "/" + b, kapott);
        assert Math.abs(kapott - vart) <= elteres : "hibás osztás";
    }

    void testOsztasVegtelenValosok5_3() {
        String a = "5";
        String b = "3";
        double kapott = Szamologep.osztas(a, b);
        double vart = 5.0 / 3;
        double elteres = 0.001;
        kiir("testOsztasVegtelenValosok5_3", a + "/" + b, kapott);
        assert Math.abs(kapott - vart) <= elteres : "hibás osztás";
    }

    void testOsztasEgeszek4_2() {
        int a = 4;
        int b = 2;
        int kapott = (int) Szamologep.osztas(a, b);
        int vart = 4 / 2;
        kiir("testOsztasEgeszek4_2", a + "/" + b, kapott);
        assert kapott == vart : "hibás osztás";
    }

    void testOsztasSzovegesAzonos2_2() {
        String a = "2";
        String b = "2";
        double kapott = Szamologep.osztas(a, b);
        int vart = 1;
        kiir("testOsztasSzovegesAzonos2_2", a + "/" + b, kapott);
        assert kapott == vart : "hibás osztás";
    }

    void testOsztasSRTNull7_0() {
        String a = "7";
        String b = "0";
        double kapott = Szamologep.osztas(a, b);
        kiir("testOsztasSRTNull7_0", a + "/" + b, kapott);
        assert Double.isInfinite(kapott) : "nem Infinity";
    }

}
