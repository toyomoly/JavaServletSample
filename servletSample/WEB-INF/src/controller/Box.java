package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDAO;
import dto.Item;
import util.Constants;
import util.SessionBoxItems;

@WebServlet(urlPatterns = { "/user/box" })
public class Box extends SuperController {

	// Item画面表示
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		List<Item> items = this.getBoxItems(req);

		// requestスコープにデータセット
		req.setAttribute("items", items);

		this.forward(req, res, Constants.Jsp.BOX);
	}

	// Box内のItemの一覧
	private List<Item> getBoxItems(HttpServletRequest req) {

		SessionBoxItems sessionBoxItems = new SessionBoxItems(req);
		Map<Integer, Integer> boxItems = sessionBoxItems.get();

		ItemsDAO itemsDao = new ItemsDAO();
		List<Item> items = itemsDao.findAll();

		List<Item> result = new ArrayList<>();

		for (int itemId : boxItems.keySet()) {
			// BOXのItemをリストから取得
			Item item = this.getItemByItemId(items, itemId);
			if (item != null) {
				// BOXに入れた数を設定
				item.setPickCount(boxItems.get(itemId));
				// 出力用のリストに追加
				result.add(item);
			}
		}

		return result;
	}

	// リスト中のitemIdが一致する要素を返す
	private Item getItemByItemId(List<Item> items, int itemId) {
		for (Item item : items) {
			if (item.getItemId() == itemId) {
				return item;
			}
		}
		return null;
	}

}