package model.Entities;

import java.io.Serializable;
import java.util.Objects;

public class Streaming implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Double price;
	
	
	public Streaming(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
		Streaming other = (Streaming) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Streaming [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
