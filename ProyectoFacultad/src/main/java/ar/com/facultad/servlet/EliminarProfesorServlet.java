package ar.com.facultad.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.facultad.entity.Profesor;
import ar.com.facultad.repository.ProfesorRepository;

/**
 * Servlet implementation class EliminarProfesorServlet
 */
public class EliminarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProfesorServlet() {
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
		int id = Integer.valueOf(request.getParameter("eliminarPorId"));
		
		ProfesorRepository pr = new ProfesorRepository();
		Profesor profesor = pr.getLikeId(id);
		
		if(profesor != null){
			pr.delete(profesor);
			request.setAttribute("resultado", true);
		}else{
			request.setAttribute("resultado", false);
		}
		
		request.getRequestDispatcher("Resultado.jsp").forward(request, response);
	}

}
