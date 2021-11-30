package buoniecattivi;

public enum ComandiBOT {
    RANDOMBUONO("/randomBuoni"),RANDOMCATTIVO("/randomCattivi"),RANDOM("/random"), ERRORE("");


    private String str;
    /**
     * Costruttore privato che costruisce l'enum da stringa
     * @param str
     */
    private ComandiBOT(String str)
    {
        this.str=str;
    }

    @Override
    public String toString()
    {
        return str;
    }
    /**
     * Metodo per poter costruire l'enum da Stringa
     * @param text
     * @return
     *
     */
    public static ComandiBOT fromString(String text) {
        if (text != null) {
            for (ComandiBOT c : ComandiBOT.values()) {
                if (text.equals(c.str)) {
                    return c;
                }
            }
        }
        return ComandiBOT.ERRORE;
    }
}
