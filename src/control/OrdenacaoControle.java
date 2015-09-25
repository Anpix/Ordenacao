package control;

import java.io.IOException;
import java.util.List;

import javax.swing.JDialog;

import model.Fiscalizacao;
import model.FiscalizacaoBuilder;
import model.FiscalizacaoComparador;
import model.Ordenacao;
import model.ReadWriteObjects;
import sort.*;
import view.OrdenacaoForm;

public class OrdenacaoControle {
	
	private OrdenacaoForm ordenacaoForm;

	public void showForm() {
		try {
			ordenacaoForm = new OrdenacaoForm(this);
			ordenacaoForm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ordenacaoForm.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregaArquivo(String arquivo) {
		FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
		ReadWriteObjects readWriteObjects = new ReadWriteObjects();
		List<Fiscalizacao> fiscalizacaoList = null;
		try {
			fiscalizacaoList = readWriteObjects.read(arquivo, fiscalizacaoBuilder);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		ordenacaoForm.mostraListaDeFiscalizacao(fiscalizacaoList);
	}

	public void closeForm() {
		ordenacaoForm.setVisible(false);
		ordenacaoForm = null;
		System.exit(0);
	}

	public void ordenarPorSelectionSort(List<Fiscalizacao> fiscalizacaoList) {
		FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
		Ordenacao<Fiscalizacao> selectionSort = new SelectionSort<>(fiscalizacaoList, fiscalizacaoComparador);
		ordenacaoForm.ordenacaoRealizadaPorSelectionSort(selectionSort.listaOrdenada());
	}

        public void ordenarPorInsertionSort(List<Fiscalizacao> fiscalizacaoList) {
		FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
		Ordenacao<Fiscalizacao> insertionSort = new InsertionSort<>(fiscalizacaoList, fiscalizacaoComparador);
		ordenacaoForm.ordenacaoRealizadaPorInsertionSort(insertionSort.listaOrdenada());
        }
        
        public void ordenarPorBubbleSort(List<Fiscalizacao> fiscalizacaoList) {
		FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
		Ordenacao<Fiscalizacao> bubbleSort = new BubbleSort<>(fiscalizacaoList, fiscalizacaoComparador);
		ordenacaoForm.ordenacaoRealizadaPorBubbleSort(bubbleSort.listaOrdenada());
	}
}
