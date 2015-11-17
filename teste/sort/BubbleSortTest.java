/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.ArrayList;
import java.util.List;
import sort.BubbleSort;
import model.Fiscalizacao;
import model.FiscalizacaoBuilder;
import model.FiscalizacaoComparador;
import sort.Ordenacao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lohrann
 */
public class BubbleSortTest {

    private String linha[] = {
        "2008;2008/10;00.937.055/0001-22;1º LINHA AGENCIA DE SERVIÇOS LTDA;RUA GENERAL OSóRIO, 311 - SALA 01;89120-000;CENTRO;Timbó;Santa Catarina",
        "2008;2008/07;02.178.196/0001-34;022 VALTER HENRIQUE GONCALVES RAVAGNANI ME;RODOVIA ADMAR GONZAGA, 475, SALA 03;88034-000;ITACORUBI;Florianópolis;Santa Catarina",
        "2009;2009/09;03.408.722/0001-78;101 DO BRASIL INDUSTRIAL LTDAEPP;RUA ARILDO DA SILVA,101;89233-775;ITINGA;Joinville;Santa Catarina",
        "2008;2008/06;08.655.662/0001-01;2 D RESTAURANTE LANCHONETE E EVENTOS LTDA;RUA JOINVILLE, 436;89035-200;VILA NOVA;Blumenau;Santa Catarina",
        "2009;2009/12;08.257.747/0001-31;ORSESP ORGANIZACAO S ESPECIALIZADOS LTDA;ATAULFO ALVES,222;88108-220;ROCADO;São José;Santa Catarina",
        "2010;2010/05;07.751.867/0001-28;A A A DE OLIVEIRA E CIA LTDA;AVEN GETULIO VARGAS,167;89801-000;CENTRO;Chapecó;Santa Catarina;;",
        "2009;2009/05;04.626.226/0001-53;A ABC DESENTUPIDORA FORTALEZA LTDA - ME;RUA BOTAFOGO, 259;89210-050;FLORESTA;Joinville;Santa Catarina;",
        "2009;2009/04;81.622.417/0001-98;A ACORREA ESCAVACOES E TRANSPORTE LTDA;RODOVIA BR 101, KM 334;88700-000;HUMAITA;Tubarão;Santa Catarina;;",
        "2008;2008/09;83.646.984/0009-67;A ANGELONI & CIA LTDA; AV CENTENARIO;88801-000;CENTRO;Criciúma;Santa Catarina;;",
        "2008;2008/06;83.646.984/0009-67;A ANGELONI & CIA LTDA;AV CENTENARIO, 2699;88800-000;CENTRO;Criciúma;Santa Catarina;;",
        "2008;2008/06;83.646.984/0017-77;A ANGELONI & CIA LTDA;AV CENTENARIO, 7521;88800-000;N.S. SALETE;Criciúma;Santa Catarina;;",
        "2009;2009/05;83.646.984/0008-86;A ANGELONI & CIA LTDA;AV EXP JOSE PEDRO COELHO, 1120;88700-000;CENTRO;Tubarão;Santa Catarina;;",
        "2008;2008/08;83.646.984/0018-58;A ANGELONI & CIA LTDA;AV IRINEU BORNHAUSEN 5288;88025-202;CENTRO;Florianópolis;Santa Catarina;;",
        "2008;2008/09;83.646.984/0069-06;A ANGELONI & CIA LTDA;BR 101 KM 156,5;88210-000;ALTO PEREQUE;Porto Belo;Santa Catarina;;"
    };

    @Test
    public void ordenaListaVazia() {
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        List<Fiscalizacao> listaDeFiscalizacao = new ArrayList<>();
        Ordenacao<Fiscalizacao> bubbleSort = new BubbleSort<>(listaDeFiscalizacao, fiscalizacaoComparador);
        assertEquals(0, bubbleSort.listaOrdenada().size());
    }

    @Test
    public void ordenaListaComUmElemento() {
        FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        List<Fiscalizacao> listaDeFiscalizacao = new ArrayList<>();
        listaDeFiscalizacao.add(fiscalizacaoBuilder.constroiPorDelimitador(linha[0]));
        Ordenacao<Fiscalizacao> bubbleSort = new BubbleSort<>(listaDeFiscalizacao, fiscalizacaoComparador);
        assertEquals(listaDeFiscalizacao.get(0), bubbleSort.listaOrdenada().get(0));
    }

    @Test
    public void ordenaListaComVariosElementos() {
        FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
        FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
        List<Fiscalizacao> listaDeFiscalizacao = new ArrayList<>();
        for (int i = 0; i < linha.length; i++) {
            listaDeFiscalizacao.add(fiscalizacaoBuilder.constroiPorDelimitador(linha[i]));
        }
        Ordenacao<Fiscalizacao> bubbleSort = new BubbleSort<>(listaDeFiscalizacao, fiscalizacaoComparador);
        assertEquals(listaDeFiscalizacao.get(1), bubbleSort.listaOrdenada().get(1));
        assertEquals(listaDeFiscalizacao.get(2), bubbleSort.listaOrdenada().get(2));
        assertEquals(listaDeFiscalizacao.get(4), bubbleSort.listaOrdenada().get(3));
        assertEquals(listaDeFiscalizacao.get(3), bubbleSort.listaOrdenada().get(4));
        assertNotSame(listaDeFiscalizacao.get(3), bubbleSort.listaOrdenada().get(3));
        assertNotSame(listaDeFiscalizacao.get(4), bubbleSort.listaOrdenada().get(4));
    }

}
