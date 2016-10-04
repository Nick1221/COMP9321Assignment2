package user;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cs9321ass2.*;
import general.*;

//@WebServlet("/user")
public class UserController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public UserController()
	{
		super();
	}
	public static String getBaseUrl(HttpServletRequest request) {
	    String scheme = request.getScheme() + "://";
	    String serverName = request.getServerName();
	    String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
	    String contextPath = request.getContextPath();
	    return scheme + serverName + serverPort + contextPath;
	  }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		String nextPage = "";
		if(action.equals("confirmEmail"))
		{
			String username = request.getParameter("username");
			String code = request.getParameter("code");
			System.out.println(username + code);
			User u = new User().findByKey("Username",username);
			System.out.println("This is the code " + u.get("code").toString());
			if (u.get("code") != null) u.attemptEmailConfirmation(code);
			nextPage ="search.jsp";
		}
		else if(action.equals("registerUser"))
		{
			HashMap<String, Object> data = new HashMap<String, Object>();
			if(!(request.getParameter("creditCardNo").equals("")))
			{
				data.put("cardNumber",request.getParameter("creditCardNo"));
			}
			if(!(request.getParameter("username").equals(""))) data.put("Username", request.getParameter("username"));
			else data.put("Username", "");
			if(!(request.getParameter("password").equals(""))) data.put("password", request.getParameter("password"));
			else data.put("password", "");
			if(!(request.getParameter("email").equals(""))) data.put("email", request.getParameter("email"));
			else data.put("email", "");
			data.put("confirmedEmail", "0");
			if(!(request.getParameter("firstname").equals(""))) data.put("firstName", request.getParameter("firstname"));
			else data.put("firstName", "");
			if(!(request.getParameter("lastname").equals(""))) data.put("lastName", request.getParameter("lastname"));
			else data.put("lastName", "");
			if(!(request.getParameter("yearOfBirth").equals(""))) data.put("bDate", request.getParameter("yearOfBirth") + "/" + request.getParameter("monthOfBirth") + "/" + request.getParameter("dateOfBirth"));
			else data.put("bDate", "");
			if(!(request.getParameter("fullAddress").equals(""))) data.put("fullAddress", request.getParameter("fullAddress"));
			else data.put("fullAddress", "");
			if(!(request.getParameter("nickname").equals(""))) data.put("nickname", request.getParameter("nickname"));
			else data.put("nickname", "");
			String uuid = UUID.randomUUID().toString();
			uuid.replace("[\\s\\-(, newChar)]","");
			data.put("code", uuid);
			User u1 = new User().create(data);
			// send confirmation email
			 String url = this.getBaseUrl(request) + "/control?action=confirmEmail&code=" +u1.get("code").toString()+"&username="+u1.get("Username");
			 System.out.println(url);
			 new SendEmail().send(u1.get("email").toString(),url);
			nextPage = "login.jsp";
		}
		else if(action.equals("newUserSignUp"))
		{
			nextPage = "userRegister.jsp";
		}
		else if(action.equals("loginUser"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			String username = request.getParameter("usernameLogin");
			String password = request.getParameter("passwordLogin");
			User u1 = new User().findByKey("Username", username); //gives the User obj from db
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