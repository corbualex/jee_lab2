import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;


//EX  2.7.1
//public class Main {
//    public static void main(String[] args) {
//
//        List<Integer> x = new ArrayList<>();
//        List<Integer> y = new ArrayList<>();
//        List<Integer> xPlusY = new ArrayList<>();       // a
//        Set<Integer> zSet = new TreeSet<>();            // b
//        List<Integer> xMinusY = new ArrayList<>();      // c
//        int p = 4;
//        List<Integer> xPlusYLimitedByP = new ArrayList<>(); // d
//
//        Random rand = new Random();
//
//
//        for (int i = 0; i < 5; i++) {
//            x.add(rand.nextInt(11));
//        }
//
//
//        for (int i = 0; i < 7; i++) {
//            y.add(rand.nextInt(11));
//        }
//
//        // Ordonarea listelor
//        Collections.sort(x);
//        Collections.sort(y);
//
//        System.out.println("Lista x: " + x);
//        System.out.println("Lista y: " + y);
//
//        // a)
//        xPlusY.addAll(x);
//        xPlusY.addAll(y);
//        Collections.sort(xPlusY);
//        System.out.println("a) xPlusY: " + xPlusY);
//
//        // b)
//        zSet.addAll(x);
//        zSet.retainAll(y); // Pastreaza doar elementele care se regasesc și în y
//        System.out.println("b) zSet: " + zSet);
//
//        // c)
//        xMinusY.addAll(x);
//        xMinusY.removeAll(y);
//        System.out.println("c) xMinusY: " + xMinusY);
//
//        // d)
//        for (Integer valoare : xPlusY) {
//            if (valoare <= p) {
//                xPlusYLimitedByP.add(valoare);
//            }
//        }
//
//        System.out.println("d) xPlusYLimitedByP: " + xPlusYLimitedByP);
//    }
//}

//EX 2.7.2
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();

        // Adaugam studneti in lista
        studenti.add(new Student("Popescu Ion", "311"));
        studenti.add(new Student("Ionescu Ana", "312"));
        studenti.add(new Student("Marin Andrei", "311"));
        studenti.add(new Student("Radu Elena", "312"));
        studenti.add(new Student("Avram Mihai", "311"));

        Random rand = new Random();

        // a)
        for (Student s : studenti) {
            for (int i = 0; i < 5; i++) {
                // rand.nextInt(7) generează un număr între 0 și 6. Adunând 4, obținem intervalul 4 - 10.
                s.adaugaNota(rand.nextInt(7) + 4);
            }
        }

        // b1)
        System.out.println("--- b1) Alfabetic, pe grupe ---");
        studenti.stream()
                .sorted(Comparator.comparing(Student::getGrupa)
                                  .thenComparing(Student::getNume))
                .forEach(s -> System.out.println("Grupa " + s.getGrupa() + " | " + s.getNume() + " | Medie: " + s.medie()));

        // b2)
        System.out.println("\n--- b2) Descrescator dupa medie (Integralisti) ---");
        studenti.stream()
                .filter(Student::esteIntegralist) // Pastrează doar integralistii
                .sorted((s1, s2) -> s2.medie().compareTo(s1.medie())) // Ordonare descrescătoare după medie
                .forEach(s -> System.out.println(s.getNume() + " - Medie: " + s.medie()));

        // b3)
        System.out.println("\n--- b3) Crescator dupa numarul de restante (Restantieri) ---");
        studenti.stream()
                .filter(s -> !s.esteIntegralist()) // Păstrează doar restantierii (
                .sorted(Comparator.comparingInt(Student::getNumarRestante)) // Ordonare crescatoare
                .forEach(s -> System.out.println(s.getNume() + " - Restante: " + s.getNumarRestante()));
    }
}