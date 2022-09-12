package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorInstitucionDep {
	private static ManejadorInstitucionDep instancia = null;
	
	//private ArrayList<InstitucionDeportiva> instDeportivas = new ArrayList<>();
	
	private ManejadorInstitucionDep() {}
	
	public static ManejadorInstitucionDep getInstancia() {
		if (instancia == null) {
			instancia = new ManejadorInstitucionDep();
		}
		return instancia;
	}

	/*public boolean existeInstitucion(String nombre) {
		Boolean existe = false; 
		for (InstitucionDeportiva instDep : instDeportivas) {
			if (instDep.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}*/
	public boolean existeInstitucion(String nombre) {
		Boolean existe=false;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		ArrayList<InstitucionDeportiva> instituciones = listarInstituciones();
		
		for (InstitucionDeportiva instDep : instituciones) {
			if (instDep.getNombre().equals(nombre))
				existe=true;
		}
		return existe;
	}
	
	/*public InstitucionDeportiva buscarInstitucion(String nombre) {
		InstitucionDeportiva institucion=null;
		for(InstitucionDeportiva i: instDeportivas) {
			if (i.getNombre().equals(nombre))
				institucion = i;
		}
		return institucion;
	}*/
	public InstitucionDeportiva buscarInstitucion(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		InstitucionDeportiva idep = em.find(InstitucionDeportiva.class, nombre);
		
		return idep;
	}
	/*public void add(InstitucionDeportiva instDep) {
		instDeportivas.add(instDep);		
	}*/
	public void add(InstitucionDeportiva instDep) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(instDep);
		
		em.getTransaction().commit();
	}
	
	/*public ArrayList<InstitucionDeportiva> listarInstituciones(){
		return instDeportivas;
	}*/
	public ArrayList<InstitucionDeportiva> listarInstituciones(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select i from InstitucionDeportiva i");
		
		List<InstitucionDeportiva> instDeportivas = (List<InstitucionDeportiva>) query.getResultList();
		
		ArrayList<InstitucionDeportiva> retorno = new ArrayList<>();
		
		for(InstitucionDeportiva i: instDeportivas)
			retorno.add(i);
		
		return retorno;
	}
	
	
}
