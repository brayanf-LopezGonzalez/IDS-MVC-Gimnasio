package models;

import java.sql.Date;

public class User {
	
	public int id;
	public String name;
	private String email;
	private String role;
	private String phone;
	private Date create_at;
	private Date update_at;
	
	public User(int id, String name, String email, String role, String phone, Date create, Date update) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.phone = phone;
		this.create_at = create;
		this.update_at = update;
		
	}
}
