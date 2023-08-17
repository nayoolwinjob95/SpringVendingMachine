package co.jp.kadai.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import co.jp.kadai.entity.Item;

@Service
public class VendingMachineService {

	public ArrayList<Item> initializeItems() {
		ArrayList<Item> Items = new ArrayList<>();
		Items.add(new Item(1, "Coca Cola", 150));
		Items.add(new Item(2, "Water", 100));
		Items.add(new Item(3, "Fanta", 200));
		Items.add(new Item(4, "Hot Coffee", 160));
		Items.add(new Item(5, "Black Coffee", 130));
		Items.add(new Item(6, "Pocari", 170));

		return Items;
	}

	public int purchase(ArrayList<Item> items, String[] itemIds, int cash) {
		List<String> itemIdList = Arrays.asList(itemIds);
		for (Item item : items) {
			if (itemIdList.contains(Integer.toString(item.getItemId()))) {
				cash -= item.getItemPrice();
			}
		}
		return cash;
	}

}
