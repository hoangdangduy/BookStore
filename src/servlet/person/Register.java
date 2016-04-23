package servlet.person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.person.CustomerDAO;
import dao.person.Customer_MemberDAO;
import dao.person.GetIdFormDB;
import entity.person.Address;
import entity.person.Customer_Member;
import entity.person.FullName;

public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Customer_MemberDAO customer_MemberDAO = new Customer_MemberDAO("sa", "123456");
		CustomerDAO customer = new CustomerDAO("sa", "123456");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String fullname = req.getParameter("fullname");
		String fname = "";
		String mname = "";
		String lname = "";
		String num = req.getParameter("num");
		String ward = req.getParameter("ward");
		String district = req.getParameter("district");
		String city = req.getParameter("city");
		String phonenum = req.getParameter("phonenum");
		String email = req.getParameter("email");

		String[] str = fullname.split(" ");
		if (str.length >= 3){
			fname = str[0];
			lname = str[str.length-1];
			for (int i=1; i<=str.length-2; i++){
				mname = mname + str[i] + " ";
			}
		}else{
			fname = str[0];
			lname = str[str.length-1];
		}
		
//		int i = fullname.indexOf(" ");
//		fname = fullname.substring(0, i);
//		int k = fullname.lastIndexOf(" ");
//		lname = fullname.substring(k + 1);
//		mname = fullname.substring(i + 1, k);

		if (customer_MemberDAO.exitUsername(username) || customer.exitMail(email)) {
			resp.sendRedirect("/BookStore/index/person/register.jsp");
		} else {
			try {
				GetIdFormDB idFormDB = new GetIdFormDB("sa", "123456");
				int id = idFormDB.getValueId();
				FullName fn = new FullName(id, fname, mname, lname);
				Address ad = new Address(id, num, ward, district, city);
				// Kcoin_Bank kb = new Kcoin_Bank();
				// kb.setId(id);
				// kb.setBalance(0);
				// kb.setPart("Kcoin");
				Customer_Member cm = new Customer_Member();
				cm.setId(id);
				cm.setUsername(username);
				cm.setPassword(password);
				cm.setFull_name(fn);
				cm.setAddress(ad);
				cm.setPhoneNum(phonenum);
				cm.setEmail(email);
				// cm.setKcoinBank(kb);
				cm.setPath("CustomerMember");
				Customer_MemberDAO cmdao = new Customer_MemberDAO("sa", "123456");
				cmdao.register(cm);
				resp.sendRedirect("/BookStore/index/home/home.jsp");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
