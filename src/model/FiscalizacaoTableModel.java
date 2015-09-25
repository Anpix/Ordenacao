package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FiscalizacaoTableModel extends AbstractTableModel  {

	private static final long serialVersionUID = -5174304820197989877L;
	private List<Fiscalizacao> data;
        private final List<Fiscalizacao> fiscalizacaoList;
	private final String coluna[] = {"CNPJ", "Ano", "Mês", "Empregador", "Logradouro", "Município", "CEP" };

	public FiscalizacaoTableModel(List<Fiscalizacao> fiscalizacaoList) {
		super();
		this.fiscalizacaoList = fiscalizacaoList;
                this.data = fiscalizacaoList;
	}

	@Override
	public int getRowCount() {
		return fiscalizacaoList.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Fiscalizacao fiscalizacao = fiscalizacaoList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return fiscalizacao.getCnpj();
		case 1:
			return fiscalizacao.getAno();
		case 2:
			return fiscalizacao.getMes();
		case 3:
			return fiscalizacao.getEmpregador();
		case 4:
			return fiscalizacao.getLogradouro();
		case 5:
			return fiscalizacao.getMunicipio();
		case 6:
			return fiscalizacao.getCep();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return coluna[columnIndex];
	}

        //Já que esse tableModel é de livros, vamos fazer um get que retorne um livro inteiro.  
        //Isso elimina a necessidade de chamar o getValueAt() nas telas.   
        public Fiscalizacao get(int row) {
            return fiscalizacaoList.get(row);
        }

}
