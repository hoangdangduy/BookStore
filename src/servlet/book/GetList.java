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

public class GetList extends HttpServlet {
	public GetList() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		synchronized (session) {
			ArrayList<Book> arr = (ArrayList<Book>) session.getAttribute("listBook");

			if (arr == null) {
				BookDAO bdao = new BookDAO("sa", "123456");
				arr = bdao.getAllBook();
				session.setAttribute("listBook", arr);
			}
		}
		resp.sendRedirect("/BookStore/index/home/home.jsp");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
