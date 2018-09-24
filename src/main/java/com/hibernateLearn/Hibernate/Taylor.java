package com.hibernateLearn.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Taylor {
	@Id
	private int id;
	private Songs song;
	private boolean fav;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Songs getSong() {
		return song;
	}
	public void setSong(Songs song) {
		this.song = song;
	}
	public boolean isFav() {
		return fav;
	}
	public void setFav(boolean fav) {
		this.fav = fav;
	}
	@Override
	public String toString() {
		return "Taylor [id=" + id + ", song=" + song + ", fav=" + fav + "]";
	}
}
