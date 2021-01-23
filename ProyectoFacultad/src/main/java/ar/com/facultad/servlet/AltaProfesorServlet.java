package ar.com.facultad.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.ReferenceType;

import ar.com.facultad.entity.NombreCompleto;
import ar.com.facultad.entity.Profesor;
import ar.com.facultad.enumerator.ECurso;
import ar.com.facultad.repository.ProfesorRepository;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class AltaProfesorServlet
 */
public class AltaProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaProfesorServlet() {
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
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		ECurso curso = ECurso.valueOf(request.getParameter("materia"));
		
		if(!(nombre.isEmpty() && apellido.isEmpty())){
			
			Profesor profesor = new Profesor(new NombreCompleto(nombre,apellido),curso);
			ProfesorRepository pr = new ProfesorRepository();
			pr.save(profesor);
			request.setAttribute("resultado", true);
		}else{
			request.setAttribute("resultado", false);
		}
		
		request.getRequestDispatcher("Resultado.jsp").forward(request, response);
	}

}
