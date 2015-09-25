package model;

public class FiscalizacaoBuilder {
    private static final int ANO = 0;
    private static final int MES = 1;
    private static final int CNPJ = 2;
    private static final int EMPREGADOR = 3;
    private static final int LOGRADOURO = 4;
    private static final int CEP = 5;
    private static final int BAIRRO = 6;
    private static final int MUNICIPIO = 7;
    private static final int UF = 8;

    public Fiscalizacao constroiPorDelimitador(String linhaComDelimitador) {
        String campo[] = linhaComDelimitador.split(";");
        Fiscalizacao fiscalizacao = new Fiscalizacao();

        fiscalizacao.setAno(Integer.parseInt(campo[ANO]));
        fiscalizacao.setMes(Integer.parseInt(campo[MES].substring(6)));
        fiscalizacao.setCnpj(campo[CNPJ]);
        fiscalizacao.setEmpregador(campo[EMPREGADOR]);
        fiscalizacao.setLogradouro(campo[LOGRADOURO]);
        fiscalizacao.setCep(campo[CEP]);
        fiscalizacao.setBairro(campo[BAIRRO]);
        fiscalizacao.setMunicipio(campo[MUNICIPIO]);
        fiscalizacao.setUf(campo[UF]);
        return fiscalizacao;
    }
}
