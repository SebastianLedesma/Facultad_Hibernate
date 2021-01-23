package ar.com.facultad.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.facultad.entity.Alumno;
import ar.com.facultad.entity.NombreCompleto;
import ar.com.facultad.entity.Profesor;
import ar.com.facultad.repository.AlumnoRepository;
import ar.com.facultad.repository.ProfesorRepository;

/**
 * Servlet implementation class AltaAlumnoServlet
 */
public class AltaAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaAlumnoServlet() {
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
		int id = Integer.valueOf(request.getParameter("profesorId"));
		ProfesorRepository pr = new ProfesorRepository();
		AlumnoRepository ar ;
		
		Profesor prof = pr.getLikeId(id);
		
		if(prof != null){
			String nombre = request.getParameter("nombre");
			String apellido= request.getParameter("apellido");
			String direccion = request.getParameter("direccion");
			String telefono = request.getParameter("telefono");
			Alumno alumno = new Alumno(new NombreCompleto(nombre,apellido),direccion,telefono,prof);
			
			ar = new AlumnoRepository();
			ar.save(alumno);
			
			request.setAttribute("resultado", true);
		}else{
			request.setAttribute("resultado", false);
		}
		
		request.getRequestDispatcher("Resultado.jsp").forward(request, response);
	}

}
