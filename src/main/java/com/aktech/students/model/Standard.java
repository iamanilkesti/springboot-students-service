package com.aktech.students.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Standard {
	private Long standardId;
	private String name;
	private String subjects;
	private String clasTeacher;
}
