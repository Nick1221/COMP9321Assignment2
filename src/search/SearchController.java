package search;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs9321ass2.*;
import publication.*;
import user.UserRegisteredPublication;
@WebServlet("/search")
public class SearchController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public SearchController()
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
		List<Publication> results = new LinkedList<Publication>();
		if(action.equals("homepage")) {
			ResultsBean rsts = (ResultsBean) request.getSession().getAttribute("result");
			List<Publication> ps = new Publication().searchByKey("1",1);
			for(int i=0; i<10;i++) {
				Random rand = new Random();
				results.add(ps.get(rand.nextInt((ps.size() - 0) + 1)));
			}
			rsts.setResults(results);
			nextPage = "search.jsp";
		}
		else if(action.equals("mainSearch"))
		{
			ResultsBean rsts = (ResultsBean) request.getSession().getAttribute("result");
			if(!(request.getParameter("input1").equals("")))
			{
				results.addAll(new Publication().searchByKey("title", "%"+request.getParameter("input1")+"%", false));
				results.addAll(new Publication().searchByKey("author", "%"+request.getParameter("input1")+"%", false));
				results.addAll(new Publication().searchByKey("year", "%"+request.getParameter("input1")+"%", false));
				results.addAll(new Publication().searchByKey("editor", "%"+request.getParameter("input1")+"%", false));
				results.addAll(new Publication().searchByKey("volume", "%"+request.getParameter("input1")+"%", false));
//				for(Publication p : results) {
//					if (new UserRegisteredPublication().findByKey("pID",p.get("pID")).get("isVisible").equals("false"))
//						results.remove(p);
//				}
			}
			if(results.size() == 0) request.setAttribute("isEmpty", true);
			else
			{
				request.setAttribute("isEmpty", false);
				rsts.setResults(results);
			}
			nextPage = "results.jsp";
		}
		else if(action.equals("specSearch"))
		{
			HashMap<String,Object> hash =  new HashMap<String,Object>();
			ResultsBean rsts = (ResultsBean) request.getSession().getAttribute("result");
			if(!(request.getParameter("year").equals("")))
				hash.put("year", "%"+request.getParameter("year")+"%");
			if(!(request.getParameter("address").equals("")))
				hash.put("address", "%"+request.getParameter("address")+"%");
			if(!(request.getParameter("author").equals("")))
				hash.put("author", "%"+request.getParameter("author")+"%");
			if(!(request.getParameter("editor").equals("")))
				hash.put("editor", "%"+request.getParameter("editor")+"%");
			results.addAll(new Publication().searchByKeys(hash,false));
			
//			for(Publication p : results) {
//				if (new UserRegisteredPublication().findByKey("pID",p.get("pID")).get("isVisible").equals("false"))
//					results.remove(p);
//			}
			if(results.size() == 0) request.setAttribute("isEmpty", true);
			else
			{
				request.setAttribute("isEmpty", false);
				rsts.setResults(results);
			}
			nextPage = "results.jsp";
		}
		else if(action.equals("shopCart")) 
		{ //not involving db
			ShopCartBean scb = (ShopCartBean) request.getSession().getAttribute("shopcart");
			if(scb.getPublications().size() == 0) request.setAttribute("isEmpty", true);
			else request.setAttribute("isEmpty", false);
			nextPage = "shopCart.jsp";
		}
		else if(action.equals("addtocartFrDetail"))
		{
			ShopCartBean scb = (ShopCartBean) request.getSession().getAttribute("shopcart");
			DetailBean detailed = (DetailBean) request.getSession().getAttribute("detail");
			List<Publication> inCart = scb.getPublications();
			inCart.add(detailed.getFullDetailed().get(0));
			scb.setPublications(inCart);
			nextPage="shopCart.jsp";
		}
		else if(action.equals("addtocartFrSearchResult"))
		{
			ShopCartBean scb = (ShopCartBean) request.getSession().getAttribute("shopcart");
			ResultsBean rsts = (ResultsBean) request.getSession().getAttribute("result");
			if(!(request.getParameter("srchRslts") == null))
			{
				String position = request.getParameter("srchRslts").trim();
				System.out.println("ID of pub to add to cart is " + position);
				Publication toAdd = new Publication().findByKey("pID", Integer.parseInt(position));
				scb.getPublications().add(toAdd);
				//List<Publication> inCart = scb.getPublications();
				//inCart.add(toAdd);
				//scb.setPublications(inCart);
				nextPage = "shopCart.jsp";
			}
			else
			{
				request.setAttribute("noneSelected", true);
				nextPage = "results.jsp";
			}
		}
		else if(action.equals("removeFrCart"))
		{
			ShopCartBean scb = (ShopCartBean) request.getSession().getAttribute("shopcart");
			if(!(request.getParameter("inCarts") ==  null))
			{
				int toRemove = Integer.parseInt(request.getParameter("inCarts").trim());
				List<Publication> tempList = scb.getPublications();
				tempList.remove(toRemove);
				scb.setPublications(tempList);
				if(tempList.size() == 0) request.setAttribute("isEmpty", true);
				else request.setAttribute("isEmpty", false);
			}
			else
				request.setAttribute("noneSelected", true);
			nextPage = "shopCart.jsp";
		}
		request.setAttribute("results", results);
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