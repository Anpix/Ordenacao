/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vetor;

import java.util.List;

/**
 *
 * @author Anpix
 */
public class RemoverNaoOrdenado<T> {
    
    
    public RemoverNaoOrdenado(List<T> vet, int n, T k){
        if (n != 0) {
            int i = Buscar(vet,n,k);
            if (i != 0){
                vet.[i] = vet[n];
                n = n-1;
            }
        }
    
    }
    
}
