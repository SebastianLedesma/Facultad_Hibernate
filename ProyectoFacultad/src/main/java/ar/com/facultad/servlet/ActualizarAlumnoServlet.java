package ar.com.facultad.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.facultad.entity.Alumno;
import ar.com.facultad.repository.AlumnoRepository;
import ar.com.facultad.repository.ProfesorRepository;

/**
 * Servlet implementation class ActualizarAlumnoServlet
 */
public class ActualizarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarAlumnoServlet() {
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
		
		request.setAttribute("listaProfesores", pr.getAll());
		request.getRequestDispatcher("ActualizarAlumno.jsp").forward(request, response);
	}

}
