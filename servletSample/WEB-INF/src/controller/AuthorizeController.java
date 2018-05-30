package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constants;
import util.SessionLoginUser;

public abstract class AuthorizeController extends SuperController {

	// Getの入り口
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html charset = UTF-8");

		SessionLoginUser sessionLoginUser = new SessionLoginUser(req);

		// ログイン判定
		if (!sessionLoginUser.isLoginSession()) {
			// 未ログインなのでログイン画面へ
			this.redirect(res, Constants.Url.LOGIN);
			return;
		}

		// 各画面の処理
		this.doGetCommand(req, res);
	}

	// 各画面の処理、必要に応じてオーバーライドする
	protected void doGetCommand(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.sendDefaultRespose(res);
	}

	// Postの入り口
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html charset = UTF-8");

		SessionLoginUser sessionLoginUser = new SessionLoginUser(req);

		// ログイン判定
		if (!sessionLoginUser.isLoginSession()) {
			// 未ログインなのでログイン画面へ
			this.redirect(res, Constants.Url.LOGIN);
			return;
		}

		// 各画面の処理
		this.doPostCommand(req, res);
	}

	// 各画面の処理、必要に応じてオーバーライドする
	protected void doPostCommand(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.sendDefaultRespose(res);
	}

	// デフォルトのレスポンスとして405エラーを返す
	private void sendDefaultRespose(HttpServletResponse res) throws ServletException, IOException {
		res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

}