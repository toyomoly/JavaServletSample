package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import dto.Item;
import util.Constants;

@WebServlet(urlPatterns = { "/user/items" })
public class Items extends SuperController {

	// 商品一覧画面表示
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ItemsDAO itemsDao = new ItemsDAO();
		List<Item> items = itemsDao.findAll();

		// requestスコープにデータセット
		req.setAttribute("items", items);

		this.forward(req, res, Constants.Jsp.ITEMS);
	}

}
