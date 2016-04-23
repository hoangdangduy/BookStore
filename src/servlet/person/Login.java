package servlet.person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.person.Customer_MemberDAO;
import entity.orders.Cart;

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer_MemberDAO customer_MemberDAO = new Customer_MemberDAO("sa", "123456");
		HttpSession session = req.getSession();
		session.setAttribute("username", null);
		session.setAttribute("idCart", null);
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (customer_MemberDAO.exitAccount(username, password)) {
			int idCustomer = customer_MemberDAO.getCustomerMemberByUsername(username).getId();
			session.setAttribute("username", username);
			session.setAttribute("idCustomer", idCustomer);
			session.setAttribute("cart", null);
			resp.sendRedirect("/BookStore/index/home/home.jsp");
		} else {
			resp.sendRedirect("/BookStore/index/person/login.jsp");
		}
	}
}
