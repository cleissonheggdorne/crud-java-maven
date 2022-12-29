package cleissonheggdorne.first_crud_maven.entities;

import java.io.Serializable;
import java.util.Objects;

public class Team implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	public Team () {
		
	}
	
	public Team(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
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
		Team other = (Team) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}	
	
}