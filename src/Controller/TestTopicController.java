package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.KanjiTopic;
import Entity.TestEntity;
import Entity.TestTopicEntity;
import Model.DAO.KanjiTopicDAOIml;
import Model.DAO.TestDAOIml;
import Model.DAO.TestTopicDAO;
import Model.DAO.TestTopicDAOIml;
import Utils.UploadImg;

/**
 * Servlet implementation class TestTopicController
 */
@WebServlet("/TestTopicController")
public class TestTopicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TestTopicController() {
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
		TestTopicDAOIml testTopicDAO=new TestTopicDAOIml();

		if(service==null) {
		service = "getAll";
		}
		if(service.equals("getAll"))
		{	
		TestTopicEntity testTopic= new TestTopicEntity();
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			if (pageStr != null) {
				testTopic.setPage(Integer.parseInt(pageStr));
			} else {
				testTopic.setPage(1);
			}
			if (maxPageItemStr != null) {
				testTopic.setMaxPageItem(Integer.parseInt(maxPageItemStr));
			} else {
				testTopic.setMaxPageItem(3);
			}
			Integer offset = (testTopic.getPage() - 1) * testTopic.getMaxPageItem();
			testTopic.setResultList(testTopicDAO.findAll(offset, testTopic.getMaxPageItem()));
			testTopic.setTotalItem(testTopicDAO.getTotalItem());
			testTopic.setTotalPage((int) Math.ceil((double) testTopic.getTotalItem() / testTopic.getMaxPageItem()));
			request.setAttribute("testTopic", testTopic);	
			RequestDispatcher rd=request.getRequestDispatcher("View/Admin/TestTopicAdmin/TestTopic.jsp");
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
					 testTopicDAO.delete(id);
				 }
			 }
			 response.sendRedirect("TestTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);		
		}
		if(service.equals("deleteone")) {
			String idStr=request.getParameter("topicid");
			int id=Integer.parseInt(idStr);
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 testTopicDAO.delete(id);
			 response.sendRedirect("TestTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);	
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
			response.sendRedirect("TestTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);		
		}
		if(service.equals("edit")) {
			
			TestTopicEntity testTopicEdit= new TestTopicEntity();
			String idStr=request.getParameter("topicid");
			int id=Integer.parseInt(idStr);
			System.out.println(id);
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 testTopicEdit= testTopicDAO.findOne(id);
			 
		     HttpSession session=request.getSession(true);
		     session.setAttribute("testTopicEdit",testTopicEdit);  
			 response.sendRedirect("TestTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);
		   
		}
		if(service.equals("clearSession")) {
			HttpSession session = request.getSession(false);
			if(session!=null) {
			session.invalidate();
			}
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			response.sendRedirect("TestTopicController?page="+pageStr+"&maxPageItem="+maxPageItemStr);
			 
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
