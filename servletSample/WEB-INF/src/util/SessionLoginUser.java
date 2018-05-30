package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.User;

public class SessionLoginUser {

	HttpSession session;

	public SessionLoginUser(HttpServletRequest req) {
		this.session = req.getSession();
	}

	public User get() {
		return (User) this.session.getAttribute(Constants.SessionAttribute.LOGIN_USER);
	}

	public void set(User user) {
		this.session.setAttribute(Constants.SessionAttribute.LOGIN_USER, user);
	}

	// sessionにログイン情報があるかどうかチェック
	public boolean isLoginSession() {
		return (this.session.getAttribute(Constants.SessionAttribute.LOGIN_USER) != null);
	}

	// session情報を全て削除
	public void invalidateSession() {
		this.session.invalidate();
	}
}
