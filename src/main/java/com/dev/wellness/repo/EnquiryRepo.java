package com.dev.wellness.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.wellness.entity.Enquiries;
import com.dev.wellness.entity.WellnessUser;

@Repository
public interface EnquiryRepo extends JpaRepository<Enquiries, Long> {

	List<Enquiries> findByUser(WellnessUser user);
}
