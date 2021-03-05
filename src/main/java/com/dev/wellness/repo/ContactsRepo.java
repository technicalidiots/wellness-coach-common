package com.dev.wellness.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.wellness.entity.Contact;
import com.dev.wellness.entity.WellnessUser;

@Repository
public interface ContactsRepo extends JpaRepository<Contact, Long> {

	Contact findByUser(WellnessUser user);

	@Query("SELECT a FROM Contact a WHERE a.id=:id")
	Contact findContact(@Param("id") Long id);

}
