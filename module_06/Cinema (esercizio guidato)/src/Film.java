public class Film {
    private String name;
    private int durata; //durata in minuti
    private String[] cast;

    public Film(String name, int durata) {
        this.name = name;
        this.durata = durata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }
}
