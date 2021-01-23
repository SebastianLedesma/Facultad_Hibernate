package ar.com.facultad.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NombreCompleto {

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	
	public NombreCompleto() {
		super();
	}
	
	public NombreCompleto(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
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
	
}
