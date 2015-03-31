/**
 * 
 */
package com.sswf.vote.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.sswf.vote.HttpUtils;

/**
 * @author Aleh
 *
 */
@WebServlet("/selectImage")
public class ChooseImageServlet extends HttpServlet {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] str = req.getParameterValues("imageCheckBoxName");
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		for (String string : str) {
			FileUtils.writeByteArrayToFile(
					new File(HttpUtils.obfuscateName(string)),
					HttpUtils.doGet(string));
			pw.println("<img src='" + string + "'/><br/>");
		}
		pw.close();
	}
}
