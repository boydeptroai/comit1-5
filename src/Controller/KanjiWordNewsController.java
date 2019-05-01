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
import Entity.KanjiWordNewsEntity;
import Model.DAO.KanjiNewsDAOIml;
import Model.DAO.KanjiTopicDAOIml;
import Utils.UploadImg;

/**
 * Servlet implementation class KanjiWordNewsController
 */
@WebServlet("/KanjiWordNewsController")
public class KanjiWordNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KanjiWordNewsController() {
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
		KanjiNewsDAOIml kjNewsDAO = new KanjiNewsDAOIml();

		if (service == null) {
			service = "getAll";
		}
		if (service.equals("getAll")) {
			KanjiWordNewsEntity kjWNews = new KanjiWordNewsEntity();
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			if (pageStr != null) {
				kjWNews.setPage(Integer.parseInt(pageStr));
			} else {
				kjWNews.setPage(1);
			}
			if (maxPageItemStr != null) {
				kjWNews.setMaxPageItem(Integer.parseInt(maxPageItemStr));
			} else {
				kjWNews.setMaxPageItem(3);
			}
			Integer offset = (kjWNews.getPage() - 1) * kjWNews.getMaxPageItem();
			kjWNews.setResultList(kjNewsDAO.findAll(offset, kjWNews.getMaxPageItem()));
			kjWNews.setTotalItem(kjNewsDAO.getTotalItem());
			kjWNews.setTotalPage((int) Math.ceil((double) kjWNews.getTotalItem() / kjWNews.getMaxPageItem()));
			request.setAttribute("kjWNews", kjWNews);
			RequestDispatcher rd = request.getRequestDispatcher("View/Admin/KanjiWordNewsAdmin/KanjiWordNews.jsp");
			rd.forward(request, response);
		}
		if (service.equals("deletegrouptopic")) {
			String ids[] = request.getParameterValues("checked");
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			if (ids == null) {
				// mess="Fail";
			} else {
				for (String idStr : ids) {
					int id = Integer.parseInt(idStr);
					kjNewsDAO.delete(id);
				}
			}
			response.sendRedirect("KanjiWordNewsController?page=" + pageStr + "&maxPageItem=" + maxPageItemStr);
		}
		if (service.equals("deleteone")) {
			String idStr = request.getParameter("topicid");
			int id = Integer.parseInt(idStr);
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			kjNewsDAO.delete(id);
			response.sendRedirect("KanjiWordNewsController?page=" + pageStr + "&maxPageItem=" + maxPageItemStr);
		}
		if (service.equals("addnew")) {
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			System.out.println("hihi");
			UploadImg upLoadImg = new UploadImg();
			upLoadImg.uploadFile(request, response);
			String nameimg = (String) request.getAttribute("nameimg");
			System.out.println(nameimg);
			String title = (String) request.getAttribute("title");
			System.out.println(title);

			String content = (String) request.getAttribute("content");
			response.sendRedirect("KanjiWordNewsController?page=" + pageStr + "&maxPageItem=" + maxPageItemStr);
		}
		if (service.equals("edit")) {

			KanjiWordNewsEntity kjWNewsEdit = new KanjiWordNewsEntity();
			String idStr = request.getParameter("topicid");
			int id = Integer.parseInt(idStr);
			System.out.println(id);
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			kjWNewsEdit = kjNewsDAO.findOne(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("kjWNewsEdit", kjWNewsEdit);
			response.sendRedirect("KanjiWordNewsController?page=" + pageStr + "&maxPageItem=" + maxPageItemStr);

		}
		if (service.equals("clearSession")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			pageStr = request.getParameter("page");
			maxPageItemStr = request.getParameter("maxPageItem");
			response.sendRedirect("KanjiWordNewsController?page=" + pageStr + "&maxPageItem=" + maxPageItemStr);

		}
		if(service.equals("getByCategory")) {
			KanjiWordNewsEntity kjWNews = new KanjiWordNewsEntity();
			String categoryIdStr=request.getParameter("category");
			String offsetStr=request.getParameter("offset");
			maxPageItemStr=request.getParameter("maxPageItem");
			Integer categoryId=Integer.parseInt(categoryIdStr);
			Integer offset=Integer.parseInt(offsetStr);
			Integer maxInteger=Integer.parseInt(maxPageItemStr);
			kjWNews.setResultList(kjNewsDAO.findByCategoryId(categoryId, offset, maxInteger));
			request.setAttribute("kjWNews", kjWNews);
			System.out.println( "Kq by id: "+kjWNews.getResultList());
			RequestDispatcher rd = request.getRequestDispatcher("View/Client/NewsKanji/NewsKanji.jsp");
			rd.forward(request, response);
			
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
