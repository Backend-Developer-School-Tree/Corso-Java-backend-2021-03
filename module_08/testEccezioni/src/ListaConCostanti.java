import java.util.ArrayList;

public class ListaConCostanti {

    private ArrayList<Integer> lista;


    public ListaConCostanti()
    {
        lista = new ArrayList<>();
        lista.add(8);
        lista.add(42);
        lista.add(29);
    }

    public void removeAt(int index)
    {
        if(index < 3)
            throw new WriteConstantElementException(index);
        if(index < lista.size())
            lista.remove(index);
    }

    public void addElement(int z)
    {
        lista.add(z);
    }


    @Override
    public String toString() {
        return "ListaConCostanti{" +
                "lista=" + lista +
                '}';
    }
}
