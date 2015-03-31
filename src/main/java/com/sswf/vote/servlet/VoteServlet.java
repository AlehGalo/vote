package com.sswf.vote.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sswf.vote.HttpUtils;
import com.sswf.vote.model.Response;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String userId_URL = "http://api.vkontakte.ru/method/users.get?uids=USER_ID&fields=photo_200,status";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		response.getWriter().write("<h1>Hello " + login + "</h1>");
		HttpSession session = request.getSession(false);
		session.setAttribute("url", saveImage(request, session));
		response.sendRedirect("data.jsp");
	}

	private String saveImage(HttpServletRequest request, HttpSession session)
			throws JsonParseException, JsonMappingException,
			IllegalStateException, IOException {
		String urlString = userId_URL.replace("USER_ID",
				request.getParameter("viewer_id"));
		ObjectMapper mapper = new ObjectMapper();
		String urlImage = mapper.readValue(HttpUtils.doGet(urlString),
				Response.class).getResponse()[0].getPhoto_200();
		saveImage(urlImage, session);
		session.setAttribute("viewer_id", request.getParameter("viewer_id"));
		return urlImage;
	}

	private void saveImage(String urlImage, HttpSession session)
			throws IllegalStateException, IOException {
		String fileName = HttpUtils.obfuscateName(urlImage);

		File file = new File(fileName);
		session.setAttribute("book1", fileName);
		session.setAttribute("book2", file.getAbsolutePath());
		FileUtils.writeByteArrayToFile(file, HttpUtils.doGet(urlImage));
	}
}
