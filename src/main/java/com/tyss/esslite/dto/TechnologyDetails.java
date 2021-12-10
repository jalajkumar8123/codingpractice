package com.tyss.esslite.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static com.tyss.esslite.constants.TechnologyConstants.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;

	@Column(length = 100)
	@NotEmpty(message = TECHNOLOGY_TYPE_REQUIRED_MESSAGE)
	@Size(min = 3, message = TECHNOLOGY_TYPE_MINIMUM_MESSAGE)
	private String type;

	@Column(length = 20)
	private String employeeId;

	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "type_id")
	private List<TechnologySkills> skills;

}
