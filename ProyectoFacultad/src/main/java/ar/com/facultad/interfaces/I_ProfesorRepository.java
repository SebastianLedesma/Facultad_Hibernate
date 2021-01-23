package ar.com.facultad.interfaces;

import java.util.List;

import ar.com.facultad.entity.Alumno;
import ar.com.facultad.entity.Profesor;

//Interface que contiene las acciones principales que se pueden realizar con los objetos de tipo Profesor.
public interface I_ProfesorRepository {

	/**
	 * M�todo que retorna todos los profesores registrados.
	 * @return Lista de profesores encontrados.
	 */
	List<Profesor> getAll();
	
	/**
	 * M�todo que inserta un profesor en la fuente de datos.
	 * @param profesor Profesor a insertar.
	 */
	void save(Profesor profesor);
	
	/**
	 * M�todo que actualiza los datos de un profesor en la fuente de datos.
	 * @param profesor Profesor con sus datos actualizados.
	 */
	void update(Profesor profesor);
	
	
	/**
	 * M�todo que elimina un registro de la fuente de datos.
	 * @param profesor Profesor a eliminar.
	 */
	void delete(Profesor profesor);
	
	/**
	 * M�todo que retorna un profesor de la fuente de datos seg�n el id buscado.
	 * @param id Valor que identifica al profesor en la fuente de datos.
	 * @return Profesor con el id buscado o null si no se encontr�.
	 */
	Profesor getLikeId(Integer id);
	
	/**
	 * M�todo que retorna la lista de alumnos que posee el profesor.
	 * @param idProfesor Valor que identifica al profesor en la fuente de datos.
	 * @return Lista de alumnos que tiene el profesor.
	 */
	List<Alumno> getAlumnosLikeId(Integer idProfesor);
	
}
