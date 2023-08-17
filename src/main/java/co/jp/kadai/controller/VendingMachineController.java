package co.jp.kadai.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.jp.kadai.entity.Item;
import co.jp.kadai.service.VendingMachineService;

@Controller
public class VendingMachineController {

	VendingMachineService vendingMachineService;

	private ArrayList<Item> items;

	@Autowired
	public VendingMachineController(VendingMachineService vendingMachineService) {
		this.vendingMachineService = vendingMachineService;
		items = vendingMachineService.initializeItems();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String show(Model model, @RequestParam(name = "item", defaultValue = "") String[] itemIds,
			@RequestParam(name = "cash", defaultValue = "0") Integer cash) {
		int remainingCash = vendingMachineService.purchase(items, itemIds, cash);
		model.addAttribute("remainingCash", remainingCash);
		return "index";
	}

	@ModelAttribute(name = "items")
	ArrayList<Item> items() {
		return items;
	}
}
