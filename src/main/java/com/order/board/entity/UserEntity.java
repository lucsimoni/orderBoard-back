package com.order.board.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
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
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "firstname")
	private String firstname;

	@NotNull
	@Column(name = "role")
	private String role;
	
	@DateTimeFormat
	@Column(name = "lastconnection")
	private String lastConnection;
	
	@NotNull
	@Column(name = "login")
	private String login;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "firstconnection")
	private boolean firstConnection;
	
	@OneToMany(mappedBy = "saler", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderEntity> orders;

}
