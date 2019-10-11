package models;

import java.text.DateFormat;
import java.text.ParseException;
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
public class Cliente extends Model {
	
	public String nome;
	public String email;
	public String endereco;
	public String login;
	public String senha;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	@ManyToMany
	public List <Ocorrencia> ocorrencias;

	public Cliente() throws ParseException {
		status = Status.ATIVO;
	
	}
}


