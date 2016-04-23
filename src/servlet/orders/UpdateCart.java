package servlet.orders;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.orders.Book_Order;
import entity.orders.Cart;

public class UpdateCart extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int idBook = Integer.parseInt(req.getParameter("IdBook"));
		String isEdit = req.getParameter("isEdit");
		String isRemove = req.getParameter("isRemove");
		
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<Book_Order> listBook_Order = new ArrayList<>();   
		if (cart == null){
			cart = new Cart();
		}else{
			listBook_Order = cart.getList();
		}
		
		if (isEdit.compareToIgnoreCase("true") == 0){
			resp.sendRedirect("/BookStore/index/book/detailBook.jsp?IdBook=" + idBook);
		}else if (isRemove.compareToIgnoreCase("true") == 0){
			for (int i=0; i<listBook_Order.size(); i++){
				if (listBook_Order.get(i).getBook().getId() == idBook){
					listBook_Order.remove(i);
					resp.sendRedirect("/BookStore/index/orders/checkOut.jsp");
					break;
				}
			}
		}
		
		
	}
}
