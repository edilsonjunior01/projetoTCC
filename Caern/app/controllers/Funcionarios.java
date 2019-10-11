package controllers;

import java.util.List;

import models.Funcionario;
import models.Funcao;
import models.Status;
import play.mvc.Controller;

public class Funcionarios extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void funcoes(Long id) {
		Funcionario funcionario = Funcionario.findById(id);
		List<Funcao> funcoes = Funcao.findAll();
		
		funcoes.removeAll(funcionario.funcoes);
		render(funcionario, funcoes);
	}
	
	public static void associarFuncao(Long id, Long idFuncao) {
		if (idFuncao != null) {
			Funcionario funcionario = Funcionario.findById(id);
			Funcao funcao = Funcao.findById(idFuncao);
			funcionario.funcoes.add(funcao);
			funcionario.save();
		}
		funcoes(id);
	}
	
	public static void removerFuncao(Long id, Long idFuncao) {
		Funcionario funcionario = Funcionario.findById(id);
		Funcao funcao = Funcao.findById(idFuncao);
		funcionario.funcoes.remove(funcao);
		funcionario.save();
		funcoes(id);
	}
	
	public static void listar() {
		List<Funcionario> meusFuncionarios = 
				Funcionario.find("status != 'INATIVO'").fetch();
		render(meusFuncionarios);
	}
	
	public static void salvar(Funcionario f) {
		f.save();
		listar();
	}

	public static void remover(Long id) {
		Funcionario funcionario = Funcionario.findById(id);
		funcionario.status = Status.INATIVO;
		funcionario.save();
		listar();
	}
}
