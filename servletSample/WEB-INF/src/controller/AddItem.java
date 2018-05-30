package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Constants;
import util.SessionBoxItems;

@WebServlet(urlPatterns = { "/add-item" })
public class AddItem extends AuthorizeController {

	// BoxにItemを追加する処理
	@Override
	protected void doPostCommand(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String itemId = req.getParameter("item-id");

		this.addItem(req, Integer.parseInt(itemId));

		this.redirect(res, Constants.Url.BOX);
	}

	private void addItem(HttpServletRequest req, Integer productId) {

		SessionBoxItems sessionBoxItems = new SessionBoxItems(req);
		Map<Integer, Integer> items = sessionBoxItems.get();

		// Mapにキー(productId)を追加
		int currentNum = items.getOrDefault(productId, 0);
		items.put(productId, currentNum + 1);
	}

}