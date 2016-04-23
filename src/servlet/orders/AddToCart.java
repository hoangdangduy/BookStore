package servlet.orders;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.book.BookDAO;
import entity.book.Book;
import entity.orders.Book_Order;
import entity.orders.Cart;

public class AddToCart extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1797996673438399057L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Addtocart.java - doPost - da nhan");
		resp.sendRedirect("/BookStore/index/book/detailBook.jsp?Id=1");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		BookDAO bookDAO = new BookDAO("sa", "123456");
		Book book = new Book();
		Book_Order book_Order = new Book_Order();

		int idBook = Integer.parseInt(req.getParameter("IdBook"));
		int soLuong = Integer.parseInt(req.getParameter("quantity"));
		book = bookDAO.getBookByID(idBook);
		book_Order.setTotalPrice(book.getOriginalPrice() * soLuong);
		book_Order.setBook(book);
		book_Order.setQuantity(soLuong);
		// book_Order = new Book_Order(soLuong, 100, book);

		ArrayList<Book_Order> listBook_Order = new ArrayList<>();   
		if (cart == null){
			cart = new Cart();
		}else{
			listBook_Order = cart.getList();
		}

		boolean trungPhanTu = false;
		for (int i = 0; i < listBook_Order.size(); i++) {
			if (listBook_Order.get(i).getBook().getId() == idBook) {
				listBook_Order.set(i, book_Order);
				trungPhanTu = true;
				break;
			}
		}

		if (trungPhanTu == false) {
			listBook_Order.add(book_Order);
			cart.setList(listBook_Order);
		}
		session.setAttribute("cart", cart);

		resp.sendRedirect("/BookStore/index/book/detailBook.jsp?IdBook=" + idBook);
	}
}
