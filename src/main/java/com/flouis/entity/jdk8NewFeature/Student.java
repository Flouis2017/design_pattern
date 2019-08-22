package com.flouis.entity.jdk8NewFeature;

import com.google.common.collect.Lists;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

	private String studentId;
	private String name;
	private String sex;
	private Integer age;
	private List<Stationery> stationeries = Lists.newArrayList();

}
