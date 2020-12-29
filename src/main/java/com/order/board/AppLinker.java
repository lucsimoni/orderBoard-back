package com.order.board;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppLinker {

	@Value("${app.text-a}")
	private String textA;
	
	@Value("${url.text-b}")
	private String textB;
}
