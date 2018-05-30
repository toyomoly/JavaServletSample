package util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionBoxItems {

	HttpSession session;

	public SessionBoxItems(HttpServletRequest req) {
		this.session = req.getSession();
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, Integer> get() {
		Map<Integer, Integer> boxItems = (Map<Integer, Integer>) session.getAttribute(Constants.SessionAttribute.BOX_ITEMS);
		if (boxItems == null) {
			// Mapを作成
			boxItems = new LinkedHashMap<Integer, Integer>();
			this.set(boxItems);
		}
		return boxItems;
	}

	public void set(Map<Integer, Integer> boxItems) {
		this.session.setAttribute(Constants.SessionAttribute.BOX_ITEMS, boxItems);
	}
}
