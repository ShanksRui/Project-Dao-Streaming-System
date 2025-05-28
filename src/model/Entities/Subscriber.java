package model.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Subscriber implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer age;
	private LocalDate StartSubscription;
	
	private Streaming streaming;

	
	public Subscriber(Integer id, String name, Integer age, LocalDate startSubscription, Streaming streaming){
		this.id = id;
		this.name = name;
		this.age = age;
		this.StartSubscription = startSubscription;
		this.streaming = streaming;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDate getStartSubscription() {
		return StartSubscription;
	}

	public void setStartSubscription(LocalDate startSubscription) {
		StartSubscription = startSubscription;
	}
	
	public Streaming getStreaming() {
		return streaming;
	}

	public void setStreaming(Streaming streaming) {
		this.streaming = streaming;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscriber other = (Subscriber) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Subscriber [id=" + id + ", name=" + name + ", age=" + age + ", StartSubscription=" + StartSubscription
				+ ", streaming=" + streaming + "]";
	}	
}
