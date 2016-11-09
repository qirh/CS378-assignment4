package assign.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

	private String name;
	private String des;
	private List<String> link;
	
	public Project(String name, String des, String link) {
		this.name = name;
		this.des = des;
		this.link = new ArrayList<String>();
		this.link.add(link);
	}
	/*	copy constructor	*/
	public Project(String name, String des, List<String> link) {
		this.name = name;
		this.des = des;
		
		List<String> tmp = new ArrayList<String>();
		for(String l : link)
			tmp.add(l);
		
		this.link = tmp;
	}

	public String getName() {
		return name;
	}
	public String getDes() {
		return des;
	}
	public List<String> getLink() {
		return link;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDes(String des) {
		this.des = des;
	}
    public void setLink(List<String> link) {
        this.link = link;
    }
    public void addLink(String link) {
        this.link.add(link);
    }
    
    public Project copy() {
    	return new Project(this.name, this.des, this.link);
    }
}
