package com.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Empleado {
	@Id 
	@GeneratedValue
	private int id;
	private String nombre;
	private String apellido;
	private double salario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departamento", nullable = false)
	private Departamento departamento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Nombre  : " + this.nombre + ", " + this.apellido + "\n" +
	           "Depto   : " + getDepartamento().getDescripcion() + "\n" + 
			   "Salario : " + this.salario;
	}
}
