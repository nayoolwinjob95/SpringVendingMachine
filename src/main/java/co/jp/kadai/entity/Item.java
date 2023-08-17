package co.jp.kadai.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Item {
	private int itemId;
	private String itemName;
	private int itemPrice;
}
