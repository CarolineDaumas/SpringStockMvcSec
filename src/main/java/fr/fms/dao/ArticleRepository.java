package fr.fms.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.fms.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
	
	Page<Article> findByDescriptionContains(String description, Pageable pageable);
	
	@Query("select A from Article A where A.id= :id")
	public Article findOne(@Param("id")long id);
	
	@Modifying
	@Transactional
	@Query("update Article a set a.price= :p where a.id= :id")
	public void update(@Param("p")double price,@Param("id")long id);
	
	public Page<Article> findAll(Pageable pageable);
	
	public Page<Article> findByCategoryId(Long categoryId,Pageable pageable);

	List<Article> findByCategoryName(String catName);
}
