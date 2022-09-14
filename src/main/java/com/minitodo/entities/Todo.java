package com.minitodo.entities;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Todo {

	@org.springframework.data.annotation.Id
	private String id;
	
	@NotNull
	private String titel;
	
	@NotNull
	private String status;
	
	public Todo() {
		
	}

	public Todo(String titel, String status) {
		this.titel = titel;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
