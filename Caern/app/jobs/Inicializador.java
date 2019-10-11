package jobs;



import models.Ocorrencia;
import models.Cliente;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if (Cliente.count() == 0) {
			Cliente c1 = new Cliente();
			c1.login = "@admin";
			c1.senha = "1234";
			c1.save();
		}
			
	if(Ocorrencia.count() == 0) {
			Ocorrencia o1 = new Ocorrencia();
			o1.descricao = "Cano Furado";
			o1.save();
		
			Ocorrencia o2 = new Ocorrencia();
			o2.descricao = "Ligar Registro";
			o2.save();
			
			Ocorrencia o3 = new Ocorrencia();
			o3.descricao = "Denuncia de Gato";
			o3.save();
			
			Ocorrencia o4 = new Ocorrencia();
			o4.descricao = "Desligar Registro";
			o4.save();
	}
	
	
}

}