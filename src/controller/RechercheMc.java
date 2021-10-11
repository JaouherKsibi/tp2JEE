package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlanEtudesImp;
import model.Matiere;

/**
 * Servlet implementation class RechercheMc
 */
@WebServlet("/RechercheMc")
public class RechercheMc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheMc() {
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
		String nom=request.getParameter("no");
		PlanEtudesImp pei=new PlanEtudesImp();
		List<Matiere> li=pei.getAllMatiereByNom(nom);
		request.setAttribute("li", li);
		request.setAttribute("no", nom);
		request.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		
		
	}

}
