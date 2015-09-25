package model;

import java.io.IOException;
import java.util.List;

// @author Anpix

public class FileChooser {
    
    public FileChooser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Fiscalizacao> load(String arquivo) {
        FiscalizacaoBuilder fiscalizacaoBuilder = new FiscalizacaoBuilder();
        ReadWriteObjects readWriteObjects = new ReadWriteObjects();
        List<Fiscalizacao> fiscalizacaoList = null;
        try {
                fiscalizacaoList = readWriteObjects.read(arquivo, fiscalizacaoBuilder);

        } catch (IOException e) {
                e.printStackTrace();
        }
        return fiscalizacaoList;
    }
}
