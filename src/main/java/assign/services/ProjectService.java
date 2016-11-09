package assign.services;

import assign.domain.Project;

public interface ProjectService {

	public Project addProject(Project c) throws Exception;
	public Project getProject(int projectId) throws Exception;

}
