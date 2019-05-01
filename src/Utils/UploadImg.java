package Utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileUploadIOException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.MultipartStream;
import org.apache.commons.fileupload.MultipartStream.MalformedStreamException;

public class UploadImg {
	public static void uploadFile(HttpServletRequest request, HttpServletResponse response)
			throws IOException { /* final String address="E:\\"; */

		ServletContext context = request.getServletContext();// goi realpath
		PrintWriter out = response.getWriter();
		final String address = context.getRealPath("/Images/");

		final int MaxMemorySize = 1024 * 1024 * 3; // 3MB
		final int MaxRequestSize = 1024 * 1024 * 50;// 50MB

		// Check that we have a file upload request--khong co ectype trong form upload
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			request.setAttribute("messageinsert", "Not have:multipart/form-data trong form");
			// out.println("Not have:multipart/form-data trong form");
		} else {
			// Create a factory for disk-based file items--tao bo nho tam
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// kick co vung nho tam va dia chi cua no
			factory.setSizeThreshold(MaxMemorySize);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

			// Create a new file upload handler--su ly upload
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Set overall request size constraint--kich thuong file upload
			upload.setSizeMax(MaxRequestSize);
			// Parse the request--list chua file upload

			try {
				// parses the request's content to extract file data
				@SuppressWarnings("unchecked")
				List<FileItem> formItems = upload.parseRequest(request);

				// list khac null
				if (formItems != null && formItems.size() > 0) {
					// iterates over form's fields
					for (FileItem item : formItems) {

						// processes only fields that are not form fields

						if (!item.isFormField()) {
							String filename = new File(item.getName()).getName();// lay ten file
							String filePath = address + File.separator + filename;// dia chi luu file
							File storeFile = new File(filePath);
							request.setAttribute("nameimg", filename);
							//request.setAttribute("messageinsert",filePath);
							System.out.println(filePath);

							// kiem tra file ton tai chua
							boolean kt = storeFile.exists();
							if (kt == true) {
								request.setAttribute("messageinsert", "file exists");
								// out.println("file exists");
							} else {
								// saves the file on disk
								item.write(storeFile);
								request.setAttribute("messageinsert", "ok");
							}

						} else {
							String name = item.getFieldName();
							System.out.println(name);
							if (name.equals("idtopic")) {
								String idtopic= item.getString();
								request.setAttribute("idtopic",idtopic);
							}	
							if (name.equals("title")) {
								String title = item.getString();
								request.setAttribute("title", title);
							}
							if (name.equals("service")) {
								String service = item.getString();
								System.out.println("gia tri service"+ service);
								//request.setAttribute("title", title);
							}
							if (name.equals("content")) {
								String content = item.getString();
								request.setAttribute("content", content);
							}
							
						}
					}
				}
			} catch (Exception ex) {
				request.setAttribute("messageinsert", "There was an error: " + ex.getMessage());

			}

		}

	}

}
