package com.sswf.vote;

import java.io.BufferedReader;
import java.io.File;
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/vote")
public class Vote extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String URL = "https://oauth.vk.com/access_token?client_id=4840782&client_secret=kzSjX0MNswoxZfgEiI6s&v=5.29&grant_type=client_credentials&scope=photos,video,offline";

	private static final Pattern PATTERN = Pattern.compile("(\\w{36,100})+");

	private static final String userId_URL = "http://api.vkontakte.ru/method/users.get?uids=USER_ID&fields=photo_200,status";

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
		HttpSession session = request.getSession(false);
		session.setAttribute("url", saveImage(request, session));
		if (token != null) {
			session.setAttribute("token", token);
			response.sendRedirect("data.jsp");
		}
	}

	private String saveImage(HttpServletRequest request, HttpSession session) {
		String urlString = userId_URL.replace("USER_ID",
				request.getParameter("viewer_id"));
		try {
			URL url = new URL(urlString);
			InputStream in = (InputStream) url.getContent();
			ObjectMapper mapper = new ObjectMapper();
			String urlImage = mapper.readValue(in, Response.class)
					.getResponse()[0].getPhoto_200();
			saveImage(urlImage, session);
			return urlImage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void saveImage(String urlImage, HttpSession session) {
		try {
			HttpGet get = new HttpGet(urlImage);
			HttpClient client = new DefaultHttpClient();
			HttpResponse httpResponse = client.execute(get);

			String fileName = String.valueOf(System.currentTimeMillis())
					+ ".jpg";

			File file = new File(fileName);
			session.setAttribute("book1", fileName);
			System.out.println(fileName);
			session.setAttribute("book2", file.getAbsolutePath());
			System.out.println(file.getAbsolutePath());
			InputStream is = httpResponse.getEntity().getContent();
			FileUtils.writeByteArrayToFile(file, IOUtils.toByteArray(is));
			get.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
