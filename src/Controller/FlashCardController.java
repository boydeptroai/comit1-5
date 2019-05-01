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

import Entity.FlashCardEntity;
import Entity.KanjiTopic;
import Entity.PracticeFLCard;
import Model.DAO.FlashCardDAOIml;
import Model.DAO.KanjiTopicDAOIml;
import Utils.CreateListFlCard;
import Utils.UploadImg;

/**
 * Servlet implementation class FlashCardController
 */
@WebServlet("/FlashCardController")
public class FlashCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlashCardController() {
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
		FlashCardDAOIml flcard=new FlashCardDAOIml();

		if(service==null) {
		service = "getAll";
		}
		if(service.equals("getAll"))
		{	
			
			FlashCardEntity flcardE=new FlashCardEntity();
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			if (pageStr != null) {
				flcardE.setPage(Integer.parseInt(pageStr));
			} else {
				flcardE.setPage(1);
			}
			if (maxPageItemStr != null) {
				flcardE.setMaxPageItem(Integer.parseInt(maxPageItemStr));
			} else {
				flcardE.setMaxPageItem(3);
			}
			Integer offset = (flcardE.getPage() - 1) * flcardE.getMaxPageItem();
			flcardE.setResultList(flcard.findAll(offset, flcardE.getMaxPageItem()));
			flcardE.setTotalItem(flcard.getTotalItem());
			flcardE.setTotalPage((int) Math.ceil((double) flcardE.getTotalItem() / flcardE.getMaxPageItem()));
			request.setAttribute("flcardE", flcardE);	
			RequestDispatcher rd=request.getRequestDispatcher("View/Admin/FlashCardAdmin/FlashCard.jsp");
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
					 flcard.delete(id);
				 }
			 }
			 response.sendRedirect("FlashCardController?page="+pageStr+"&maxPageItem="+maxPageItemStr);		
		}
		if(service.equals("deleteone")) {
			String idStr=request.getParameter("topicid");
			int id=Integer.parseInt(idStr);
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 flcard.delete(id);
			 response.sendRedirect("FlashCardController?page="+pageStr+"&maxPageItem="+maxPageItemStr);	
		}
		if(service.equals("addnew")) {
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			UploadImg upLoadImg=new UploadImg();
			upLoadImg.uploadFile(request, response);
			String nameimg=(String)request.getAttribute("nameimg");
			String title=(String)request.getAttribute("title");
			System.out.println(title);
			String content=(String)request.getAttribute("content");
			response.sendRedirect("FlashCardController?page="+pageStr+"&maxPageItem="+maxPageItemStr);		
		}
		if(service.equals("edit")) {
			FlashCardEntity flcardEdit=new FlashCardEntity();
			String idStr=request.getParameter("topicid");
			int id=Integer.parseInt(idStr);
			System.out.println(id);
			 pageStr = request.getParameter("page");
			 maxPageItemStr = request.getParameter("maxPageItem");
			 flcardEdit= flcard.findOne(id);
			 System.out.println(flcardEdit);
		     HttpSession session=request.getSession(true);
		     session.setAttribute("flcardEdit",flcardEdit);  
			 response.sendRedirect("FlashCardController?page="+pageStr+"&maxPageItem="+maxPageItemStr);
		   
		}
		if(service.equals("clearSession")) {
			HttpSession session = request.getSession(false);
			if(session!=null) {
			session.invalidate();
			}
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			response.sendRedirect("FlashCardController?page="+pageStr+"&maxPageItem="+maxPageItemStr);
			 
		}if(service.equals("getByCategory")) {
			String categoryIdStr=request.getParameter("category");
			String offsetStr=request.getParameter("offset");
			maxPageItemStr=request.getParameter("maxPageItem");
			Integer categoryId=Integer.parseInt(categoryIdStr);
			Integer offset=Integer.parseInt(offsetStr);
			Integer maxInteger=Integer.parseInt(maxPageItemStr);
			List<PracticeFLCard> newList= new ArrayList<PracticeFLCard>();
			CreateListFlCard c = new CreateListFlCard();
			PracticeFLCard practiceFLCard=new PracticeFLCard();
			List<FlashCardEntity> list=flcard.findByCategoryId(categoryId, offset,maxInteger);
			practiceFLCard.setResultList(c.listFl(list));
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
