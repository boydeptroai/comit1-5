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
import Model.DAO.KanjiTopicDAOIml;
import Utils.UploadImg;

/**
 * Servlet implementation class UpLoadImg
 */
@WebServlet("/UpLoadImg")
public class InsertKanjiTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsertKanjiTopic() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		if(session!=null) {
		session.invalidate();
		}
		UploadImg upLoadImg=new UploadImg();
		KanjiTopicDAOIml kjTopicDAO = new KanjiTopicDAOIml();
		KanjiTopic kjTopic = new KanjiTopic();
		KanjiTopic kjTopicDetail = new KanjiTopic();
		upLoadImg.uploadFile(request, response);
		String nameimg=(String)request.getAttribute("nameimg");
		String title=(String)request.getAttribute("title");
		String idtopic=(String)request.getAttribute("idtopic");	
		String content=(String)request.getAttribute("content");
		String mss=(String)request.getAttribute("messageinsert");
		kjTopic.setTopic_img(nameimg);
		kjTopic.setTopic_guide(content);
		kjTopic.setTopic_name(title);
		if(idtopic.equals("khong"))
		{
			kjTopicDAO.save(kjTopic);	
		}else
		{
			int id=Integer.parseInt(idtopic);
			kjTopic= kjTopicDAO.findOne(id);
			if(nameimg.equals(""))
			{
				kjTopicDetail.setTopic_img(kjTopic.getTopic_img());
			}else {
				kjTopicDetail.setTopic_img(nameimg);	
			}
			kjTopicDetail.setTopic_id(id);	
			kjTopicDetail.setTopic_guide(content);
			kjTopicDetail.setTopic_name(title);
			kjTopicDAO.update(kjTopicDetail);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("KanjiTopicController");
		rd.forward(request, response);
		
		
	}

}
