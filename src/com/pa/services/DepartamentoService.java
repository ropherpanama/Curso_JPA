package com.pa.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.jpa.entities.Departamento;

/**
 * Esta clase contiene todos los metodos CRUD para la tabla
 * Departamento
 * @author rospena
 *
 */
public class DepartamentoService {
	protected EntityManager em;

	public DepartamentoService(EntityManager em) {
		this.em = em;
	}

	public Departamento create(String desc) {
		Departamento dpto = new Departamento();
		dpto.setDescripcion(desc);
		return dpto;
	}

	public void remove(int id) {
		Departamento emp = find(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public Departamento find(int id) {
		return em.find(Departamento.class, id);
	}

	public List<Departamento> findAll() {
		TypedQuery<Departamento> query = em.createQuery("from Departamento as d", Departamento.class);
		return query.getResultList();
	}
	
	public void merge(Departamento d) {
		em.merge(d);
	}
}
