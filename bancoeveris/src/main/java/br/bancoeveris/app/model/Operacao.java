package br.bancoeveris.app.model;

import javax.persistence.*;

@Entity
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Tipo;
    private double Valor;
    
    @ManyToOne
    @JoinColumn(name = "contaOrigemId")
    private Conta contaOrigem;
    
    @ManyToOne
    @JoinColumn(name = "contaDestinoId")
    private Conta contaDestino;

    
	public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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