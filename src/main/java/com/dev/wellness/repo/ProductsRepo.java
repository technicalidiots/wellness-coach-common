package com.dev.wellness.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.wellness.entity.Products;
import com.dev.wellness.entity.WellnessUser;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {

	List<Products> findByUser(WellnessUser user);

	@Query("SELECT a FROM Products a WHERE a.id=:id")
	Products findProduct(@Param("id") Long id);

}
