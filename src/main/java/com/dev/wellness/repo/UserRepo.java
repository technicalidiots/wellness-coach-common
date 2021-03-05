package com.dev.wellness.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.wellness.entity.WellnessUser;

@Repository
public interface UserRepo extends JpaRepository<WellnessUser, Long> {

	WellnessUser findByUserName(String userName);
}
