package br.bancoeveris.app.spec;

public class ContaSpec {

	private String Hash;
	private String NumConta;
	private String Agencia;
	private ClienteSpec Cliente;
	
	public ClienteSpec getCliente() {
		return Cliente;
	}
	public void setCliente(ClienteSpec cliente) {
		Cliente = cliente;
	}
	public String getHash() {
		return Hash;
	}
	public void setHash(String hash) {
		Hash = hash;
	}
	public String getNumConta() {
		return NumConta;
	}
	public void setNumConta(String numConta) {
		NumConta = numConta;
	}
	public String getAgencia() {
		return Agencia;
	}
	public void setAgencia(String agencia) {
		Agencia = agencia;
	}
}
