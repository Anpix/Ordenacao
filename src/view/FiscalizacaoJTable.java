package view;

import java.util.Collections;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import model.FiscalizacaoTableModel;

public class FiscalizacaoJTable extends JTable {

	private static final long serialVersionUID = -5621684154068272223L;
	private String coluna[] = {"CNPJ", "Ano", "Mês", "Empregador", "Logradouro", "Município", "CEP"};

	public FiscalizacaoJTable() {
		super();
                
		setModel(new FiscalizacaoTableModel(Collections.emptyList()));
	}

	public FiscalizacaoJTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	public FiscalizacaoJTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
		setModel(new FiscalizacaoTableModel(Collections.emptyList()));
	}

	public FiscalizacaoJTable(TableModel dm) {
		super(dm);
		TableColumnModel columnModel = getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(120);
		columnModel.getColumn(1).setPreferredWidth(120);
		columnModel.getColumn(2).setPreferredWidth(20);
		columnModel.getColumn(3).setPreferredWidth(20);
		columnModel.getColumn(4).setPreferredWidth(20);
		columnModel.getColumn(5).setPreferredWidth(20);
		columnModel.getColumn(6).setPreferredWidth(20);
                
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return coluna[columnIndex];
	}

	
	

}
