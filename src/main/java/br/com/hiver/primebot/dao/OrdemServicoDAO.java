package br.com.hiver.primebot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.hiver.primebot.model.OrdemServico;

@Component
public class OrdemServicoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<OrdemServico> listar(){
		return manager.createQuery("SELECT P FROM OrdemServico P", OrdemServico.class).getResultList();
	}
	@Transactional
	public OrdemServico incluir(OrdemServico entity) {
			manager.persist(entity);
			return entity;
	}
	@Transactional
	public OrdemServico alterar(OrdemServico entity) {
			return manager.merge(entity);
		
	}
	@Transactional
	public void  excluir(OrdemServico entity) {
			 manager.remove(entity);
	}
	
}
