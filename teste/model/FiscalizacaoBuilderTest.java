package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FiscalizacaoBuilderTest {

	private String linha[] = { 
			"2008;2008/07;02.178.196/0001-34;022 VALTER HENRIQUE GONCALVES RAVAGNANI ME;RODOVIA ADMAR GONZAGA, 475, SALA 03;88034-000;ITACORUBI;Florianópolis;Santa Catarina",
			"2009;2009/09;03.408.722/0001-78;101 DO BRASIL INDUSTRIAL LTDAEPP;RUA ARILDO DA SILVA,101;89233-775;ITINGA;Joinville;Santa Catarina",
			"2008;2008/10;00.937.055/0001-22;1º LINHA AGENCIA DE SERVIÇOS LTDA;RUA GENERAL OSóRIO, 311 - SALA 01;89120-000;CENTRO;Timbó;Santa Catarina",
			"2008;2008/06;08.655.662/0001-01;2 D RESTAURANTE LANCHONETE E EVENTOS LTDA;RUA JOINVILLE, 436;89035-200;VILA NOVA;Blumenau;Santa Catarina"
		};
	
	@Test
	public void instanciaPorUmaLinhaComDelimitador() {
		FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
		Fiscalizacao fiscalizacao = fiscalizacaoBuilder.constroiPorDelimitador(linha[0]);
		
		assertEquals(2008, fiscalizacao.getAno());
		assertEquals(7, fiscalizacao.getMes());
		assertEquals("02.178.196/0001-34", fiscalizacao.getCnpj());
		assertEquals("022 VALTER HENRIQUE GONCALVES RAVAGNANI ME", fiscalizacao.getEmpregador());
		assertEquals("RODOVIA ADMAR GONZAGA, 475, SALA 03", fiscalizacao.getLogradouro());
		assertEquals("88034-000", fiscalizacao.getCep());
		assertEquals("ITACORUBI", fiscalizacao.getBairro());
		assertEquals("Florianópolis", fiscalizacao.getMunicipio());
		assertEquals("Santa Catarina", fiscalizacao.getUf());
	}

}
