/**
 * La classe Snack considera la quantità come singolo pacchetto
 */
public class Snack extends Prodotto {
    @Override
    public void prendiProdotto() {
        setQuantita(getQuantita() - 1);
    }

    @Override
    public void aggiungiProdotto() {
        setQuantita(getQuantita() - 1);
    }
}
