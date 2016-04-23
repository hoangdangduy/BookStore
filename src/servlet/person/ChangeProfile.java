package servlet.person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.person.AddressDAO;
import dao.person.CustomerDAO;
import dao.person.FullNameDAO;
import entity.person.Address;
import entity.person.Customer;
import entity.person.FullName;

public class ChangeProfile extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddressDAO addressDAO = new AddressDAO("sa", "123456");
		FullNameDAO fullNameDAO = new FullNameDAO("sa", "123456");
		CustomerDAO customerDAO = new CustomerDAO("sa", "123456");
		
		HttpSession session = req.getSession();
		int id = (Integer) session.getAttribute("idCustomer");
		System.out.println("ChangeProfile.java : " + id);
		
		String name = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phoneNum = req.getParameter("phonenum");
		String num = req.getParameter("num");
		String ward = req.getParameter("ward");
		String district = req.getParameter("district");
		String city = req.getParameter("city");
		
		String fname = "";
		String mname = "";
		String lname = "";
		String[] str = name.split(" ");
		if (!name.isEmpty()){
			if (str.length >= 3){
				fname = str[0];
				lname = str[str.length-1];
				for(int i=1; i<=str.length-2; i++){
					mname = mname + str[i] + " ";
				}
				mname = mname.substring(0, mname.length()-1);
			}else{
				fname = str[0];
				mname = "";
				lname = str[1];
			}
		}
		
		if (!name.isEmpty()){
			FullName fullName = new FullName(id, fname, mname, lname);
			fullNameDAO.editFullName(fullName);
		}
		
		Address address = addressDAO.getAddressById(id);
		if (num.isEmpty()){
			num = address.getNum();
		}
		if (ward.isEmpty()){
			ward = address.getWard();
		}
		if (district.isEmpty()){
			district = address.getDistric();
		}
		if (city.isEmpty()){
			city = address.getCity();
		}
		address = new Address(id, num, ward, district, city);
		addressDAO.editAddress(address);
		
		Customer customer = customerDAO.getCustomerById(id);
		if (phoneNum.isEmpty()){
			phoneNum = customer.getPhoneNum();
		}
		if (email.isEmpty()){
			email = customer.getEmail();
		}
		customer = new Customer(id, phoneNum, email);
		customerDAO.editCustomer(customer);
		
		resp.sendRedirect("/BookStore/index/person/editInformation.jsp");
	}
	
	
}
