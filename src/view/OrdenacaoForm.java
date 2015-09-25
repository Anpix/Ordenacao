package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableColumnModel;

import control.OrdenacaoControle;
import model.Fiscalizacao;
import model.FiscalizacaoTableModel;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class OrdenacaoForm extends JDialog {

	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private OrdenacaoControle ordenacaoControle = null;
	private OrdenacaoForm ordenacaoForm = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField arquivoField;

	private List<Fiscalizacao> fiscalizacaoList = Collections.emptyList();

	private JTable fiscalizacaoTable;

	private FiscalizacaoJTable SortTable;

	/**
	 * Create the dialog.
	 */
	public OrdenacaoForm(OrdenacaoControle ordenacaoControle) {
		setResizable(false);
		this.ordenacaoControle = ordenacaoControle;
		this.ordenacaoForm = this;

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}

		setBounds(100, 100, 971, 658);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new CompoundBorder(null, new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0))));
		tabbedPane.setBounds(6, 6, 959, 585);
		contentPanel.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Algoritmos de Ordenação", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Algoritmo de Ordenação");
		label.setBounds(41, 21, 162, 16);
		label.setForeground(new Color(25, 25, 112));
		panel.add(label);
		
		JLabel label_1 = new JLabel("SelectionSort");
		label_1.setBounds(41, 49, 110, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("InsertionSort");
		label_2.setBounds(41, 77, 110, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("BubbleSort");
		label_3.setBounds(41, 105, 110, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("MergeSort");
		label_4.setBounds(41, 133, 110, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("QuickSort");
		label_5.setBounds(41, 161, 110, 16);
		panel.add(label_5);
		
		//Quick Sort
                textField = new JTextField();
		textField.setBounds(270, 161, 125, 28);
		textField.setEditable(false);
		textField.setColumns(10);
		panel.add(textField);
		
                //Merge Sort
		textField_1 = new JTextField();
		textField_1.setBounds(270, 133, 125, 28);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
                //
		textField_2 = new JTextField();
		textField_2.setBounds(270, 105, 125, 28);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
                //
		textField_3 = new JTextField();
		textField_3.setBounds(270, 77, 125, 28);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
                //
		textField_4 = new JTextField();
		textField_4.setBounds(270, 50, 125, 28);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		JLabel label_6 = new JLabel("HH:mm:ss.SSS");
		label_6.setBounds(285, 21, 110, 16);
		label_6.setForeground(new Color(25, 25, 112));
		panel.add(label_6);
		
		JButton button_4 = new JButton(new ImageIcon(OrdenacaoForm.class.getResource("/resource/lightning.png")));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenacaoControle.ordenarPorSelectionSort(fiscalizacaoList);
                                textField_3.setText(String.valueOf(fiscalizacaoList.size()));
                                textField_2.setText(String.valueOf(fiscalizacaoList.get(1).getEmpregador()));
			}
		});
		button_4.setBounds(395, 53, 23, 20);
		panel.add(button_4);
		
		JButton button = new JButton(new ImageIcon(OrdenacaoForm.class.getResource("/resource/lightning.png")));
		button.setBounds(395, 80, 23, 20);
		panel.add(button);
		
		JButton button_1 = new JButton(new ImageIcon(OrdenacaoForm.class.getResource("/resource/lightning.png")));
		button_1.setBounds(395, 109, 23, 20);
		panel.add(button_1);
		
		JButton button_2 = new JButton(new ImageIcon(OrdenacaoForm.class.getResource("/resource/lightning.png")));
		button_2.setBounds(395, 137, 23, 20);
		panel.add(button_2);
		
		JButton button_3 = new JButton(new ImageIcon(OrdenacaoForm.class.getResource("/resource/lightning.png")));
		button_3.setBounds(395, 165, 23, 20);
		panel.add(button_3);
		
		JLabel lblArquivo = new JLabel("Arquivo");
		lblArquivo.setBounds(486, 21, 61, 16);
		panel.add(lblArquivo);
		
		arquivoField = new JTextField();
		arquivoField.setBounds(480, 49, 401, 28);
		arquivoField.setEditable(false);
		arquivoField.setColumns(10);
		panel.add(arquivoField);
		
		JButton button_5 = new JButton(new ImageIcon(OrdenacaoForm.class.getResource("/resource/search-icon.png")));
		button_5.setBounds(880, 53, 23, 20);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showOpenDialog(ordenacaoForm);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String arquivo = file.getAbsolutePath();
					arquivoField.setText(arquivo);
					ordenacaoControle.carregaArquivo(arquivo);
                                        SortTable.setModel(new FiscalizacaoTableModel(fiscalizacaoList));
                                        
                                        textField_1.setText(String.valueOf(fiscalizacaoList.get(1).getEmpregador()));
                                        textField.setText(String.valueOf(fiscalizacaoList.size()));
				}
			}
		});
		panel.add(button_5);
		
		JButton btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setBounds(796, 77, 117, 29);
		btnOrdenar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(ordenacaoForm,"Ordenar - SelectionSort!");
                        ordenacaoControle.ordenarPorSelectionSort(fiscalizacaoList);
                        JOptionPane.showMessageDialog(ordenacaoForm,"Ordenar - InsertionSort!");
                        ordenacaoControle.ordenarPorInsertionSort(fiscalizacaoList);
                    }
		});
		panel.add(btnOrdenar);
		
		fiscalizacaoTable = new FiscalizacaoJTable(new FiscalizacaoTableModel(fiscalizacaoList));
		fiscalizacaoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fiscalizacaoTable.setBorder(new LineBorder(Color.black));
		fiscalizacaoTable.setGridColor(Color.black);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(6, 201, 924, 435);
		scrollPane.setViewportView(fiscalizacaoTable);
		panel.add(scrollPane);
		
		JButton limparButton = new JButton("Limpar");
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparLista();
			}
		});
		limparButton.setBounds(681, 77, 117, 29);
		panel.add(limparButton);
		
		JPanel selectionSortPanel = new JPanel();
		tabbedPane.addTab("SelectionSort", null, selectionSortPanel, null);
		selectionSortPanel.setLayout(null);
		
		SortTable = new FiscalizacaoJTable(new FiscalizacaoTableModel(Collections.emptyList()));
		SortTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		SortTable.setBorder(new LineBorder(Color.black));
		SortTable.setGridColor(Color.black);

		JScrollPane selectionSortScrollPane = new JScrollPane();
		selectionSortScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		selectionSortScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		selectionSortScrollPane.setBounds(6, 63, 924, 468);
		scrollPane.setViewportView(SortTable);
		selectionSortPanel.add(selectionSortScrollPane);
				
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_5, null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);{
				JButton fecharButton = new JButton("Fechar");
				fecharButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ordenacaoControle.closeForm();
					}
				});
				fecharButton.setActionCommand("Cancel");
				buttonPane.add(fecharButton);
			}
		}
	} 

	private void limparLista() {
		arquivoField.setText("");
		FiscalizacaoTableModel fiscalizacaoTableModel = new FiscalizacaoTableModel(Collections.emptyList());
		fiscalizacaoTable.setModel(fiscalizacaoTableModel); 
	}

	public void mostraListaDeFiscalizacao(List<Fiscalizacao> fiscalizacaoList) {
		this.fiscalizacaoList = fiscalizacaoList;
		FiscalizacaoTableModel fiscalizacaoTableModel = new FiscalizacaoTableModel(fiscalizacaoList);
		fiscalizacaoTable.setModel(fiscalizacaoTableModel);
                JOptionPane.showMessageDialog(ordenacaoForm,"Lista exibida");
	}

	public void ordenacaoRealizadaPorSelectionSort(List<Fiscalizacao> listaOrdenada) {
		SortTable.setModel(new FiscalizacaoTableModel(listaOrdenada));
	}
        
        public void ordenacaoRealizadaPorInsertionSort(List<Fiscalizacao> listaOrdenada) {
		SortTable.setModel(new FiscalizacaoTableModel(listaOrdenada));
	}
        
        public void ordenacaoRealizadaPorBubbleSort(List<Fiscalizacao> listaOrdenada) {
		SortTable.setModel(new FiscalizacaoTableModel(listaOrdenada));
	}
}
