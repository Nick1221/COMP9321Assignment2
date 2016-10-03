package user;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cs9321ass2.*;

//@WebServlet("/user")
public class UserController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public UserController()
	{
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		String nextPage = "";
		if(action.equals("registerUser"))
		{
			HashMap<String, Object> data = new HashMap<String, Object>();
			String [] creditCardNos = null;
			if(!(request.getParameter("creditCardNo").equals("")))
			{
				creditCardNos = request.getParameter("creditCardNo").split(",");//split with commas if got many cards
				for(String s :creditCardNos) s.trim();
			}
			if(!(request.getParameter("username").equals(""))) data.put("username", request.getParameter("username"));
			else data.put("username", "");
			if(!(request.getParameter("password").equals(""))) data.put("password", request.getParameter("password"));
			else data.put("password", "");
			if(!(request.getParameter("email").equals(""))) data.put("email", request.getParameter("email"));
			else data.put("email", "");
			data.put("confirmedEmail", "0");
			if(!(request.getParameter("firstname").equals(""))) data.put("firstName", request.getParameter("firstname"));
			else data.put("firstName", "");
			if(!(request.getParameter("lastname").equals(""))) data.put("lastName", request.getParameter("lastname"));
			else data.put("lastName", "");
			if(!(request.getParameter("yearOfBirth").equals(""))) data.put("yob", request.getParameter("yearOfBirth"));
			else data.put("yob", "");
			if(!(request.getParameter("fullAddress").equals(""))) data.put("fullAddress", request.getParameter("fullAddress"));
			else data.put("fullAddress", "");
			if(creditCardNos == null || creditCardNos.length == 0) data.put("creditCardNo", "");
			else
			{
				int i = 1;
				for(String s : creditCardNos)
					data.put("creditCardNo" + i, s);
				++i;
			}
			User u1 = new User().create(data);
			nextPage = "login.jsp";
		}
		else if(action.equals("newUserSignUp"))
		{
			nextPage = "userRegister.jsp";
		}
		else if(action.equals("loginUser"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User u1 = new User().findByKey("username", username); //gives the User obj from db
			if(u1 != null && !u1.isBanned() && u1.attemptLogin(password))
			{
				request.setAttribute("isLoggedIn", true);
				List<User> loggedIn = new LinkedList<User>();
				loggedIn.add(u1);
				ub.setLoggedInUser(loggedIn);
				nextPage = "search.jsp";
			}
			else
			{
				request.setAttribute("isLoggedIn", false);//set to false, so error msg wil show on login page
				nextPage = "login.jsp";
			}
		}
		else if(action.equals("userLogout"))
		{
			request.getSession().setAttribute("user",null);
			nextPage = "login.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/"+nextPage);
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}