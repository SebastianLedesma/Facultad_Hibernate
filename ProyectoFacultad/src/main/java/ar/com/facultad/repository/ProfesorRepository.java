package ar.com.facultad.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ar.com.facultad.entity.Alumno;
import ar.com.facultad.entity.Profesor;
import ar.com.facultad.interfaces.I_ProfesorRepository;

public class ProfesorRepository implements I_ProfesorRepository {

	@Override
	public List<Profesor> getAll() {
		
		List<Profesor> lista = new ArrayList<Profesor>();
		
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				session.beginTransaction();
				lista = session.createQuery("from Profesor").getResultList();
				
				session.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	

	@Override
	public void save(Profesor profesor) {
		
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				session.beginTransaction();
				session.save(profesor);
				
				session.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void update(Profesor profesor) {
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				session.beginTransaction();
				session.update(profesor);
				session.getTransaction().commit();
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void delete(Profesor profesor) {
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				session.beginTransaction();
				session.delete(profesor);
				
				session.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public Profesor getLikeId(Integer id) {
		Profesor profesor = null;
		
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				
				profesor = session.get(Profesor.class, id);
				
				session.beginTransaction();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return profesor;
	}

	@Override
	public List<Alumno> getAlumnosLikeId(Integer idProfesor) {
		
		Profesor profesor = getLikeId(idProfesor);
		
		return profesor.getListaAlumnos();
	}

}
