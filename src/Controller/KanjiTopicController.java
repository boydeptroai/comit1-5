package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.KanjiTopic;
import Model.DBConnection;
import Model.DAO.KanjiTopicDAOIml;
import Utils.UploadImg;

/**
 * Servlet implementation class KanjiTopicController
 */

@WebServlet("/KanjiTopicController")
public class KanjiTopicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KanjiTopicController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String service = request.getParameter("service");
		
		String pageStr;
		String maxPageItemStr;
		KanjiTopicDAOIml kjTopicDAO = new KanjiTopicDAOIml();

		if(service==null) {
		service = "getAll";
		}
		if(service.equals("getAll"))
		{	KanjiTopic kjTopic = new KanjiTopic();
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			if (pageStr != null) {
				kjTopic.setPage(Integer.parseInt(pageStr));
			} else {
				kjTopic.setPage(1);
			}
			if (maxPageItemStr != null) {
				kjTopic.setMaxPageItem(Integer.parseInt(maxPageItemStr));
			} else {
				kjTopic.setMaxPageItem(3);
			}
			Integer offset = (kjTopic.getPage() - 1) * kjTopic.getMaxPageItem();
			kjTopic.setResultList(kjTopicDAO.findAll(offset, kjTopic.getMaxPageItem()));
			kjTopic.setTotalItem(kjTopicDAO.getTotalItem());
			kjTopic.setTotalPage((int) Math.ceil((double) kjTopic.getTotalItem() / kjTopic.getMaxPageItem()));
			request.setAttribute("kjTopic", kjTopic);	
		RequestDispatcher rd = request.getRequestDispatcher("View/Admin/KanjiTopicAdmin/KanjiTopic.jsp");
		rd.forward(request, response);
		}
		if(service.equals("deletegrouptopic")){
			String ids[]=request.getParameterValues("checked");
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 if(ids==null)
			 {
				  //mess="Fail";
			 }else
			 {
				 for(String idStr:ids)
				 {
					 int id=Integer.parseInt(idStr);
					 kjTopicDAO.delete(id);
				 }
			 }
			 response.sendRedirect("KanjiTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);		
		}
		if(service.equals("deleteone")) {
			String idStr=request.getParameter("topicid");
			int id=Integer.parseInt(idStr);
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 kjTopicDAO.delete(id);
			 response.sendRedirect("KanjiTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);	
		}
		if(service.equals("addnew")) {
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			System.out.println("hihi");
			UploadImg upLoadImg=new UploadImg();
			upLoadImg.uploadFile(request, response);
			String nameimg=(String)request.getAttribute("nameimg");
			System.out.println(nameimg);
			String title=(String)request.getAttribute("title");
			System.out.println(title);

			String content=(String)request.getAttribute("content");
			response.sendRedirect("KanjiTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);		
		}
		if(service.equals("edit")) {
			KanjiTopic kjTopicEdit = new KanjiTopic();
			String idStr=request.getParameter("topicid");
			int id=Integer.parseInt(idStr);
			System.out.println(id);
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 kjTopicEdit= kjTopicDAO.findOne(id);
			 System.out.println(kjTopicEdit);
		     HttpSession session=request.getSession(true);
		     session.setAttribute("kjTopicEdit",kjTopicEdit);  
			 response.sendRedirect("KanjiTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);
		   
		}
		if(service.equals("clearSession")) {
			HttpSession session = request.getSession(false);
			if(session!=null) {
			session.invalidate();
			}
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			response.sendRedirect("KanjiTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);
			 
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);

	}

}
