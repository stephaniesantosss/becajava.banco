package br.bancoeveris.app.spec;

public class OperacaoSpec {
	
	private String Tipo;
	private double Valor;
	private Long IdOrigem;
	public Long getIdOrigem() {
		return IdOrigem;
	}
	public void setIdOrigem(Long idOrigem) {
		IdOrigem = idOrigem;
	}
	public Long getIdDestino() {
		return IdDestino;
	}
	public void setIdDestino(Long idDestino) {
		IdDestino = idDestino;
	}
	private Long IdDestino;
	
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public double getValor() {
		return Valor;
	}
	public void setValor(double valor) {
		Valor = valor;
	}
	
	

}
