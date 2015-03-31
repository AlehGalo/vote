package com.sswf.vote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 
 */

/**
 * @author Aleh
 *
 */
public final class HttpUtils {

	private static final String URL = "https://oauth.vk.com/access_token?client_id=4840782&client_secret=kzSjX0MNswoxZfgEiI6s&v=5.29&grant_type=client_credentials&scope=photos,video,offline";

	private static final Pattern PATTERN = Pattern.compile("(\\w{36,100})+");

	/**
	 * 
	 */
	private HttpUtils() {
	}

	public static String requestToken() throws IOException {
		URL url;
		String token = null;
		url = new URL(URL);
		InputStream in = (InputStream) url.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
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
		return token;
	}

	public static byte[] doGet(String urlString) throws IllegalStateException,
			IOException {
		HttpGet get = new HttpGet(urlString);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse httpResponse = httpclient.execute(get);
		try {
			return IOUtils.toByteArray(httpResponse.getEntity().getContent());
		} finally {
			httpResponse.close();
		}
	}

	public static String obfuscateName(String url) {
		if (url == null) {
			return null;
		}
		return url.replaceAll("[//:-]", "");
	}

}
