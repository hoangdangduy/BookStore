package servlet.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.book.BookDAO;
import entity.book.Book;

public class SearchBook extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("da nhan :  SearchBook.java");
		String nameBook = req.getParameter("searchBook");
		BookDAO bookDAO = new BookDAO("sa", "123456");
		ArrayList<Book> listBook = new ArrayList<>();
		listBook = bookDAO.getBookByName(nameBook);
		if(listBook == null){
			System.out.println("null");
		}else{
		System.out.println("SearchBook.java : da nhan : size listBook : " + listBook.size());
		}
		HttpSession session = req.getSession();
		session.setAttribute("listBookSearch", listBook);
		resp.sendRedirect("/BookStore/index/book/searchBook.jsp");
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
