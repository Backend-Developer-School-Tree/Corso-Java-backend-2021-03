import java.util.Objects;

public abstract class Prodotto {
    private String name;
    private float prezzo;
    private int quantita;

    public abstract void prendiProdotto();
    public abstract void aggiungiProdotto();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        if(quantita >= 0)
            this.quantita = quantita;
        else
            System.out.println("Quantità non valida, deve essere >= 0");
    }

    public boolean isDisponibile() {
        return quantita != 0;
    }

    /**
     * Ritorna 0 se i due oggetti hanno lo stesso prezzo
     * Ritorna 1 se prezzo > o.prezzo
     * Ritorna -1 se prezzo < o.prezzo
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        Prodotto prodotto = (Prodotto) o;
        return Float.compare(prezzo, prodotto.prezzo);
    }

    /**
     * Due Prodotti sono uguali se hanno lo stesso nome.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Prodotto prodotto = (Prodotto) o;
        return Objects.equals(name, prodotto.name);
    }

    /**
     * Hash code calcolato in base a nome, prezzo e quantità
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, prezzo, quantita);
    }
}
