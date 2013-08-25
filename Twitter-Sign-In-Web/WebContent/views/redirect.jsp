<%@page import="twitter4j.TwitterException"%>
<%@page import="twitter4j.User"%>
<%@page import="twitter4j.TwitterFactory"%>
<%@page import="twitter4j.Twitter"%>
<%@page import="twitter4j.auth.RequestToken"%>
<%@page import="twitter4j.auth.AccessToken"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function closeWindow(){
   <%!private long userId;
	private String screenName;
	private String name;
	private String avatarUrl;
	private String selfDescription;%>
	
	<%Twitter twitter = (Twitter) request.getSession().getAttribute(
					"twitter");
			RequestToken requestToken = (RequestToken) request.getSession()
					.getAttribute("requestToken");
			String verifier = request.getParameter("oauth_verifier");
			AccessToken accessToken = null;
			try {
				accessToken = twitter.getOAuthAccessToken(requestToken,
						verifier);
				request.getSession().removeAttribute("requestToken");

			} catch (TwitterException twitterException) {
				twitterException.printStackTrace();
			}
			userId = accessToken.getUserId();
			User user = twitter.showUser(userId);
			avatarUrl = user.getProfileImageURL().toString();
			System.out.println(user.getScreenName());
			%>
			
		self.close();
	}
</script>
</head>

<body onload="javascript:closeWindow()">
</body>

</html>