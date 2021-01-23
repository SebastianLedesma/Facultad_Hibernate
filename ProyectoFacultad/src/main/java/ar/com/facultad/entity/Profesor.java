package ar.com.facultad.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ar.com.facultad.enumerator.ECurso;

@Entity
@Table(name="profesor")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Embedded
	private NombreCompleto nombreCompleto;
	
	@Column(name="nombre_curso")
	@Enumerated(EnumType.STRING)
	private ECurso curso;
	
	@OneToMany(mappedBy="profesor", cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	private List<Alumno> listaAlumnos;
	
	private Profesor(){
		super();
	}
	
	public Profesor(NombreCompleto nombreCompleto, ECurso curso) {
		this();
		this.nombreCompleto = nombreCompleto;
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NombreCompleto getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(NombreCompleto nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public ECurso getCurso() {
		return curso;
	}

	public void setCurso(ECurso curso) {
		this.curso = curso;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	
	
	public void agregarAlumno(Alumno alumno){
		if(this.listaAlumnos == null){
			this.listaAlumnos = new ArrayList<Alumno>();
		}
		
		this.listaAlumnos.add(alumno);
		alumno.setProfesor(this);
	}
	
	public void quitarAlumno(Alumno alumno){
		if(alumno != null){
			this.listaAlumnos.remove(alumno);
			alumno.setProfesor(null);
		}
	}
	
}
