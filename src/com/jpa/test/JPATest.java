package com.jpa.test;

import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.jpa.entities.Departamento;
import com.jpa.entities.Empleado;
import com.pa.services.DepartamentoService;
import com.pa.services.EmpleadoService;

public class JPATest {
	public static void main(String[] args) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaPersitenceUnit");
			EntityManager manager = factory.createEntityManager();
			long start = 0;
			long end = 0;
			EmpleadoService emps = new EmpleadoService(manager);
			DepartamentoService dpts = new DepartamentoService(manager);

			start = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

			for (Empleado e : emps.findAll()) {
				System.out.println(e + "\n---------------------------------------------------------");
			}

			System.out.println("Realizando cambio de nombre de area con MERGE\n");
			manager.getTransaction().begin();
			Departamento d = new Departamento();
			d.setId(4);
			d.setDescripcion("Mercadeo Internacional");
			dpts.merge(d);
			manager.getTransaction().commit();
			System.out.println("MERGE realizado\n");

			for (Empleado e : emps.findAll()) {
				System.out.println(e + "\n---------------------------------------------------------");
			}

			end = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

			System.out.println("Tiempo total: " + (end - start) + " segs");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error : " + e.getLocalizedMessage());
		}
	}
}
