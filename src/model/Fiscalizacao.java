package model;

public class Fiscalizacao {
	
	private int ano;
	private int mes;
	private String cnpj;
	private String empregador;
	private String logradouro;
	private String cep;
	private String bairro;
	private String municipio;
	private String uf;

	public int getAno() {
		return ano;
	}
	public int getMes() {
		return mes;
	}
	public String getCnpj() {
		return cnpj;
	}
	public String getEmpregador() {
		return empregador;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public String getCep() {
		return cep;
	}
	public String getBairro() {
		return bairro;
	}
	public String getMunicipio() {
		return municipio;
	}
	public String getUf() {
		return uf;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setEmpregador(String empregador) {
		this.empregador = empregador;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
        
	public String toString(){
            return this.empregador;
        }	
}
