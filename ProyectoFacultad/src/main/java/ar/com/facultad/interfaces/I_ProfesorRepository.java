package ar.com.facultad.interfaces;

import java.util.List;

import ar.com.facultad.entity.Alumno;
import ar.com.facultad.entity.Profesor;

//Interface que contiene las acciones principales que se pueden realizar con los objetos de tipo Profesor.
public interface I_ProfesorRepository {

	/**
	 * Método que retorna todos los profesores registrados.
	 * @return Lista de profesores encontrados.
	 */
	List<Profesor> getAll();
	
	/**
	 * Método que inserta un profesor en la fuente de datos.
	 * @param profesor Profesor a insertar.
	 */
	void save(Profesor profesor);
	
	/**
	 * Método que actualiza los datos de un profesor en la fuente de datos.
	 * @param profesor Profesor con sus datos actualizados.
	 */
	void update(Profesor profesor);
	
	
	/**
	 * Método que elimina un registro de la fuente de datos.
	 * @param profesor Profesor a eliminar.
	 */
	void delete(Profesor profesor);
	
	/**
	 * Método que retorna un profesor de la fuente de datos según el id buscado.
	 * @param id Valor que identifica al profesor en la fuente de datos.
	 * @return Profesor con el id buscado o null si no se encontró.
	 */
	Profesor getLikeId(Integer id);
	
	/**
	 * Método que retorna la lista de alumnos que posee el profesor.
	 * @param idProfesor Valor que identifica al profesor en la fuente de datos.
	 * @return Lista de alumnos que tiene el profesor.
	 */
	List<Alumno> getAlumnosLikeId(Integer idProfesor);
	
}
