/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.ContabilizadorDeTempo;

/**
 *
 * @author Acer
 * @param <T>
 */
public class SelectionSort<T> implements Ordenacao<T> {

    private List<T> listaOrdenada;
    private List<T> listaOriginal;
    private ContabilizadorDeTempo cronometro;
    private Comparator<T> comparador;

    public SelectionSort(List lista, Comparator<T> comparador) {
        this.listaOrdenada = new ArrayList<>(lista);
        this.listaOriginal = new ArrayList<>(lista);
        this.comparador = comparador;
        cronometro = new ContabilizadorDeTempo();
        cronometro.iniciar();
        ordenar();
        cronometro.terminar();
    }

    private void ordenar() {
        T min;
        int indiceMenor;
        for (int i = 0; i < (listaOrdenada.size() - 1); i++) {
            min = listaOrdenada.get(i);
            indiceMenor = i;
            for (int j = i + 1; j < listaOrdenada.size(); j++) {
                if (comparador.compare(listaOrdenada.get(i), listaOrdenada.get(j)) < 0) {
                    min = listaOrdenada.get(j);
                    indiceMenor = j;
                }
            }
            listaOrdenada.set(indiceMenor, listaOrdenada.get(i));
            listaOrdenada.set(i, min);
        }
    }

    @Override
    public List<T> listaOrdenada() {
        return listaOrdenada;
    }

    @Override
    public List<T> listaOriginal() {
        return listaOriginal;
    }
    
    @Override
    public String tempoDeOrdenacao() {
        return cronometro.toString();
    }



}
