package assign.domain;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

	private String name;
	private String description;
	private int id;
	
	public Project() {
		
	}
	public Project(String name, String description, int id) {
		this.name = new String(name);
		this.description = new String(description);
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    public void setId(int id) {
        this.id = id;
    }
    
    public Project copy() {
    	return new Project(this.name, this.description, this.id);
    }
}
