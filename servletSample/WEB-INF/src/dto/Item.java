package dto;

public class Item {

	private int itemId;
	private String itemName;

	private int pickCount = 0;

	public Item(int itemId, String itemName) {
		this.itemId = itemId;
		this.itemName = itemName;
	}

	public int getItemId() {
		return this.itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public int getPickCount() {
		return this.pickCount;
	}

	public void setPickCount(int putCount) {
		this.pickCount = putCount;
	}

}
