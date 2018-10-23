package com.app.bean;

import org.springframework.stereotype.Component;

@Component
public class UserBean {
	
	private long id;
	private String username;
    private String password;
    private int age;
    private int salary;
    private String roles;
    
	public UserBean() {
		super();
	}

	public UserBean(long id, String username, String password, int age, int salary, String roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.salary = salary;
		this.roles = roles;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
    
}
