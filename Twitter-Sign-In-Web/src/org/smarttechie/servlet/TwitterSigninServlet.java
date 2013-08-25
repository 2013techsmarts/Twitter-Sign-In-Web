package org.smarttechie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

/**
 * Servlet implementation class TwitterSigninServlet
 */
public class TwitterSigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterSigninServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Twitter twitter = new TwitterFactory().getInstance();
			RequestToken requestToken;
			request.getSession().setAttribute("twitter", twitter);
			twitter.setOAuthConsumer("<Consumer key goes here>", "<Consumer secret goes here>");			
			requestToken = twitter.getOAuthRequestToken("http://127.0.0.1:8080/Twitter-Sign-In-Web/views/redirect.jsp");			
			String authURL = requestToken.getAuthenticationURL();
			request.getSession().setAttribute("requestToken", requestToken);
			response.sendRedirect(authURL);
		} catch (TwitterException  twitterException) {
			twitterException.printStackTrace();
		}
	}
}
