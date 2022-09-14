package com.minitodo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Todo {

	@GeneratedValue
	@Id
	private int id;
	
//	@Column(unique = true)
	@NotNull
	@Column
	private String titel;
	
	@NotNull
	@Column
	private String status;
	
	public Todo() {
		
	}

	public Todo(String titel, String status) {
		this.titel = titel;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", titel=" + titel + ", status=" + status + "]";
	}

	
}
