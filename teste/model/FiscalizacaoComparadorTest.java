package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FiscalizacaoComparadorTest {

	private String linha[] = { 
			"2008;2008/07;02.178.196/0001-34;022 VALTER HENRIQUE GONCALVES RAVAGNANI ME;RODOVIA ADMAR GONZAGA, 475, SALA 03;88034-000;ITACORUBI;Florianópolis;Santa Catarina",
			"2008;2008/06;08.655.662/0001-01;2 D RESTAURANTE LANCHONETE E EVENTOS LTDA;RUA JOINVILLE, 436;89035-200;VILA NOVA;Blumenau;Santa Catarina",
			"2009;2008/06;08.655.662/0001-01;2 D RESTAURANTE LANCHONETE E EVENTOS LTDA;RUA JOINVILLE, 436;89035-200;VILA NOVA;Blumenau;Santa Catarina",
			"2008;2008/07;08.655.662/0001-01;2 D RESTAURANTE LANCHONETE E EVENTOS LTDA;RUA JOINVILLE, 436;89035-200;VILA NOVA;Blumenau;Santa Catarina"
		};

	@Test
	public void fiscalizacoesIguais() {
		FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
		Fiscalizacao fiscalizacao1 = fiscalizacaoBuilder.constroiPorDelimitador(linha[0]);
		Fiscalizacao fiscalizacao2 = fiscalizacaoBuilder.constroiPorDelimitador(linha[0]);
		FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
		assertEquals(0, fiscalizacaoComparador.compare(fiscalizacao1, fiscalizacao2));
		
	}
	@Test
	public void fiscalizacoesDiferentes() {
		FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
		Fiscalizacao fiscalizacao1 = fiscalizacaoBuilder.constroiPorDelimitador(linha[0]);
		Fiscalizacao fiscalizacao2 = fiscalizacaoBuilder.constroiPorDelimitador(linha[1]);
		FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
		assertNotSame(0, fiscalizacaoComparador.compare(fiscalizacao1, fiscalizacao2));
	}
	@Test
	public void primeiraFiscalizacaoComCNPJMenorQueoDaSegunda() {
		FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
		Fiscalizacao fiscalizacao1 = fiscalizacaoBuilder.constroiPorDelimitador(linha[1]);
		Fiscalizacao fiscalizacao2 = fiscalizacaoBuilder.constroiPorDelimitador(linha[2]);
		FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
		assertEquals(-1, fiscalizacaoComparador.compare(fiscalizacao1, fiscalizacao2));
		assertEquals( 1, fiscalizacaoComparador.compare(fiscalizacao2, fiscalizacao1));
	}
	@Test
	public void primeiraFiscalizacaoComCNPJIgualAoDaSegundaMasOAnoMenor() {
		FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
		Fiscalizacao fiscalizacao1 = fiscalizacaoBuilder.constroiPorDelimitador(linha[1]);
		Fiscalizacao fiscalizacao2 = fiscalizacaoBuilder.constroiPorDelimitador(linha[2]);
		FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
		assertEquals(-1, fiscalizacaoComparador.compare(fiscalizacao1, fiscalizacao2));
		assertEquals( 1, fiscalizacaoComparador.compare(fiscalizacao2, fiscalizacao1));
	}
	@Test
	public void primeiraFiscalizacaoComCnpjEAnoIguaisAoDaSegundaMasComMesMenor() {
		FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
		Fiscalizacao fiscalizacao1 = fiscalizacaoBuilder.constroiPorDelimitador(linha[1]);
		Fiscalizacao fiscalizacao2 = fiscalizacaoBuilder.constroiPorDelimitador(linha[3]);
		FiscalizacaoComparador fiscalizacaoComparador = new FiscalizacaoComparador();
		assertEquals(-1, fiscalizacaoComparador.compare(fiscalizacao1, fiscalizacao2));
		assertEquals( 1, fiscalizacaoComparador.compare(fiscalizacao2, fiscalizacao1));
	}

}
