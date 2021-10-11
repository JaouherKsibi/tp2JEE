package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlanEtudesImp;
import model.Matiere;

/**
 * Servlet implementation class AjoutMatiere
 */
@WebServlet("/AjoutMatiere")
public class AjoutMatiere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutMatiere() {
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
		PlanEtudesImp pei=new PlanEtudesImp();
		pei.addMatiere(new Matiere(pei.id_matiere_creation()+1,request.getParameter("nom"),Integer.parseInt(request.getParameter("nbr_h_cours")),Integer.parseInt(request.getParameter("nbr_h_tp")),
				Float.parseFloat(request.getParameter("coef")),pei.getGroupeModuleById(Integer.parseInt(request.getParameter("gpm")))));
		request.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

}
