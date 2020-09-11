package com.order.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDto {
	
//	private UUID idCreator;
	@NotNull
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String firstName;
}
