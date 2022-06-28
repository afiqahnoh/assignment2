package service.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.dao.ServiceDAO;
import service.model.Customer;

/**
 * Servlet implementation class AddCustomerController
 */
@WebServlet("/AddCustomerController")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerController() {
        super();
        dao=new ServiceDAO();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer s = new Customer();
		s.setName(request.getParameter("name"));
		s.setEmail(request.getParameter("email"));
		s.setPhoneNumber(request.getParameter("phoneNumber"));
		s.setTitle(request.getParameter("title"));
		s.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		s.setPrice(Double.parseDouble(request.getParameter("price")));
		s.setDate(Date.valueOf(request.getParameter("date")));
		s.setCategory(request.getParameter("categroy"));

		
		dao.addCustomer(s);
		
		request.setAttribute("customers", ServiceDAO.getAllCustomer());
		RequestDispatcher view = request.getRequestDispatcher("listCustomer.jsp");
		view.forward(request, response);
	}

}
