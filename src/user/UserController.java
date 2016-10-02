package user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import cs9321ass2.*;
import publication.*;
import search.*;
import user.*;
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
			if(creditCardNos.length == 0 || creditCardNos == null) data.put("creditCardNo", "");
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
		else if(action.equals("userLogout"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			ub.getLoggedInUser().clear();
			//User u1 = new User().findByKey("username", ub.getLoggedInUser().get(0).get("username"));
			//u1.logout();
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