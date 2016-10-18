package user;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs9321ass2.*;
import publication.*;

//@WebServlet("/admin")
public class AdminController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public AdminController()
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
		if(action.equals("adminLogin"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User u1 = new User().findByKey("username", username); //gives the User obj from db
			if(u1.attemptLogin(password))
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
		else if(action.equals("banUser"))		
		{		
			if(!(request.getParameter("bannedUser").equals("")))		
			{		
				User u1 = new User().findByKey("username", request.getParameter("bannedUser"));		
				if(!u1.isBanned()) u1.ban();
			}
			nextPage = "admin.jsp";
		}
		else if(action.equals("removeItemForSale"))
		{
			if(!(request.getParameter("srchRslts").equals("")))
			{
				Publication p1 = new Publication().findByKey("pID", request.getParameter("srchRslts"));
                p1.delete("publications", "pID", p1.get("pID"));
			}
			nextPage = "admin.jsp";
		}
		else if(action.equals("unbanUser"))
		{
			if(!(request.getParameter("bannedUser").equals("")))		
			{		
				User u1 = new User().findByKey("Username", request.getParameter("bannedUser"));		
				if(u1.isBanned()) u1.unban();
			}	
			nextPage = "admin.jsp";
		}
		else if(action.equals("getuserdetails"))
		{
			if(!(request.getParameter("bannedUser").equals("")))		
			{	
				String id = request.getParameter("bannedUser");
		        User u = new User().findByKey("Username",id);
		        List<UserActivity> ua = new UserActivity().searchByKey("uID",u.get("uID"));
		        request.setAttribute("userActivities", ua);
		        request.setAttribute("currDetailUser", id);
			}
			nextPage = "admin.jsp";
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