package controllers;

import java.util.List;

import models.Cliente;

import models.Ocorrencia;

import models.Status;
import play.mvc.Controller;

public class Ocorrencias extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void listar() {
		List<Ocorrencia> minhasOcorrencias = Ocorrencia.findAll();		
		render(minhasOcorrencias);
	}
	
	public static void salvar(Ocorrencia o) {
		o.save();
		listar();
	}

	public static void remover(Long id) {
		Ocorrencia ocorrencia = Ocorrencia.findById(id);
		
		listar();
	}
}
