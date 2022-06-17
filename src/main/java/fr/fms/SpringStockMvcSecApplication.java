package fr.fms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringStockMvcSecApplication implements CommandLineRunner {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringStockMvcSecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		articleRepository.save(new Article(null, "Samsung S8", 250));
//		articleRepository.save(new Article(null, "Samsung S9", 300));
//		articleRepository.save(new Article(null, "Iphone 10", 500));
//		articleRepository.save(new Article(null, "Iphone 15", 700));
//		articleRepository.save(new Article(null, "XIAOMI 9", 200));
//		articleRepository.save(new Article(null, "Iphone 8", 350));
//		articleRepository.save(new Article(null, "Haiwei 3", 80));
//		articleRepository.save(new Article(null, "Huawei 4", 120));
//
//		articleRepository.findAll().forEach(a -> System.out.println(a));
		
		
//		Category smartphone= categoryRepository.save(new Category("smartphone"));
//		Category ordinateur= categoryRepository.save(new Category("ordinateur"));
//		Category tablette= categoryRepository.save(new Category("tablette"));
//		
//		articleRepository.save(new Article(null, "Samsung S8", 250.0, smartphone));
//		articleRepository.save(new Article(null, "Samsung S9", 300, smartphone));
//		articleRepository.save(new Article(null, "Iphone 10", 500, smartphone));
//		articleRepository.save(new Article(null, "Iphone 15", 700,smartphone));
//		articleRepository.save(new Article(null, "XIAOMI 9", 200,smartphone));
//		articleRepository.save(new Article(null, "XIAOMI10",350,smartphone));
//		articleRepository.save(new Article(null, "Haiwei 3", 80,smartphone));
//		articleRepository.save(new Article(null, "Huawei 4", 320, tablette));
//		articleRepository.save(new Article(null, "Huawei 40", 350, tablette));
//		articleRepository.save(new Article(null, "HP 500", 1500, ordinateur));
//		articleRepository.save(new Article(null, "XIAOMI 25", 350, tablette));
//		articleRepository.save(new Article(null, "HP 800", 800, ordinateur));
		
	}

}
