package br.uptourney.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.uptourney.dao.EquipeDao;
import br.uptourney.dao.TorneioDao;
import br.uptourney.model.Equipe;

/**
 * Servlet implementation class CadEquipeController
 */
@WebServlet("/GetEquipeController")
public class GetEquipeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EquipeDao equipeDao = new EquipeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEquipeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listJogo", new TorneioDao().listarJogos());
		request.setAttribute("listEquipe", equipeDao.listarEquipes());
		
		request.getRequestDispatcher("equipeform.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long codigo = Integer.parseInt(request.getParameter("codigo"));
        Equipe equipe = new Equipe();
        equipe.setId(codigo);
        EquipeDao equipeDAO = new EquipeDao();
        request.getSession().setAttribute("equipeEscolhida", equipeDAO.listarEquipeID(codigo));
        System.out.println(equipeDAO.listarEquipeID(codigo));
        request.getRequestDispatcher("equipe2.jsp").forward(request, response);
	}

}
