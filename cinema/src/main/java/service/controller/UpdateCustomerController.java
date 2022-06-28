package service.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.dao.ServiceDAO;
import service.model.Customer;


/**
 * Servlet implementation class UpdateCustomerController
 */
@WebServlet("/UpdateCustomerController")
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerController() {
        super();
        dao=new ServiceDAO();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("s", ServiceDAO.getCustomerById(id));
		RequestDispatcher view = request.getRequestDispatcher("updateCustomer.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Customer s = new Customer();
		s.setId(Integer.parseInt(request.getParameter("id")));
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setPhoneNumber(request.getParameter("phoneNumber"));
		s.setTitle(request.getParameter("title"));
		s.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		s.setPrice(Double.parseDouble(request.getParameter("price")));
		s.setDate(Date.valueOf(request.getParameter("date")));
		s.setCategory(request.getParameter("categroy"));

		
		
		dao.updateCustomer(s);
		
		request.setAttribute("customers", ServiceDAO.getAllCustomer());
		RequestDispatcher view = request.getRequestDispatcher("listCustomer.jsp");
		view.forward(request, response);
		
	}


}
