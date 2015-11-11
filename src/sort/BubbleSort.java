package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.ContabilizadorDeTempo;
import model.Ordenacao;

public class BubbleSort<T> implements Ordenacao<T> {

    private List<T> listaOriginal;
    private List<T> listaOrdenada;
    private Comparator<T> comparador;
    private ContabilizadorDeTempo contabilizadorDeTempo;

    public BubbleSort(List<T> lista, Comparator<T> comparador) {
        this.listaOriginal = new ArrayList<>(lista);
        this.comparador = comparador;
        contabilizadorDeTempo = new ContabilizadorDeTempo();
        contabilizadorDeTempo.iniciar();
        this.ordenar();
        contabilizadorDeTempo.terminar();
    }

    private void ordenar() {
        this.listaOrdenada = new ArrayList<>(listaOriginal);

        //Falta script
        for(int i=0; i < listaOrdenada.size(); i++) {
            for(int j=i+1; j < listaOrdenada.size(); j++) {
                if(comparador.compare(listaOrdenada.get(i), listaOrdenada.get(j)) > 0) {
                    T objeto = this.listaOrdenada.get(i);
                    listaOrdenada.set(i, this.listaOrdenada.get(j));
                    listaOrdenada.set(j, objeto);
                }
            }
        }
    }

    @Override
    public List<T> listaOriginal() {
        return listaOriginal;
    }

    @Override
    public List<T> listaOrdenada() {
        return listaOrdenada;
    }

    @Override
    public String tempoDeOrdenacao() {
        return contabilizadorDeTempo.toString();
    }
}
