package br.edu.unifeob.consultorio.daos;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.unifeob.consultorio.entities.Medico;

@Dependent
public class MedicoDAO {

	private EntityManager entityManager;

	public MedicoDAO() {
	}

	@Inject
	public MedicoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvar(Medico medico) {
		entityManager.persist(medico);
	}

	public List<Medico> listar() {
		return entityManager.createQuery("from Medico", Medico.class).getResultList();
	}

}
