package com.order.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="purchaseorder")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;
	
	@NotNull
	@Column(name = "ordergroup")
	private String orderGroup;
	
	@NotNull
	@Column(name = "quantity")
	private short quantity;
	
	@NotNull
	@Column(name = "dateorder")
	private String dateorder;

	@NotNull
	@Column(name = "state")
	private String state;	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salerid", nullable = false)
	@JsonIgnore /*Afin d'éviter les boucles infinies*/
    private UserEntity saler;
	
}
	

	

	

