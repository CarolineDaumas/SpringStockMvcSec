package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Category;

@Controller
public class CategoryController {

	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping ("/category")
	public String getCategories ( Model model){
		List<Category> categories= categoryRepository.findAll();
		model.addAttribute("listCategories", categories);
		return "category";
	}
}
