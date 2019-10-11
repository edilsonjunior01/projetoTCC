package controllers;

import models.Cliente;
import play.mvc.Controller;

public class Logins extends Controller {

	public static void form() {
		render();
	}
	
	public static void logar(String login, String senha) {
		Cliente cliente = Cliente.find("login = ?1 and senha = ?2", login, senha).first();
		if (cliente == null) {
			form();
		} else {
			session.put("usuarioLogado", login);
			Clientes.listar();
		}
	}
	
	public static void logout() {
		session.clear();
		form();
	}
}
