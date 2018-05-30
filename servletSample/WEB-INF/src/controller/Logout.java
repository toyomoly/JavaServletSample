package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constants;
import util.SessionLoginUser;

@WebServlet(urlPatterns = { "/logout" })
public class Logout extends SuperController {

	// ログアウト画面表示
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ログアウト処理
		SessionLoginUser sessionLoginUser = new SessionLoginUser(req);
		sessionLoginUser.invalidateSession();

		this.forward(req, res, Constants.Jsp.LOGOUT);
	}
}
