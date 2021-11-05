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
}
