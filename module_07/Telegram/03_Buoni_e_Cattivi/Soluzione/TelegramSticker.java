package buoniecattivi;
import java.util.Objects;

public class TelegramSticker {
    private String uniqueID;
    private String idToSend;

    public TelegramSticker(String uniqueID, String idToSend) {
        this.uniqueID = uniqueID;
        this.idToSend = idToSend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelegramSticker that = (TelegramSticker) o;
        return Objects.equals(uniqueID, that.uniqueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueID);
    }

    public String getIdToSend() {
        return idToSend;
    }

    @Override
    public String toString() {
        return uniqueID + ';' + idToSend;
    }
}
