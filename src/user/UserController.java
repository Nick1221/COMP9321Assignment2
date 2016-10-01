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
@WebServlet("/user")
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
		if(action.equals("userRegister"))
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String yob = request.getParameter("yob");
			String fullAddress = request.getParameter("fullAddress");
			String [] creditCardNos = request.getParameter("creditCardNos").split(",");//split with commas if got many cards
			for(String s :creditCardNos) s.trim();
			List<String> cCardList = Arrays.asList(creditCardNos);
			//make user obj 1st(need userId when making cCard obj), then make cCard obj by going thru list
			boolean isAdmin = false;
		}
		else if(action.equals("userLogin"))
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//request.setAttribute("isLoggedIn", true);
			//if login details correct, then set user obj to userbean
		}
		else if(action.equals("userLogout"))
		{
			
		}
		
		//RequestDispatcher rd = request.getRequestDispatcher("/"+nextPage);
		//rd.forward(request, response);
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