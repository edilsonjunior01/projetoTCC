package controllers;

import java.util.List;

import models.Cliente;

import models.Ocorrencia;

import models.Status;
import play.mvc.Controller;

public class Clientes extends Controller {
	
	public static void form() {
		render();	
	}
	
	public static void ocorrencias(long id) {
		List<Ocorrencia> ocorrencias = Ocorrencia.findAll();
		render(ocorrencias);
	}
	
	public static void registrarOcorrencia(Long idCliente) {
		Cliente cliente = Cliente.findById(idCliente);
		List <Ocorrencia> ocorrencias = Ocorrencia.findAll();
		render(cliente, ocorrencias);
	}
	
	public static void salvarOcorrencia(Long idCliente, Long idOcorrencia){
		Cliente cliente = Cliente.findById(idCliente);
		Ocorrencia ocorrencia = Ocorrencia.findById(idOcorrencia);
		cliente.ocorrencias.add(ocorrencia);
		cliente.save();
		listar();
	}
	
	
	public static void listar() {
		List<Cliente> meusClientes = 
				Cliente.find("status != 'INATIVO'").fetch();
		render(meusClientes);
	}
	
	public static void salvar(Cliente c) {
		c.save();
		listar();
	}

	public static void remover(Long id) {
		Cliente cliente = Cliente.findById(id);
		cliente.status = Status.INATIVO;
		cliente.save();
		listar();
	}
}
