package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuperController extends HttpServlet {

	// 画面遷移：リダイレクト
	void redirect(HttpServletResponse res, String path) throws ServletException, IOException {
		res.sendRedirect(path);
	}

	// 画面遷移：フォワード
	void forward(HttpServletRequest req, HttpServletResponse res, String path) throws ServletException, IOException {
		RequestDispatcher dispacher = req.getRequestDispatcher(path);
		dispacher.forward(req, res);
	}

}
