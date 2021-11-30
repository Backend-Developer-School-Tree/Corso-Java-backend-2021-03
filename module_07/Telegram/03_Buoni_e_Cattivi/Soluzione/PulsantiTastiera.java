package buoniecattivi;
public enum PulsantiTastiera {
    BUONI("\uD83D\uDE07"),CATTIVI("\uD83D\uDE08"),NO("No Grazie"), ERRORE("");


    private String str;
    /**
     * Costruttore privato che costruisce l'enum da stringa
     * @param str
     */
    private PulsantiTastiera(String str)
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
    public static PulsantiTastiera fromString(String text) {
        if (text != null) {
            for (PulsantiTastiera c : PulsantiTastiera.values()) {
                if (text.equals(c.str)) {
                    return c;
                }
            }
        }
        return PulsantiTastiera.ERRORE;
    }
}
