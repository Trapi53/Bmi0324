package bmiindex;

import java.util.Scanner;

public class BmiIndex {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bmiFeladat();
    }

    private static void bmiFeladat() {
        kiir("BMI kiszámítása");
        int m = beker("Testmagasság (cm) [100,200]: ", 100, 200);
        int t = beker("Testtömeg (kg) [40,150]: ", 40, 150);
        double bmi = bmiSzamit(t, m);
        ertekeles(bmi, m, t);
    }

    private static void kiir(String szoveg) {
        System.out.println(szoveg);
    }

    private static int beker(String kerdes, int also, int felso) {
        boolean jo;
        int szam;
        do {
            kiir(kerdes);
            szam = sc.nextInt();
            jo = szam >= also && szam <= felso;
        } while (!jo);
        return szam;

    }

    private static double bmiSzamit(int m, int t) {
        return t / Math.pow(m / 100.0, 2);
    }

    private static void ertekeles(double bmi, int m, int t) {
        kiir("Ön %d cm, %d kg, %.2f BMI".formatted(m, t, bmi));
    }

}
