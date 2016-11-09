package assign.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class Projects {
	    
    private List<Project> projects;
    
    public Projects() {
    	projects = new ArrayList<Project>();
    }
    
    public List<Project> getProjects() {
    	List<Project> tmp = new ArrayList<Project>();
    	
    	for(Project p : projects) 
    	    tmp.add(p.copy());
    	
    	return tmp;
    }
    
    public void addProject(Project p) {
    	projects.add(p);
    }
}
