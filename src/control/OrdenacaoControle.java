package control;

import java.io.IOException;
import java.util.List;
import sort.BubbleSort;

import model.Fiscalizacao;
import model.FiscalizacaoBuilder;
import model.FiscalizacaoComparador;
import sort.InsertionSort;
import sort.MergeSort;
import sort.Ordenacao;
import sort.QuickSort;
import model.ReadWriteObjects;
import sort.SelectionSort;

public class OrdenacaoControle {

    public List loadFile(String arquivo) {
        FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
        ReadWriteObjects readWriteObjects = new ReadWriteObjects();
        List<Fiscalizacao> fiscalizacaoList = null;
        try {
            fiscalizacaoList = readWriteObjects.read(arquivo, fiscalizacaoBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fiscalizacaoList;
    }

    public Ordenacao<Fiscalizacao> ordenarSelectionSort(List<Fiscalizacao> fiscalizacaoList) {
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        Ordenacao<Fiscalizacao> selectionSort = new SelectionSort<>(fiscalizacaoList, fiscalizacaoComparador);
        return selectionSort;
    }
    
    public Ordenacao<Fiscalizacao> ordenarInsertionSort(List<Fiscalizacao> fiscalizacaoList) {
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        Ordenacao<Fiscalizacao> insertionSort = new InsertionSort<>(fiscalizacaoList, fiscalizacaoComparador);
        return insertionSort;
    }
    
    public Ordenacao<Fiscalizacao> ordenarBubbleSort(List<Fiscalizacao> fiscalizacaoList) {
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        Ordenacao<Fiscalizacao> bubbleSort = new BubbleSort<>(fiscalizacaoList, fiscalizacaoComparador);
        return bubbleSort;
    }
    
    public Ordenacao<Fiscalizacao> ordenarMergeSort(List<Fiscalizacao> fiscalizacaoList) {
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        Ordenacao<Fiscalizacao> mergeSort = new MergeSort<>(fiscalizacaoList, fiscalizacaoComparador);
        return mergeSort;
    }
    
    public Ordenacao<Fiscalizacao> ordenarQuickSort(List<Fiscalizacao> fiscalizacaoList) {
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        Ordenacao<Fiscalizacao> quickSort = new QuickSort<>(fiscalizacaoList, fiscalizacaoComparador);
        return quickSort;
    }

    public void closeForm() {
        System.exit(0);
    }

}
