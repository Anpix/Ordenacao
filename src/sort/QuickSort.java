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
 * @author Lohrann
 */
public class QuickSort<T> implements Ordenacao<T> {

    private List listaOrdenada;
    private List listaOriginal;
    private Comparator<T> comparador;
    private ContabilizadorDeTempo cronometro;

    public QuickSort(List<T> lista, Comparator<T> comparador) {
        this.listaOrdenada = new ArrayList<>(lista);
        this.listaOriginal = new ArrayList<>(lista);
        this.comparador = comparador;
        cronometro = new ContabilizadorDeTempo();
        cronometro.iniciar();
        quickSort(listaOrdenada, 0, listaOrdenada.size()-1);
        cronometro.terminar();
    }

    private void quickSort(List<T> A, int p, int r) {
        if (p < r){
            int q = partition(A, p, r);
            quickSort(A, p, q-1);
            quickSort(A, q+1, r);
        }
    }

    private int partition(List<T> A, int p, int r) {
        T aux = A.get(r);
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (comparador.compare(A.get(j), aux) <= 0) {
                i = i + 1;
                A.set(i, A.get(j));
                A.set(j, A.get(i));
            }
        }
        A.set(i + 1, A.get(r));
        A.set(r, A.get(i + 1));
        return i + 1;
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
        return cronometro.toString();
    }

}
