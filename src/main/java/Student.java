import java.util.ArrayList;
import java.util.List;

public class Student {
    private String nume;
    private String grupa;
    private List<Integer> note;

    public Student(String valoare, String grupa) {
        this.nume = valoare;
        this.grupa = grupa;
        note = new ArrayList();
    }

    public String getNume() {
        return nume;
    }

    public String getGrupa() {
        return grupa;
    }

    public void adaugaNota(int nota) {
        note.add(nota);
    }

    public boolean esteIntegralist() {
        for (int n : note) {
            if (n < 5) {
                return false;
            }
        }
        return true;
    }

    public Integer medie() {
        int suma = 0;
        for (int n : note) {
            suma += n;
        }
        return suma / note.size();
    }

    public int getNumarRestante() {
        int nr = 0;
        for (int n : note) {
            if (n < 5) {
                nr++;
            }
        }
        return nr;
    }

}