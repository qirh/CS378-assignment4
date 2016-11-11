package assign.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import assign.domain.Project;


public class ProjectServiceImpl implements ProjectService {

	String dbURL;
	String dbHost;
	String dbUsername = "";
	String dbPassword = "";
	DataSource ds;

	// DB connection information would typically be read from a config file.
	public ProjectServiceImpl(String dbHost, String dbUsername, String dbPassword) {
		
		this.dbHost = dbHost;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
		
		this.dbURL = "jdbc:mysql://" + 
				 		this.dbHost + "/cs378_" +
				 		this.dbUsername;
		
		ds = setupDataSource();
	}
	
	public DataSource setupDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername(this.dbUsername);
        ds.setPassword(this.dbPassword);
        ds.setUrl(this.dbURL);
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }
	
	public Project addProject(Project p) throws Exception {
		Connection conn = ds.getConnection();
		
		String insert = "INSERT INTO Projects(name, description) VALUES(?, ?)";
		PreparedStatement stmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
		
		stmt.setString(1, p.getName());
		stmt.setString(2, p.getDescription());
		
		int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0) 
            throw new SQLException("Creating project failed, no rows affected.");
        
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        
        if (generatedKeys.next())
        	p.setId(generatedKeys.getInt(1));
        else 
            throw new SQLException("Creating project failed, no ID obtained.");
        
        conn.close();
		return p;
	}
    public Project getProject(int id) throws Exception {
		String query = "select * from Projects where id=?";
		System.out.println("here");
		Connection conn = ds.getConnection();
		System.out.println("here2");
		PreparedStatement s = conn.prepareStatement(query);
		s.setString(1, String.valueOf(id));
		System.out.println("here3");
		ResultSet r = s.executeQuery();
		System.out.println("here4");
		
		if (!r.next()) {
		    return null;
		}
		System.out.println("here5");
		Project p = new Project();
		p.setDescription(r.getString("description"));
		p.setName(r.getString("name"));
		p.setId(r.getInt("id"));
		System.out.println("here6, project name = " + p.getName());
		return p;
    }

}
