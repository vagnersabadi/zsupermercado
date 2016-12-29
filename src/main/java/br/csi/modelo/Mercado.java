package br.csi.modelo;

public class Mercado {
	private int codigo;
	private int codigoCarrinho;
    private String endereco;
	private float total;
	private int codigoAdm;
	private String supermercado;
	
	public String getSupermercado() {
		return supermercado;
	}
	public void setSupermercado(String supermercado) {
		this.supermercado = supermercado;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getCodigoCarrinho() {
		return codigoCarrinho;
	}
	public void setCodigoCarrinho(int codigoCarrinho) {
		this.codigoCarrinho = codigoCarrinho;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoAdm() {
		return codigoAdm;
	}
	public void setCodigoAdm(int codigoAdm) {
		this.codigoAdm = codigoAdm;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	

	

}
