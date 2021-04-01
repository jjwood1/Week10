package Wood.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Wood.beans.Item;
import Wood.repository.ItemRepository;

@Controller
public class WebController {
	@Autowired
	ItemRepository repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllItems(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewItem(model);
		}
		model.addAttribute("items", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputItem")
	public String addNewItem(Model model) {
		Item i = new Item();
		model.addAttribute("newItem", i);
		return "addeditdelete";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateItem(@PathVariable("id") long id, Model model) {
		Item i = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT" + i.toString());
		model.addAttribute("newItem", i);
		return "addeditdelete";
	}
	@PostMapping("/update/{id}")
	public String reviseItem(Item i, Model model)
	{
		repo.save(i);
		return viewAllItems(model);
	}
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") long id, Model model) {
		Item i = repo.findById(id).orElse(null);
		repo.delete(i);
		return viewAllItems(model);
	}
	
}
