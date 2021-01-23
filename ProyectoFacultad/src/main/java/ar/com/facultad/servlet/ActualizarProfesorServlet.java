package ar.com.facultad.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.facultad.entity.Profesor;
import ar.com.facultad.enumerator.ECurso;
import ar.com.facultad.repository.ProfesorRepository;

/**
 * Servlet implementation class ActualizarProfesorServlet
 */
public class ActualizarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarProfesorServlet() {
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
		int id = Integer.valueOf(request.getParameter("idProfesor"));
		ProfesorRepository pr = new ProfesorRepository();
		Profesor profesor = pr.getLikeId(id);
		
		if(profesor != null){
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			ECurso curso = ECurso.valueOf(request.getParameter("materia"));
			
			profesor.getNombreCompleto().setNombre(nombre);
			profesor.getNombreCompleto().setApellido(apellido);
			profesor.setCurso(curso);
			
			pr.update(profesor);
			request.setAttribute("resultado", true);
		}else{
			request.setAttribute("resultado", false);
		}
		
		request.getRequestDispatcher("Resultado.jsp").forward(request, response);
	}

}
