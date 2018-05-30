package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Item;

public class ItemsDAO {

	public List<Item> findAll() {

		List<Item> result = new ArrayList<>();

		result.add(new Item(1, "hoge"));
		result.add(new Item(2, "fuga"));

		return result;
	}

}
