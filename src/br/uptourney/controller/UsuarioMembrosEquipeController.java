package br.uptourney.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uptourney.dao.UsuarioMembroEquipeDao;
import br.uptourney.model.Usuario;

/**
 * Servlet implementation class usuarioBdController
 */
@WebServlet("/UsuarioMembrosEquipeController")
public class UsuarioMembrosEquipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsuarioMembroEquipeDao userBd = new UsuarioMembroEquipeDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioMembrosEquipeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("player");
		request.setAttribute("listEquipeUsuario", userBd.listarMembrosEquipes(usuario));
		request.getRequestDispatcher("usuariomembrosequipe.jsp").forward(request, response);
	}

	/**,
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
