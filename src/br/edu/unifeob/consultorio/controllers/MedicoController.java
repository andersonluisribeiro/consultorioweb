package br.edu.unifeob.consultorio.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.unifeob.consultorio.entities.Medico;

@Controller
public class MedicoController {

	private Result result;
	private EntityManager entityManager;
	
	public MedicoController() {		
	}

	@Inject
	public MedicoController(Result result, EntityManager entityManager) {
		this.result = result;
		this.entityManager = entityManager;
	}
	
	public void form(){
		
	}
	
	public void salvar(Medico medico){
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(medico);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		result.redirectTo(this.getClass()).listar();
		
	}
	
	public void listar(){
		List<Medico> medicos = entityManager.createQuery("from Medico").getResultList();
		result.include("medicos", medicos);
	}
	
	
}
