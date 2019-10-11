package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Ocorrencia extends Model {

	public String descricao;


	@Override
	public String toString() {
		return descricao;
	}
	
}



