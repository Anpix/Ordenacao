package model;

import java.util.Comparator;

public class FiscalizacaoComparador implements Comparator<Fiscalizacao>{

	@Override
	public int compare(Fiscalizacao fiscalizacao, Fiscalizacao outraFiscalizacao) {
		String chaveDeComparacao1 = montaChaveDeComparacao(fiscalizacao);
		String chaveDeComparacao2 = montaChaveDeComparacao(outraFiscalizacao);
		return chaveDeComparacao1.compareTo(chaveDeComparacao2);
	}

	private String montaChaveDeComparacao(Fiscalizacao fiscalizacao) {
		return String.format("%20s%4d%2d", fiscalizacao.getCnpj(), fiscalizacao.getAno(), fiscalizacao.getMes());
	}

}
