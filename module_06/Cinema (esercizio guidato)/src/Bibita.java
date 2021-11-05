/**
 * La classe Bibita considera la quantita come litri.
 */
public class Bibita extends Prodotto{
    @Override
    public void prendiProdotto() {
        setQuantita(getQuantita() - 10);
    }

    @Override
    public void aggiungiProdotto() {
        setQuantita(getQuantita() + 10);
    }
}
