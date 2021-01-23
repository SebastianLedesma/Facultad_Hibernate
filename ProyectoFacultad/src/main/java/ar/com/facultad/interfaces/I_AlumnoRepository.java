package ar.com.facultad.interfaces;

import java.util.List;

import ar.com.facultad.entity.Alumno;
import ar.com.facultad.entity.Profesor;

//Interface que contiene las acciones principales que se pueden hacer con los objetos de tipo Alumno.
public interface I_AlumnoRepository {

	/**
	 * M�todo que retorna todos los alumnos registrados.
	 * @return Lista con alumnos.
	 */
	List<Alumno> getAll();
	
	/**
	 * M�todo que busca y retorna un alumno seg�n el id.
	 * @param id Valor del id del alumno en la BD.
	 * @return Alumno que coincide con el id  o null.
	 */
	Alumno getLikeId(Integer id);
	
	/**
	 * M�todo que inserta un alumno en la fuente de datos.
	 * @param alumno Alumno a insertar.
	 */
	void save(Alumno alumno);
	
	/**
	 * M�todo que actualiza un alumno en la fuente de datos.
	 * @param alumno Alumno a actualizar con sus atributos cambiados.
	 */
	void update(Alumno alumno);
	
	
	/**
	 * M�todo que elimina un alumno de la fuente de datos.
	 * @param alumno Alumno a eliminar de la fuente de datos.
	 */
	void delete(Alumno alumno);
}
