package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.User;
import util.Constants;
import util.SessionLoginUser;

@WebServlet(urlPatterns = { "/login" })
public class Login extends SuperController {

	// ログイン画面表示
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		SessionLoginUser sessionLoginUser = new SessionLoginUser(req);

		// ログイン判定
		if (sessionLoginUser.isLoginSession()) {
			// 既にログインしている時はitems画面へ
			this.redirect(res, Constants.Url.ITEMS);
		} else {
			this.forward(req, res, Constants.Jsp.LOGIN);
		}
	}

	// 送信ボタンを押したときの処理
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userName = req.getParameter("user-name");
		String password = req.getParameter("password");

		SessionLoginUser sessionLoginUser = new SessionLoginUser(req);

		// ログイン判定
		User user = this.login(userName, password);
		if (user != null) {
			// ログイン成功時
			sessionLoginUser.set(user);

			// items画面へ
			this.redirect(res, Constants.Url.ITEMS);

		} else {
			// ログイン失敗時
			req.setAttribute("loginError", true);
			req.setAttribute("message", Constants.Message.LOGIN_ERROR);
			sessionLoginUser.invalidateSession();

			this.forward(req, res, Constants.Jsp.LOGIN);
		}
	}

	// 入力されたユーザーID,パスワードでユーザー情報を取得
	private User login(String userName, String password) {

		UserDAO userDao = new UserDAO();
		User user = userDao.findByUserName(userName);
		if ((user != null) && (user.equalsPassword(password))) {
			return user;
		} else {
			return null;
		}
	}

}