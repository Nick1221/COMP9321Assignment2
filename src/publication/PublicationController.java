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
			DataHolder p1 = new DataHolder();
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			List<DataHolder> addedPubs = ub.getLoggedInUser().get(0).getRegisteredPublications();
			String [] athrs = request.getParameter("publishAuthor").split(",");
			for(String as : athrs) as.trim();
			List<String> authorList = Arrays.asList(athrs);
			p1.set("title",request.getParameter("publishTitle"));
			p1.set("Author",authorList);
			p1.set("Year",request.getParameter("publishYear"));
			
			addedPubs.add(p1);
//			ub.getLoggedInUser().get(0).setRegisteredPublications(addedPubs);
		}
		else if(action.equals("pauseItem"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			if(!(request.getParameter("ownItems") == null))
			{
				int toPause = Integer.parseInt(request.getParameter("ownItems").trim());
				DataHolder pubToPause = ub.getLoggedInUser().get(0).getRegisteredPublications().get(toPause);
				if(pubToPause.get("isVisible").equals(false)) //if already paused
					request.setAttribute("paused", true);
				else
					ub.getLoggedInUser().get(0).getRegisteredPublications().get(toPause).set("isVisible", false); //pause the publication
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
				DataHolder pubToActivate = ub.getLoggedInUser().get(0).getRegisteredPublications().get(toActivate);
				if(pubToActivate.get("isVisible").equals(true)) //if already active
					request.setAttribute("active", true);
				else
					ub.getLoggedInUser().get(0).getRegisteredPublications().get(toActivate).set("isVisible", true);//activate the publication
			}
			else
				request.setAttribute("nothingSelected", true);
			nextPage = "existingItems.jsp";
		}
		else if(action.equals("getdetail"))
		{
			DetailBean toFind = (DetailBean) request.getSession().getAttribute("detail");
			ResultsBean rsts = (ResultsBean) request.getSession().getAttribute("result");
			List<Publication> allDetails = new LinkedList<Publication>();
			if(!(request.getParameter("srchRslts") == null))
			{
				String position = request.getParameter("srchRslts").trim();
				Publication toGet = rsts.getResults().get(Integer.parseInt(position));
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