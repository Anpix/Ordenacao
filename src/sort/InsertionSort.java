package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.ContabilizadorDeTempo;

// @author Anpix

public class InsertionSort<T> implements Ordenacao<T>{

    private List<T> listaOrdenada;
    private Comparator<T> comparador;
    private List<T> listaOriginal;
    private ContabilizadorDeTempo cronometro;
    private List<T> tempoOrd;

    public InsertionSort(List<T> lista, Comparator<T> comparador) {
        this.listaOrdenada = new ArrayList(lista);
        this.listaOriginal = new ArrayList(lista);
        this.comparador = comparador;
        cronometro = new ContabilizadorDeTempo();
        cronometro.iniciar();
   
        ordenar();
        cronometro.terminar();

        
    }

    private void ordenar() {
        listaOrdenada.add(0, null);
        for (int i = 2; i < listaOrdenada.size(); i++) {
            T temp = listaOrdenada.get(i);
            listaOrdenada.set(0, temp);
            int j = i;
            while (comparador.compare(listaOrdenada.get(j - 1), temp) > 0) {
                T aux = listaOrdenada.get(j - 1);
                listaOrdenada.set(j, aux);
                j = j - 1;
            }
            listaOrdenada.set(j, temp);
        }
        listaOrdenada.remove(0);
    }


    @Override
    public String tempoDeOrdenacao() {
        return cronometro.toString();
    }
    
    @Override
    public List listaOriginal() {
        return listaOriginal;
    }

    @Override
    public List listaOrdenada() {
        return listaOrdenada;
    }
    

}
