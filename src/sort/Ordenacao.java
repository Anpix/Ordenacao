package sort;

import java.util.List;

public interface Ordenacao<T> {
	List<T> listaOriginal();
	List<T> listaOrdenada();
	/**
	 * 
	 * @return String no formato HH:mm:ss.SSS
	 */
	String tempoDeOrdenacao();  
}
