package publication;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cs9321ass2.*;
import general.DataHolder;
import user.*;

//@WebServlet("/publication")
public class PublicationController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public PublicationController()
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
		if(action.equals("addPublication"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
            HashMap<String,Object> data = new HashMap<String,Object>();
            
            for(String k : request.getParameterMap().keySet()) {
                System.out.println(k);
            }
            
            data.put("title", request.getParameter("publishTitle"));
            data.put("author", request.getParameter("publishAuthor"));
            data.put("editor", request.getParameter("publishEditors"));
            data.put("year", request.getParameter("publishYear"));
            data.put("volume", request.getParameter("publishVolume"));
            data.put("price", request.getParameter("publishPrice"));
            data.put("picture", request.getParameter("publishPic"));
            
            
            
            Publication p = new Publication().create(data);
            
            Publication p_u = new Publication().findByKey("title",request.getParameter("publishTitle")); //same titles will give only the first one found
            
            ub.getLoggedInUser().get(0).registerPublication(p_u);
            nextPage= "existingItems.jsp";
		}
		else if(action.equals("pauseItem"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			if(!(request.getParameter("ownItems") == null))
			{
				int toPause = Integer.parseInt(request.getParameter("ownItems").trim());
				System.out.println("The id to pause is " + toPause);
				UserRegisteredPublication urp = new UserRegisteredPublication().findByKey("pID",toPause);
				Publication arp = new Publication().findByKey("pID", toPause);
				if (urp != null && urp.get("uID").equals(ub.getLoggedInUser().get(0).get("uID"))) {
                    arp.set("isVisible","0");
                    arp.save();
                }
			}
			else
				request.setAttribute("nothingSelected", true);
			nextPage = "existingItems.jsp";
		}
		else if(action.equals("activateItem"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			if(!(request.getParameter("ownItems") ==  null))
			{
				int toActivate = Integer.parseInt(request.getParameter("ownItems").trim());
				System.out.println("The id to activate is " + toActivate);
				UserRegisteredPublication urp = new UserRegisteredPublication().findByKey("pID",toActivate);
				Publication arp = new Publication().findByKey("pID", toActivate);
				if (urp != null && urp.get("uID").equals(ub.getLoggedInUser().get(0).get("uID"))) {
                    arp.set("isVisible","1");
                    arp.save();
                }
			}
			else
				request.setAttribute("nothingSelected", true);
			nextPage = "existingItems.jsp";
		}
		else if(action.equals("getdetail"))
		{
			DetailBean toFind = (DetailBean) request.getSession().getAttribute("detail");
			//ResultsBean rsts = (ResultsBean) request.getSession().getAttribute("result");
			System.out.println("got here");
			List<Publication> allDetails = new LinkedList<Publication>();
			if(!(request.getParameter("srchRslts") == null))
			{
				System.out.println("the requested id is " + request.getParameter("srchRslts"));
				String pubID = request.getParameter("srchRslts").trim();
				System.out.println("publishID is " + pubID);
				Publication toGet = new Publication().findById(Integer.parseInt(pubID));//rsts.getResults().get(Integer.parseInt(position));
				allDetails.add(toGet);
				toFind.setFullDetailed(allDetails);
			}
			if(allDetails.size() == 0) request.setAttribute("isEmpty", true);
			else request.setAttribute("isEmpty", false);
			nextPage = "details.jsp";
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