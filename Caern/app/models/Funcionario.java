package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import play.db.jpa.Model;

@Entity
public class Funcionario extends Model {
	
	public String nome;
	
	public Integer matricula;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	
	@ManyToMany
	public List<Funcao> funcoes;
	
	
	public Funcionario() {
		status = Status.ATIVO;
		funcoes = new ArrayList<Funcao>();
	}
	

}
