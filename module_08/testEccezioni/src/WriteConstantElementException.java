public class WriteConstantElementException extends RuntimeException{

    private int position;
    public WriteConstantElementException(int position)
    {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
