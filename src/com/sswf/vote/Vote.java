package com.sswf.vote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/vote")
public class Vote extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String URL = "https://oauth.vk.com/access_token?client_id=4840782&client_secret=kzSjX0MNswoxZfgEiI6s&v=5.29&grant_type=client_credentials&scope=photos,video,offline ";

	private static final Pattern PATTERN = Pattern.compile("(\\w{36,100})+");

	private String token;

	@Override
	public void init() throws ServletException {
		super.init();
		URL url;
		try {
			url = new URL(URL);
			InputStream in = (InputStream) url.getContent();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			StringBuilder out = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			reader.close();
			String outString = out.toString();
			Matcher matcher = PATTERN.matcher(outString);
			if (matcher.find()) {
				token = matcher.group(0);
				matcher.groupCount();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(token);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		response.getWriter().write(
				"<h1>Hello " + login + "</h1>" + "<br>" + token);
		if (token != null) {
			HttpSession session = request.getSession(false);
			session.setAttribute("token", token);
			response.sendRedirect("data.jsp");
		}
	}
}
