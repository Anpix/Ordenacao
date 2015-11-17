/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.ArrayList;
import java.util.List;
import model.Fiscalizacao;
import model.FiscalizacaoBuilder;
import model.FiscalizacaoComparador;
import sort.InsertionSort;
import sort.Ordenacao;
import sort.SelectionSort;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lohrann
 */
public class InsertionSortTest {

    private String linha[] = {
        "2008;2008/10;00.937.055/0001-22;1º LINHA AGENCIA DE SERVIÇOS LTDA;RUA GENERAL OSóRIO, 311 - SALA 01;89120-000;CENTRO;Timbó;Santa Catarina",
        "2008;2008/07;02.178.196/0001-34;022 VALTER HENRIQUE GONCALVES RAVAGNANI ME;RODOVIA ADMAR GONZAGA, 475, SALA 03;88034-000;ITACORUBI;Florianópolis;Santa Catarina",
        "2009;2009/09;03.408.722/0001-78;101 DO BRASIL INDUSTRIAL LTDAEPP;RUA ARILDO DA SILVA,101;89233-775;ITINGA;Joinville;Santa Catarina",
        "2008;2008/06;08.655.662/0001-01;2 D RESTAURANTE LANCHONETE E EVENTOS LTDA;RUA JOINVILLE, 436;89035-200;VILA NOVA;Blumenau;Santa Catarina",
        "2009;2009/12;08.257.747/0001-31;ORSESP ORGANIZACAO S ESPECIALIZADOS LTDA;ATAULFO ALVES,222;88108-220;ROCADO;São José;Santa Catarina"
    };

    @Test
    public void ordenaListaVazia() {
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        List<Fiscalizacao> listaDeFiscalizacao = new ArrayList<>();
        Ordenacao<Fiscalizacao> insertionSort = new InsertionSort<>(listaDeFiscalizacao, fiscalizacaoComparador);
        assertEquals(0, insertionSort.listaOrdenada().size());
    }

    @Test
    public void ordenaListaComUmElemento() {
        FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        List<Fiscalizacao> listaDeFiscalizacao = new ArrayList<>();
        listaDeFiscalizacao.add(fiscalizacaoBuilder.constroiPorDelimitador(linha[0]));
        Ordenacao<Fiscalizacao> insertionSort = new InsertionSort<>(listaDeFiscalizacao, fiscalizacaoComparador);
        assertEquals(1, insertionSort.listaOriginal().size());
        assertEquals(1, insertionSort.listaOrdenada().size());

        assertEquals("02.178.196/0001-34", insertionSort.listaOrdenada().get(0).getCnpj());

        assertEquals("00.937.055/0001-22", insertionSort.listaOriginal().get(0).getCnpj());
    }

    @Test
    public void ordenaListaComVariosElementos() {
        FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        List<Fiscalizacao> listaDeFiscalizacao = new ArrayList<>();
        for (int i = 0; i < linha.length; i++) {
            listaDeFiscalizacao.add(fiscalizacaoBuilder.constroiPorDelimitador(linha[i]));
        }
        
        Ordenacao<Fiscalizacao> insertionSort = new InsertionSort<>(listaDeFiscalizacao, fiscalizacaoComparador);
        assertEquals(5, insertionSort.listaOriginal().size());
        assertEquals(5, insertionSort.listaOrdenada().size());

        assertNotSame("00.937.055/0001-22", insertionSort.listaOrdenada().get(0).getCnpj());
        assertEquals("02.178.196/0001-34", insertionSort.listaOrdenada().get(0).getCnpj());
        assertEquals("00.937.055/0001-22", insertionSort.listaOriginal().get(0).getCnpj());
    }
}
