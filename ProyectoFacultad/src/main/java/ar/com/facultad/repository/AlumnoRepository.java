package ar.com.facultad.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ar.com.facultad.entity.Alumno;
import ar.com.facultad.interfaces.I_AlumnoRepository;

public class AlumnoRepository implements I_AlumnoRepository {

	@Override
	public List<Alumno> getAll() {
		
		List<Alumno> lista = new ArrayList<Alumno>();
		
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				session.beginTransaction();
				
				lista = session.createQuery("from Alumno").getResultList();
				
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
	public Alumno getLikeId(Integer id) {
		
		Alumno alumno = null;
		
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				
				session.beginTransaction();
				alumno = session.get(Alumno.class, id);
				
				session.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return alumno;
	}

	@Override
	public void save(Alumno alumno) {
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				session.beginTransaction();
				
				session.save(alumno);
				
				session.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	@Override
	public void update(Alumno alumno) {
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				session.beginTransaction();
				
				session.saveOrUpdate(alumno);
				
				session.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}		
	}

	@Override
	public void delete(Alumno alumno) {
		try(SessionFactory sf = new Configuration().configure().buildSessionFactory()){
			try(Session session = sf.openSession()){
				session.beginTransaction();
				
				session.delete(alumno);
				
				session.getTransaction().commit();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
