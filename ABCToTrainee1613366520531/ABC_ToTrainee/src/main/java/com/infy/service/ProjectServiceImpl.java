package com.infy.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.ProjectDAO;
import com.infy.model.Project;
import com.infy.model.TeamMember;
import com.infy.validator.Validator;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO dao;

	@Override
	public Integer addProject(Project project) throws Exception {
		try {
			for(TeamMember t:project.getMemberList()) {
				Validator.validate(t);
			}
			return dao.addProject(project);
		}catch(Exception e) {
			throw e;
		}
	}

	
	@Override
	public List<Project> getProjectDetails(String technology) throws Exception {
		try {
			List<Project> projects=dao.getProjectDetails();
			List<Project> res=new ArrayList<>();
			for(Project p:projects) {
				if(p.getTechnologyUsed().equals(technology)) {
					res.add(p);
				}
			}
			if(projects.isEmpty()) {
				throw new Exception("Service.PROJECTS_NOT_FOUND");
			}
			return res;
		}catch(Exception e) {
			throw e;
		}
	}


	
}
