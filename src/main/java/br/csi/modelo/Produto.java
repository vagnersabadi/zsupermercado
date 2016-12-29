package br.csi.modelo;

public class Produto {
	
	private int codigo;
	private int codigo_Adm;
	private float preco;
	private String descricao;
	private String promocao;
	
	public int getCodigo_Adm() {
		return codigo_Adm;
	}
	public void setCodigo_Adm(int codigo_Adm) {
		this.codigo_Adm = codigo_Adm;
	}
	public String getPromocao() {
		return promocao;
	}
	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
