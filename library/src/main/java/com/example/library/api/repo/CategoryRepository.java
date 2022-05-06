package com.example.library.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.library.api.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity ,String>{
	/* @Query(value = "SELECT count(*) FROM tb_category WHERE name = ?0", nativeQuery = true)*/
	int countByCategoryCd(@Param("category_cd")String category_cd);

}
