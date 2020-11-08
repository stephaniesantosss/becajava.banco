package br.bancoeveris.app.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "hash", name = "hash_uk"))//Constraint para que o HASH seja unico
public class Conta extends BaseResponse{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private double saldo;
	private String NumConta;
	private String Agencia;
	private String hash;
	
	@ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente Cliente;
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	public Cliente getCliente() {
		return Cliente;
	}
	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
