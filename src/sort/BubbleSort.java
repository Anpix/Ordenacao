package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.ContabilizadorDeTempo;

// @author Anpix

public class BubbleSort<T> implements Ordenacao<T> {

    private List<T> listaOrdenada;
    private List<T> listaOriginal;
    private ContabilizadorDeTempo cronometro;
    private Comparator<T> comparador;

    public BubbleSort(List<T> lista, Comparator<T> comparador) {
        this.listaOrdenada = new ArrayList(lista);
        this.listaOriginal = new ArrayList(lista);
        this.comparador = comparador;
        cronometro = new ContabilizadorDeTempo();
        cronometro.iniciar();
        ordenar();
        cronometro.terminar();
    }

    private void ordenar() {
        int i, j;
        for (i = listaOrdenada.size() - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (comparador.compare(listaOrdenada.get(j), listaOrdenada.get(j + 1)) > 0) {
                    T aux = listaOrdenada.get(j);
                    listaOrdenada.set(j, listaOrdenada.get(j + 1));
                    listaOrdenada.set(j + 1, aux);
                }
                System.out.println("Trocou! Posição " + i + "agora: " + listaOrdenada.get(i));
            }
        }

    }

    @Override
    public String tempoDeOrdenacao() {
        return cronometro.toString();
    }

    @Override
    public List<T> listaOriginal() {
        return listaOriginal;
    }

    @Override
    public List<T> listaOrdenada() {
        return listaOrdenada;
    }

}
