import java.util.HashSet;
import java.util.Set;

public class Programmazione {
    public enum Giorno {lunedi, martedi, mercoledi, giovedi, venerdi, sabato, domenica};

    private Giorno giorno;
    private Set<Orario> orari = new HashSet<Orario>();

    public Giorno getGiorno() {
        return giorno;
    }

    public void setGiorno(Giorno giorno) {
        this.giorno = giorno;
    }

    public Set<Orario> getOrari() {
        return orari;
    }

    public void setOrari(Set<Orario> orari) {
        this.orari = orari;
    }

    public void addOrario(Orario orario) {
        orari.add(orario);
    }
}
