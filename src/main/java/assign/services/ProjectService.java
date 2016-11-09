package assign.services;

import assign.domain.Project;

public interface ProjectService {

	public Project addProject(Project c) throws Exception;
	public Project getProject(int projectId) throws Exception;
    public Project getProject_correct(int projectId) throws Exception;

}
