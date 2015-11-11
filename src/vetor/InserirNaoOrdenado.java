package vetor;

// @author Anpix

import java.util.List;


public class InserirNaoOrdenado<T> {
    
    
    
    public void InsercaoEmVetorNaoOrdenado(List<T> vet, int n, T e){
        if (n < vet.size()) {
            vet[n+1] = e;
            n = n+1;
        }else{
            //Overflow
        }
    }
    
}
