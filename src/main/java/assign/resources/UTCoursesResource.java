package assign.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import assign.domain.NotFound;
import assign.domain.Project;
import assign.domain.Projects;
import assign.services.ProjectService;
import assign.services.ProjectServiceImpl;

@Path("/myeavesdrop")
public class UTCoursesResource {
	
	ProjectService projectService;
	String password;
	String username;
	String dburl;	
	
	public UTCoursesResource(@Context ServletContext servletContext) {
		dburl = servletContext.getInitParameter("DBURL");
		username = servletContext.getInitParameter("DBUSERNAME");
		password = servletContext.getInitParameter("DBPASSWORD");
		this.projectService = new ProjectServiceImpl(dburl, username, password);		
	}
	
	@GET
	@Path("/helloworld")
	@Produces("text/html")
	public String helloWorld() {
		System.out.println("Inside helloworld");
		System.out.println("DB creds are:");
		System.out.println("DBURL:" + dburl);
		System.out.println("DBUsername:" + username);
		System.out.println("DBPassword:" + password);		
		return "Hello world\n DBURL:" + dburl + "\nDBUSERNAME: " + username + "\nDBPASSWORD: " + password;		
	}
	
	@GET
	@Path("/project")
	@Produces("application/xml")
	public StreamingOutput getProject() throws Exception {
		
		final Project p = projectService.getProject(1);		//1 is a placeholder
		
	    return new StreamingOutput() {
	         public void write(OutputStream outputStream) throws IOException, WebApplicationException {
	            outputProject(outputStream, p);
	         }
	      };
	     
	}	
	
	@GET
	@Path("/projects")
	@Produces("application/xml")
	public StreamingOutput getAllProjects() throws Exception {
				
		final Projects projects = new Projects();
		projects.addProject(projectService.getProject(1));		
			    
	    return new StreamingOutput() {
	         public void write(OutputStream outputStream) throws IOException, WebApplicationException {
	            outputProjects(outputStream, projects);
	         }
	      };	    
	}
	
	@POST
	@Path("/projects")
	@Produces("application/xml")
	public StreamingOutput postProject(InputStream input) throws Exception {
				
		final Project p = readProject(input);
		projectService.addProject(p);
	    return new StreamingOutput() {
	         public void write(OutputStream outputStream) throws IOException, WebApplicationException {
	            outputProject(outputStream, p);
	         }
	      };	    
	}
	
	 protected Project readProject(InputStream is) {
	      try {
	         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	         Document doc = builder.parse(is);
	         Element root = doc.getDocumentElement();
	         Project p = new Project();
	         if (root.getAttribute("id") != null && !root.getAttribute("id").trim().equals(""))
	            p.setId(Integer.valueOf(root.getAttribute("id")));
	         NodeList nodes = root.getChildNodes();
	         for (int i = 0; i < nodes.getLength(); i++) {
	            Element element = (Element) nodes.item(i);
	            if (element.getTagName().equals("name")) {
	               p.setName(element.getTextContent());
	            }
	            else if (element.getTagName().equals("description")) {
	               p.setDescription(element.getTextContent());
	            }
	            else if (element.getTagName().equals("id")) {
	               p.setId(Integer.parseInt(element.getTextContent()));
	            }
	         }
	         return p;
	      }
	      catch (Exception e) {
	         throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
	      }
	   }

	
	protected void outputProjects(OutputStream os, Projects projects) throws IOException {
		try { 
			System.out.println("1 - outputProjects");
			JAXBContext jaxbContext = JAXBContext.newInstance(Projects.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(projects, os);
		} catch (JAXBException jaxb) {
			jaxb.printStackTrace();
			throw new WebApplicationException();
		}
	}	
	
	protected void outputProject(OutputStream os, Project project) throws IOException {
		try { 
			System.out.println("2 - outputProject ");
			System.out.println(project == null );
			System.out.println(os == null );
			JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(project, os);
		} catch (JAXBException jaxb) {
			jaxb.printStackTrace();
			throw new WebApplicationException();
		}
	}
	
	protected void outputNotFound(OutputStream os, NotFound notFound) throws IOException {
		try { 
			System.out.println("3 - outputNotFound");
			JAXBContext jaxbContext = JAXBContext.newInstance(NotFound.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(notFound, os);
		} catch (JAXBException jaxb) {
			jaxb.printStackTrace();
			throw new WebApplicationException();
		}
	}	
}
