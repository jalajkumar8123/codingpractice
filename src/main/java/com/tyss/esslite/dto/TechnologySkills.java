package com.tyss.esslite.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.tyss.esslite.constants.TechnologyConstants.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologySkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;

	@Column(length = 100)
	@NotEmpty(message = TECHNOLOGY_SKILLS_REQUIRED_MESSAGE)
	@Size(min = 3, message = TECHNOLOGY_SKILLS_MINIMUM_MESSAGE)
	private String items;

	@NotNull(message = SKILLS_RATINGS_REQUIRED_MESSAGE)
	@Min(value = 1, message = SKILLS_RATINGS_MINIMUM_MESSAGE)
	@Max(value = 5, message = SKILLS_RATINGS_MAXIMUM_MESSAGE)
	private int ratings;

	@Column(name = "type_id", insertable = false, updatable = false)
	private int typeId;

}
