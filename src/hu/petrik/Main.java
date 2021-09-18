package hu.petrik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Harcos> harcosok = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Harcos h1 = new Harcos("Thaf", 1);
        Harcos h2 = new Harcos("Hyolk",2);
        Harcos h3 = new Harcos("Vaum",3);

        harcosok.add(h1);
        harcosok.add(h2);
        harcosok.add(h3);

        ellenfelKiir();

        System.out.print("Adj meg egy karakternevet: ");
        String nev = sc.next();
        System.out.print("Add meg a státusz sablont: " +
                "\n1: Alap Élet: 15\tAlap Sebzés: 3" +
                "\n2: Alap Élet: 12\tAlap Sebzés: 4" +
                "\n3: Alap Élet: 8\tAlap Sebzés: 5\n");
        int statusSablon = sc.nextInt();
        Harcos felhsznalo = new Harcos(nev,statusSablon);

        boolean kilep = false;
        int kor = 0;
        while (!kilep){
            kor++;
            ellenfelKiir();
            System.out.println(felhsznalo + "\n");
            char opcio;
            System.out.println("a.) Megküzdeni egy harcossal\n" +
                    "b.) Gyógyulni\n" +
                    "c.) Kilépni");
            opcio = sc.next().charAt(0);
            switch (opcio){
                case 'a':
                    int hanyadikHarcos;
                    System.out.print("Add meg hanyadik harcossal akarsz megküzdeni: ");
                    hanyadikHarcos = sc.nextInt();
                    //nem értem, hogy kéne vizsgálni hogy megfelelő adatot adott meg :/
                    felhsznalo.megkuzd(harcosok.get(hanyadikHarcos - 1));
                    break;
                case 'b':
                    felhsznalo.gyogyul();
                    break;
                case 'c':
                    kilep = true;
                    break;
                default:
                    System.out.println("Hiba! Ilyen opció nincs!");
                    break;
            }
            if (kor % 3 == 0){
                int veletlen = (int)Math.random() * (((harcosok.size() - 1) - 0) + 1) + 0;
                harcosok.get(veletlen).megkuzd(felhsznalo);
                for (Harcos item : harcosok) {
                    item.gyogyul();
                }
            }
        }
    }

    public static void ellenfelKiir(){
        for (Harcos item : harcosok) {
            System.out.println(item);
        }
    }
}
