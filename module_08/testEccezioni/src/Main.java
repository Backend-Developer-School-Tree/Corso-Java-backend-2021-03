public class Main {

    public static void main(String[] args) {

        ListaConCostanti ls = new ListaConCostanti();
        ls.addElement(5);
        ls.addElement(15);
        ls.addElement(1);

        System.out.println(ls);
        try{
            ls.removeAt(0);
        }
        catch (WriteConstantElementException wcee)
        {
            System.out.println(wcee.getPosition());
        }

        System.out.println(ls);
    }
}
