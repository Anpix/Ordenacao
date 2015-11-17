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
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Lohrann
 * @param <T>
 */
public class MergeSort<T> implements Ordenacao<T> {

    private List listaOrdenada;
    private List listaOriginal;
    private Comparator<T> comparador;
    private ContabilizadorDeTempo cronometro;

    public MergeSort(List<T> lista, Comparator<T> comparador) {
        this.listaOrdenada = new ArrayList<>(lista);
        this.listaOriginal = new ArrayList<>(lista);
        this.comparador = comparador;
        cronometro = new ContabilizadorDeTempo();
        cronometro.iniciar();
        mergeSort(listaOrdenada, 0, listaOrdenada.size() - 1);
        cronometro.terminar();
    }

    private void mergeSort(List<T> A, int p, int r) {
        int q;
        if (p < r) {
            q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    private void merge(List<T> A, int p, int q, int r) {
        int i, j;
        int n1 = q - p + 1;
        int n2 = r - q;
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
        for (i = 1; i <= n1; i++) {
            left.add(A.get(p + i - 1));
        }
        for (j = 1; j <= n2; j++) {
            right.add(A.get(q + j));
        }
        i = 1;
        j = 1;
        int k = p;
        while (i < n1 && j < n2) {
            if (comparador.compare(left.get(i), right.get(j)) <= 0) {
                A.set(k, left.get(i));
                i = i + 1;
            } else {
                A.set(k, right.get(j));
                j = j + 1;
            }
            k = k + 1;
        }

        while (i < n1) {
            A.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            A.set(k, right.get(j));
            j++;
            k++;
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
        return cronometro.toString();
    }

}
