package com.mybatis.entity;

import org.apache.ibatis.annotations.Result;

public class User {

	private int id;
	private String name;
	private int age;
	private String score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public User(String name, int age, String score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}

}
