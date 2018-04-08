package br.org.iel.recrutaif.testes;

import br.org.iel.recrutaif.dao.SetorDao;
import br.org.iel.recrutaif.model.entity.Setor;

public class TestaInsereSetor {
	
	public static void main(String[] args) {
		//adicionando um novo setor no banco de dados
		
		Setor setor = new Setor();
		setor.setNome("TI");
		
		SetorDao dao = new SetorDao();
		
		dao.salva(setor);
	}
}