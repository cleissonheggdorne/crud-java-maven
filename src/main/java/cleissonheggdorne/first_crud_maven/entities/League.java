package cleissonheggdorne.first_crud_maven.entities;

import java.io.Serializable;
import java.util.Objects;

public class League implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private PunctuationType punctuationType;
	
	public League() {
		
	}

	public League(Integer id, String name, PunctuationType punctuationType) {
		this.id = id;
		this.name = name;
		this.punctuationType = punctuationType;
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

	public PunctuationType getPunctuationType() {
		return punctuationType;
	}

	public void setPunctuationType(PunctuationType punctuationType) {
		this.punctuationType = punctuationType;
	}


	@Override
	public String toString() {
		return "League [id=" + id + ", name=" + name + ", PunctuationType=" + punctuationType + "]";
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
		League other = (League) obj;
		return id == other.id;
	}
}
