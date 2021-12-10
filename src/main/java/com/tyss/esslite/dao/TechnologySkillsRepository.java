package com.tyss.esslite.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import static com.tyss.esslite.constants.TechnologyConstants.*;
import com.tyss.esslite.dto.TechnologySkills;

@Repository
public interface TechnologySkillsRepository extends JpaRepository<TechnologySkills, Integer> {

	@Transactional
	@Modifying
	@Query(TECHNOLOGY_DELETE_SKILLID_QUERY)
	void deleteBySkillId(Integer skillId);

}
