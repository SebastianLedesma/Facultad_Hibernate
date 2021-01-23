package ar.com.facultad.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.pool2.impl.PooledSoftReference;

import ar.com.facultad.entity.Alumno;
import ar.com.facultad.entity.Profesor;
import ar.com.facultad.repository.AlumnoRepository;
import ar.com.facultad.repository.ProfesorRepository;

/**
 * Servlet implementation class ActualizarDatosAlumnoServlet
 */
public class ActualizarDatosAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarDatosAlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfesorRepository pr = new ProfesorRepository();
		
		
		int idProfesor = Integer.valueOf(request.getParameter("profesorId"));
		int idAlumno = Integer.valueOf(request.getParameter("idAlumno"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		
		AlumnoRepository ar = new AlumnoRepository();
		Alumno alumno = ar.getLikeId(idAlumno);
		
		if(alumno != null){
			alumno.getNombreCompleto().setNombre(nombre);
			alumno.getNombreCompleto().setApellido(apellido);
			alumno.setDireccion(direccion);
			alumno.setTelefono(telefono);
			
			Profesor prof = pr.getLikeId(idProfesor);
			alumno.setProfesor(prof);
			ar.update(alumno);
			request.setAttribute("resultado", true);
		}else{
			request.setAttribute("resultado", false);
		}
		
		request.getRequestDispatcher("Resultado.jsp").forward(request, response);
	}

}
