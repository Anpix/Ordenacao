package search;

// @author Anpix

import java.util.List;


public class BinarySearch<T> {
    private int answer;
    
    public BinarySearch(List<T> vet, int inicio, int fim, T k){
        answer = Binary(vet,inicio,fim,k);
    }
    
    private int Binary(List<T> vet, int inicio, int fim, T k){
        int pos = (fim + inicio)/2;
        /*if (vet[pos].chave [pos] = k){
            return pos;
        }
        if (inicio >= fim) {
            return 0;
        }
        if (vet[pos].chave < k){
            return Binary(vet,pos+1,fim,k);
        }else{
            return Binary(vet,inicio,pos-1,k);
        }*/
        return 0;
    }
}
