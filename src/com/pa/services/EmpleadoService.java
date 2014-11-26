package com.pa.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.jpa.entities.Departamento;
import com.jpa.entities.Empleado;

/**
 * Esta clase contiene los metodos CRUD para la tabla
 * Empleados
 * @author rospena
 */
public class EmpleadoService {
	protected EntityManager em;

	public EmpleadoService(EntityManager em) {
		this.em = em;
	}

	public Empleado create(String nombre, String apellido, double salario, Departamento departamento) {
		Empleado emp = new Empleado();
		emp.setNombre(nombre);
		emp.setApellido(apellido);
		emp.setDepartamento(departamento);
		emp.setSalario(salario);
		return emp;
	}

	public void remove(int id) {
		Empleado emp = find(id);
		if (emp != null) {
			em.remove(emp);
		}
	}

	public Empleado aumentarSalario(int id, double raise) {
		Empleado emp = em.find(Empleado.class, id);
		if (emp != null) {
			emp.setSalario(emp.getSalario() + raise);
		}
		return emp;
	}

	public Empleado find(int id) {
		return em.find(Empleado.class, id);
	}

	public List<Empleado> findAll() {
		TypedQuery<Empleado> query = em.createQuery("from Empleado as e", Empleado.class);
		return query.getResultList();
	}
}
