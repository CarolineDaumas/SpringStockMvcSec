package fr.fms.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@Controller
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "keyword", defaultValue = "") String kw ) {

		List<Category> categories = categoryRepository.findAll();
		Page<Article> articles = articleRepository.findByDescriptionContains(kw, PageRequest.of(page, 5));
		model.addAttribute("categories", categories);
		model.addAttribute("listArticle", articles.getContent());
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", kw);

		return "articles";
	}

	@GetMapping("/delete")
	public String delete(Long id, int page, String keyword) {
		articleRepository.deleteById(id);
		return "redirect:/index?page=" + page + "&keyword=" + keyword;

	}

//	@GetMapping("/article")
//	public String article() {
//		return "article";
//		
//	}

	@GetMapping("/article")
	public String article(Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("category", categoryRepository.findAll());
		return "article";
	}

	@PostMapping("/save")
	public String save(Model model, @Valid Article article, BindingResult bindingResult, @RequestParam("catName") String catName) {
		if (bindingResult.hasErrors())
			return "article";
		article.setCategory(categoryRepository.getCategoryByName(catName));
		articleRepository.save(article);
		return "article";
	}

	@GetMapping("/articlesByIdCategory")
	public String articlesByIdCategory(Model model, @RequestParam(name = "catId", defaultValue = "") Long catId,
			@RequestParam(name = "page", defaultValue = "0") int page) {
		
		Page<Article> articles = articleRepository.findByCategoryId(catId,PageRequest.of(page, 5));
		//model.addAttribute("listArticle", articles);
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("listArticle", articles.getContent());
		model.addAttribute("pages", new int[articles.getTotalPages()]);
		model.addAttribute("currentPage", page);
		return "articles";
	}
}
