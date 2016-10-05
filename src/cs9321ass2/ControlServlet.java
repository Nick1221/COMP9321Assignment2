package cs9321ass2;

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

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/control")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private List<Publication> publications;
    //private List<UserSimulation> users;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() 
    {
        super();
        // not using xml file as db anymore, so no DOM/SAX parser
        /*try 
		{
        	users = new LinkedList<UserSimulation>();
        	users.add(new UserSimulation("asd", "asd", "asd@asdas.com")); //-----------some examples------------
        	users.add(new UserSimulation("man", "a123", "man@asdas.com")); //-----------test use only------------ 
        	File inputFile = new File("/home/nick/workspace/9321myproject/Assignment1Redo/WebContent/WEB-INF/dblp.xml");
			 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			 DocumentBuilder dB = dbf.newDocumentBuilder();

			 Document doc = dB.parse(inputFile);
			 doc.getDocumentElement().normalize();

			 XPath xPath = XPathFactory.newInstance().newXPath();

			 String expression = "/dblp/*";
			 NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			 publications = new LinkedList<Publication>();
			 for (int i = 0; i < nodeList.getLength(); i++) 
			{
				Publication sample = new Publication();
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element eElement = (Element) nNode;
					if(!(eElement.getAttribute("mdate") == null))
						sample.setDate(eElement.getAttribute("mdate"));
					if(!(eElement.getAttribute("key") == null))
						sample.setKey(eElement.getAttribute("key"));
					if(!(eElement.getAttribute("publtype") == null))
						sample.setPublType(eElement.getAttribute("publtype"));
					if(!(eElement.getElementsByTagName("author").item(0) == null))
					{
						List<String> authors = new ArrayList<String>();
						for(int j = 0; j < eElement.getElementsByTagName("author").getLength();j++)
						{
							authors.add(eElement.getElementsByTagName("author").item(j).getTextContent());
						}
						sample.setAuthor(authors);
					}
					if(!(eElement.getElementsByTagName("editor").item(0) == null))
					{
						List<String> editors = new ArrayList<String>();
						for(int l = 0; l < eElement.getElementsByTagName("editor").getLength();l++)
						{
							editors.add(eElement.getElementsByTagName("editor").item(l).getTextContent());
						}
						sample.setEditor(editors);
					}
					if(!(eElement.getElementsByTagName("title").item(0) == null))
						sample.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("bookTitle").item(0) == null))
						sample.setBookTitle(eElement.getElementsByTagName("bookTitle").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("pages").item(0) == null))
						sample.setPages(eElement.getElementsByTagName("pages").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("year").item(0) == null))
						sample.setYear(eElement.getElementsByTagName("year").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("address").item(0) == null))
						sample.setAddress(eElement.getElementsByTagName("address").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("volume").item(0) == null))
						sample.setVolume(eElement.getElementsByTagName("volume").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("journal").item(0) == null))
						sample.setJournal(eElement.getElementsByTagName("journal").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("number").item(0) == null))
						sample.setNumber(eElement.getElementsByTagName("number").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("month").item(0) == null))
						sample.setMonth(eElement.getElementsByTagName("month").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("url").item(0) == null))
						sample.setUrl(eElement.getElementsByTagName("url").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("ee").item(0) == null))
						sample.setEe(eElement.getElementsByTagName("ee").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("cdrom").item(0) == null))
						sample.setCdrom(eElement.getElementsByTagName("cdrom").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("cite").item(0) == null))
						sample.setCite(eElement.getElementsByTagName("cite").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("publisher").item(0) == null))
						sample.setPublisher(eElement.getElementsByTagName("publisher").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("note").item(0) == null))
						sample.setNote(eElement.getElementsByTagName("note").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("crossref").item(0) == null))
						sample.setCrossref(eElement.getElementsByTagName("crossref").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("isbn").item(0) == null))
						sample.setIsbn(eElement.getElementsByTagName("isbn").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("series").item(0) == null))
						sample.setSeries(eElement.getElementsByTagName("series").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("school").item(0) == null))
						sample.setSchool(eElement.getElementsByTagName("school").item(0).getTextContent());
					if(!(eElement.getElementsByTagName("chapter").item(0) == null))
						sample.setChapter(eElement.getElementsByTagName("chapter").item(0).getTextContent());
				}
				//System.out.println(sample.toString());
				publications.add(sample);
			}
			 System.out.println("Size of publications is " + publications.size());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}*/
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action"); //may be different name from view level
		String nextPage = "";
		if(action.equals("newUserSignUp") || action.equals("loginUser") || action.equals("userLogout") || action.equals("registerUser") || action.equals("confirmEmail"))  //may be different action name coming from the view level
            nextPage = "user";
        else if(action.equals("adminRegister") || action.equals("adminLogin") || action.equals("adminLogout") || action.equals("banUser") || action.equals("removeItemForSale"))
            nextPage = "admin";
        else if(action.equals("addPublication") || action.equals("pauseItem") || action.equals("activateItem") || action.equals("getdetail"))
            nextPage="publications";
        else if(action.equals("mainSearch") || action.equals("specSearch") || action.equals("shopCart") || action.equals("addtocartFrDetail") || action.equals("addtocartFrSearchResult") || action.equals("removeFrCart"))
            nextPage="search";
		RequestDispatcher rd = request.getRequestDispatcher("/" + nextPage);   
		rd.forward(request, response);
		/*
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println("Action is " + action);
		String nextPage = "results.jsp";
		if(action.equals("shopCart")) 
		{
			ShopCartBean scb = (ShopCartBean) request.getSession().getAttribute("shopcart");
			if(scb.getPublications().size() == 0) request.setAttribute("isEmpty", true);
			else request.setAttribute("isEmpty", false);
			nextPage = "shopCart.jsp";
		}
		else if(action.equals("mainSearch"))
		{
			//look thru records from XML
			String input1 = request.getParameter("input1");
			ResultsBean rsts = (ResultsBean) request.getSession().getAttribute("result");
			List<Publication> mainSearchResults = new LinkedList<Publication>();
			if(!(input1.equals("")))
			{
				for(Publication p : publications)
				{
					if(p.doesContainTxt(input1))
						mainSearchResults.add(p);
				}
			}
			if(mainSearchResults.size() == 0) request.setAttribute("isEmpty", true);
			else
			{
				request.setAttribute("isEmpty", false);
				rsts.setResults(mainSearchResults);
			}
		}
		else if(action.equals("specSearch"))
		{
			//depending on what to look for, ie publication, publicationType, date, author, venue
			//look thru records
			ResultsBean rsts = (ResultsBean) request.getSession().getAttribute("result");
			List<Publication> searchResults = new LinkedList<Publication>();
			if(!(request.getParameter("year").equals("")))
			{
				for(Publication p : publications)
				{
					if(p.getYear().contains(request.getParameter("year")))
						searchResults.add(p);
				}
			}
			if(!request.getParameter("address").equals(""))
			{
				for(Publication p : publications)
				{
					if(p.getAddress().contains(request.getParameter("address")))
						searchResults.add(p);
				}
			}
			if(!request.getParameter("author").equals(""))
			{
				for(Publication p : publications)
				{
					for(String a : p.getAuthor())
					{
						if(a.contains(request.getParameter("author")))
						{
							searchResults.add(p);
							break;
						}
					}
				}
			}
			if(!request.getParameter("publisher").equals(""))
			{
				for(Publication p : publications)
				{
					if(p.getPublisher().contains(request.getParameter("publisher")))
						searchResults.add(p);
				}
			}
			if(!request.getParameter("isbn").equals(""))
			{
				for(Publication p : publications)
				{
					if(p.getIsbn().contains(request.getParameter("isbn")))
						searchResults.add(p);
				}
			}
			//-------
			if(searchResults.size() == 0) request.setAttribute("isEmpty", true);
			else
			{
				request.setAttribute("isEmpty", false);
				rsts.setResults(searchResults);
			}
		}
		else if(action.equals("getdetail"))
		{
			System.out.println("Selected random is " + request.getParameter("randoms"));
			DetailBean toFind = (DetailBean) request.getSession().getAttribute("detail");
			List<Publication> allDetails = new LinkedList<Publication>();
			if(!(request.getParameter("randoms") == null))
			{
				for(Publication p : publications)
				{
					if(request.getParameter("randoms").contains(p.getKey())) 
					{
						allDetails.add(p);
						toFind.setFullDetailed(allDetails);
						break;
					}
				}
			}
			if(allDetails.size() == 0) request.setAttribute("isEmpty", true);
			else request.setAttribute("isEmpty", false);
			nextPage = "details.jsp";
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
				Publication toAdd = rsts.getResults().get(Integer.parseInt(position));
				List<Publication> inCart = scb.getPublications();
				inCart.add(toAdd);
				scb.setPublications(inCart);
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
		else if(action.equals("newUserSignUp")) //from login page, user clicks 'Sign Up' and is taken to register page
		{
			nextPage = "userRegister.jsp";
		}
		else if(action.equals("loginUser"))
		{
			if(users.isEmpty()) //only if there are no users in system yet
			{
				request.setAttribute("registered", false);
				nextPage = "userRegister.jsp";
			}
			else //
			{
				boolean foundUser = false;
				for(UserSimulation u : users)
				{
					if(u.getUsername().equals(request.getParameter("usernameLogin")) && u.getPassword().equals(request.getParameter("passwordLogin")))
					{
						UserBean loggedUser = (UserBean) request.getSession().getAttribute("user");
						List<UserSimulation> theLoggedIn = new LinkedList<UserSimulation>();
						theLoggedIn.add(u);
						loggedUser.setLoggedInUser(theLoggedIn);
						foundUser = true;
						request.setAttribute("isLoggedIn", true);
						nextPage = "search.jsp";
						break;
					}
				}
				if(!foundUser)
				{
					request.setAttribute("isLoggedIn", false);
					nextPage = "login.jsp";
				}
			}
		}
		else if(action.equals("registerUser"))
		{
			//UserSimulation class to simulate a user obj
			System.out.println("Username is " + request.getParameter("username"));
			System.out.println("Password is " + request.getParameter("password"));
			System.out.println("Email is " + request.getParameter("email"));
			UserSimulation user1 = new UserSimulation(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
			users.add(user1); //simulating a list of users
			//send confirm email to new user
			nextPage = "login.jsp";
		}
		else if(action.equals("addPublication"))
		{
			Publication p1 = new Publication();
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			List<Publication> addedPubs = ub.getLoggedInUser().get(0).getMyRegisteredPublications();
			//System.out.println("Title is " + request.getParameter("publishTitle"));
			//System.out.println("Author(s) is " + request.getParameter("publishAuthor"));
			String [] athrs = request.getParameter("publishAuthor").split(",");
			for(String as : athrs) as.trim();
			List<String> authorList = Arrays.asList(athrs);
			//for(String s : athrs) System.out.println("Author : " + s);
			//for(String a : authorList) System.out.println("From Authorlist : " + a);
			//System.out.println("Year is " + request.getParameter("publishYear"));
			p1.setTitle(request.getParameter("publishTitle"));
			p1.setAuthor(authorList);
			p1.setYear(request.getParameter("publishYear"));
			publications.add(p1);
			addedPubs.add(p1);
			ub.getLoggedInUser().get(0).setMyRegisteredPublications(addedPubs);
			nextPage = "search.jsp";
		}
		else if(action.equals("pauseItem"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			System.out.println("No of users " + ub.getLoggedInUser().size());
			System.out.println("ownItems is " + request.getParameter("ownItems"));
			if(!(request.getParameter("ownItems") == null))
			{
				System.out.println("got here");
				int toPause = Integer.parseInt(request.getParameter("ownItems").trim());
				Publication pubToPause = ub.getLoggedInUser().get(0).getMyRegisteredPublications().get(toPause);
				boolean alreadyPaused = true;
				for(Publication p : publications)
				{
					if(pubToPause.getTitle().equalsIgnoreCase(p.getTitle())) //
					{ //pausing here
						publications.remove(p);
						alreadyPaused = false; 
						break;
					}
				}
				if(alreadyPaused) //if already paused, will go thru whole list and wont find it
					request.setAttribute("paused", true);
				else
					ub.getLoggedInUser().get(0).getMyRegisteredPublications().get(toPause).setActive(false);
			}
			else
			{
				request.setAttribute("nothingSelected", true);
				System.out.println("nothing selected is set");
			}
			nextPage = "existingItems.jsp";
		}
		else if(action.equals("activateItem"))
		{
			UserBean ub = (UserBean) request.getSession().getAttribute("user");
			if(!(request.getParameter("ownItems") ==  null))
			{
				int toActivate = Integer.parseInt(request.getParameter("ownItems").trim());
				Publication pubToActivate = ub.getLoggedInUser().get(0).getMyRegisteredPublications().get(toActivate);
				if(pubToActivate.isActive()) //if already active
					request.setAttribute("active", true);
				else
				{
					publications.add(pubToActivate); //add to list of publications
					ub.getLoggedInUser().get(0).getMyRegisteredPublications().get(toActivate).setActive(true);
				}
			}
			else
				request.setAttribute("nothingSelected", true);
			nextPage = "existingItems.jsp";
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/"+nextPage);
		rd.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/*public List<Publication> getRandomObjs()
	{
		List<Publication> toShow = new LinkedList<Publication>();
		Random random = new Random();
		for(int i = 0; i < 10; i++)
		{
			int no = random.nextInt(publications.size());
			//System.out.println("Random no is " + no);
			toShow.add(publications.get(no));
		}
		//System.out.println("Size of publications after randoms is " + publications.size());
		return toShow;
	}*/
}
