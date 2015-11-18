package model;

import javax.swing.JFileChooser;

// @author Anpix

public class FileChooser {

    JFileChooser fileChooser;
    String endereco = null;

    public FileChooser() {
        this.fileChooser = new JFileChooser();
    }

    public void open() {
        int retorno = fileChooser.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            endereco = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }

    public void save() {
        int retorno = fileChooser.showSaveDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            endereco = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }

    public String getEndereco() {
        return endereco;
    }
}
