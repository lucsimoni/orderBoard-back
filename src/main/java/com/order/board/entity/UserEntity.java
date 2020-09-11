package com.order.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="user")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "firstname")
	private String firstname;

	@NotNull
	@Column(name = "role")
	private String role;
	
	@NotNull
	@Column(name = "login")
	private String login;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@DateTimeFormat
	@Column(name = "lastconnection")
	private String lastConnection;

}
