package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.FlCardTopicEntity;
import Entity.KanjiTopic;
import Model.DAO.FlCardTopicDAOIml;
import Model.DAO.KanjiTopicDAOIml;
import Utils.UploadImg;

/**
 * Servlet implementation class FlCardTopiController
 */
@WebServlet("/FlCardTopiController")
public class FlCardTopiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlCardTopiController() {
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
		FlCardTopicDAOIml fcTopicDao=new FlCardTopicDAOIml();

		if(service==null) {
		service = "getAll";
		}
		if(service.equals("getAll"))
		{	
			FlCardTopicEntity flcTopic=new FlCardTopicEntity();
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			if (pageStr != null) {
				flcTopic.setPage(Integer.parseInt(pageStr));
			} else {
				flcTopic.setPage(1);
			}
			if (maxPageItemStr != null) {
				flcTopic.setMaxPageItem(Integer.parseInt(maxPageItemStr));
			} else {
				flcTopic.setMaxPageItem(3);
			}
			Integer offset = (flcTopic.getPage() - 1) * flcTopic.getMaxPageItem();
			flcTopic.setResultList(fcTopicDao.findAll(offset, flcTopic.getMaxPageItem()));
			flcTopic.setTotalItem(fcTopicDao.getTotalItem());
			flcTopic.setTotalPage((int) Math.ceil((double) flcTopic.getTotalItem() / flcTopic.getMaxPageItem()));
			request.setAttribute("flcTopic", flcTopic);	
			 RequestDispatcher rd=request.getRequestDispatcher("View/Admin/FlCardTopicAdmin/FLCardTopic.jsp");
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
					 fcTopicDao.delete(id);
				 }
			 }
			 response.sendRedirect("FlCardTopiController?page="+pageStr+"&maxPageItem="+maxPageItemStr);		
		}
		if(service.equals("deleteone")) {
			String idStr=request.getParameter("topicid");
			int id=Integer.parseInt(idStr);
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 fcTopicDao.delete(id);
			 response.sendRedirect("FlCardTopiController?page="+pageStr+"&maxPageItem="+maxPageItemStr);	
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
			response.sendRedirect("FlCardTopiController?page="+pageStr+"&maxPageItem="+maxPageItemStr);		
		}
		if(service.equals("edit")) {
			
			FlCardTopicEntity flcTopicEdit=new FlCardTopicEntity();
			String idStr=request.getParameter("topicid");
			int id=Integer.parseInt(idStr);
			System.out.println(id);
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 flcTopicEdit= fcTopicDao.findOne(id);
		     HttpSession session=request.getSession(true);
		     session.setAttribute("flcTopicEdit",flcTopicEdit);  
			 response.sendRedirect("FlCardTopiController?page="+pageStr+"&maxPageItem="+maxPageItemStr);
		   
		}
		if(service.equals("clearSession")) {
			HttpSession session = request.getSession(false);
			if(session!=null) {
			session.invalidate();
			}
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			response.sendRedirect("FlCardTopiController?page="+pageStr+"&maxPageItem="+maxPageItemStr);
			 
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
