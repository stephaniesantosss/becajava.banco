package br.bancoeveris.app.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.bancoeveris.app.model.BaseResponse;
import br.bancoeveris.app.model.Conta;
import br.bancoeveris.app.model.Operacao;

import br.bancoeveris.app.repository.OperacaoRepository;

import br.bancoeveris.app.spec.OperacaoList;
import br.bancoeveris.app.spec.OperacaoSpec;

@Service
public class OperacaoService {

	final OperacaoRepository _repository;

	public OperacaoService(OperacaoRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(OperacaoSpec operacaoSpec) {
		Operacao operacao = new Operacao();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (operacaoSpec.getTipo() == "") {
			base.Message = "O Tipo da operação não foi preenchido.";
			return base;
		}

		if (operacaoSpec.getValor() == 0) {
			base.Message = "O valor da operação não foi preenchido.";
			return base;
		}

		operacao.setTipo(operacaoSpec.getTipo());
		operacao.setValor(operacaoSpec.getValor());

		_repository.save(operacao);
		base.StatusCode = 201;
		base.Message = "Operacão inserida com sucesso.";
		return base;
	}
	
       public double Saldo(Long contaId) {
		
		double saldo = 0;
		
		Conta contaOrigem = new Conta();
		contaOrigem.setId(contaId);
		
		Conta contaDestino = new Conta();
		contaDestino.setId(contaId);
		
		List<Operacao> listaOrigem = _repository.findByContaOrigem(contaOrigem);
		List<Operacao> listaDestino = _repository.findByContaDestino(contaDestino);
		
		for(Operacao o : listaOrigem) {			
			switch(o.getTipo()) {				
				case "D":
					saldo += o.getValor();
					break;
				case "S":
					saldo -= o.getValor();
					break;					
				case "T":
					saldo -= o.getValor();
					break;					
				default:					
					break;				
			}
			
		}
		
		for(Operacao o : listaDestino) {			
			switch(o.getTipo()) {				
				case "D":
					saldo += o.getValor();
					break;
				case "S":
					saldo -= o.getValor();
					break;					
				case "T":
					saldo += o.getValor();
					break;					
				default:					
					break;				
			}	
		}		
		
		return saldo;
	}

//	public Conta obter(Long id) {		
//		Optional<Conta> conta = _repository.findById(id);
//		Conta response = new Conta();
//		
//		
//		if (conta == null) {
//			response.Message = "Conta não encontrada";
//			response.StatusCode = 404;
//			return response;
//		}						
//		
//		response.Message = "Conta obtida com sucesso";
//		response.StatusCode = 200;		
//		return response;
//	}	

	public OperacaoList listar() {

		List<Operacao> lista = _repository.findAll();

		OperacaoList response = new OperacaoList();
		response.setOperacoes(lista);
		response.StatusCode = 200;
		response.Message = "Operacoes obtidas com sucesso.";

		return response;
	}

	public BaseResponse atualizar(Long id, OperacaoSpec operacaoSpec) {
		Operacao operacao = new Operacao();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (operacaoSpec.getTipo() == "") {
			base.Message = "O tipo da Operação não foi preenchido.";
			return base;
		}

		if (operacaoSpec.getValor() == 0) {
			base.Message = "O Valor da operação não foi preenchido.";
			return base;
		}

		operacao.setId(id);
		operacao.setTipo(operacaoSpec.getTipo());
		operacao.setValor(operacaoSpec.getValor());

		_repository.save(operacao);
		base.StatusCode = 200;
		base.Message = "Operacao atualizada com sucesso.";
		return base;
	}

	public BaseResponse deletar(Long id) {
		BaseResponse response = new BaseResponse();

		if (id == null || id == 0) {
			response.StatusCode = 400;
			return response;
		}

		_repository.deleteById(id);
		response.StatusCode = 200;
		return response;
	}

}
