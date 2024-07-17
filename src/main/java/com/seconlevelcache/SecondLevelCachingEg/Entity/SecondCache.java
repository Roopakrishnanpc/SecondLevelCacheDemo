package com.seconlevelcache.SecondLevelCachingEg.Entity;



import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="cache_example")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SecondCache { 
	@Id
private int id;
private String name;
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
@Override
public String toString() {
	return "Second level Cache [id=" + id + ", name=" + name + "]";
}

}
