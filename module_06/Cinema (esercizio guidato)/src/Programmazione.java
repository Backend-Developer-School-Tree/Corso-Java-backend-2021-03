public class Programmazione {
    public enum Giorno {lunedi, martedi, mercoledi, giovedi, venerdi, sabato, domenica};

    private Giorno giorno;
    private Orario[] orari;

    public Giorno getGiorno() {
        return giorno;
    }

    public void setGiorno(Giorno giorno) {
        this.giorno = giorno;
    }

    public Orario[] getOrari() {
        return orari;
    }

    public void setOrari(Orario[] orari) {
        this.orari = orari;
    }
}
