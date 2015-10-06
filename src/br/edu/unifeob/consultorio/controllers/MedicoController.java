package br.edu.unifeob.consultorio.controllers;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.unifeob.consultorio.daos.MedicoDAO;
import br.edu.unifeob.consultorio.entities.Medico;

@Controller
public class MedicoController {

	private Result result;
	private MedicoDAO medicoDAO;
	
	public MedicoController() {		
	}

	@Inject
	public MedicoController(Result result, MedicoDAO medicoDAO) {
		this.result = result;
		this.medicoDAO = medicoDAO;
	}
	
	public void form(){
	}
	
	public void salvar(Medico medico){
		medicoDAO.salvar(medico);
		result.redirectTo(this.getClass()).listar();
	}
	
	public void listar(){
		List<Medico> medicos = medicoDAO.listar();
		result.include("medicos", medicos);
	}
	
	
}
