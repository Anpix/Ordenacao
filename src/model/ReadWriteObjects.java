package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteObjects {

	public List<Fiscalizacao> read(String arquivo, FiscalizacaoBuilder fiscalizacaoBuilder) throws IOException {
		List<Fiscalizacao> list = new ArrayList<>();
		File file = new File(arquivo);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String linha = reader.readLine(); // Descarta a primeira linha do arquivo
		linha = reader.readLine();
		while (linha != null) {
			list.add(fiscalizacaoBuilder.constroiPorDelimitador(linha));
			linha = reader.readLine();
		}
		reader.close();
		return list;
	}
}
