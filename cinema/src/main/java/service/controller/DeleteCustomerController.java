package service.controller;

import java.io.IOException;
import service.dao.ServiceDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCustomerController
 */
@WebServlet("/DeleteCustomerController")
public class DeleteCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceDAO dao;
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerController() {
        super();
        dao=new ServiceDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteCustomer(id);
		request.setAttribute("customers", ServiceDAO.getAllCustomer());
		RequestDispatcher view = request.getRequestDispatcher("listCustomer.jsp");
		view.forward(request, response);
		
	}

	
}
