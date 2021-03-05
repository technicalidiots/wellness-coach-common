package com.dev.wellness.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.wellness.entity.Results;
import com.dev.wellness.entity.WellnessUser;

@Repository
public interface ResultsRepo extends JpaRepository<Results, Long> {

	List<Results> findByUser(WellnessUser user);

	@Query("SELECT a FROM Results a WHERE a.id=:id")
	Results findResult(@Param("id") Long id);

}
