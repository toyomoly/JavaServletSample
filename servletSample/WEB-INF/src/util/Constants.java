package util;

public final class Constants {

	private Constants() {

	}

	public static class SessionAttribute {
		public static final String LOGIN_USER = "LoginUser";
		public static final String BOX_ITEMS = "BoxItems";
	}

	public static class Url {
		public static final String LOGIN = "../auth/login";
		public static final String LOGOUT = "../auth/logout";
		public static final String ITEMS = "../user/items";
		public static final String BOX = "../user/box";
	}

	public static class Jsp {
		public static final String LOGIN = "/WEB-INF/jsp/login.jsp";
		public static final String LOGOUT = "/WEB-INF/jsp/logout.jsp";
		public static final String ITEMS = "/WEB-INF/jsp/items.jsp";
		public static final String BOX = "/WEB-INF/jsp/box.jsp";
	}

	public static class Message {
		public static final String LOGIN_ERROR = "ユーザー名またはパスワードが違います";
	}
}
