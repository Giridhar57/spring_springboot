package com.infy;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infy.model.Project;
import com.infy.model.TeamMember;
import com.infy.service.ProjectService;


@SpringBootApplication
public class AbcToTraineeApplication implements CommandLineRunner {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
    private Environment environment;
	
    public static final Log LOGGER = LogFactory.getLog(AbcToTraineeApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AbcToTraineeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		addProject();
		getProjectDetails();
	}

	public void addProject() {
		Project p=new Project();
		p.setProjectName("Spring Boot Project");
		p.setCost(50000);
		p.setTeamSize(25);
		p.setTechnologyUsed("Java Spring Boot");
		
		List<TeamMember> listofMembers = new ArrayList<>();
		TeamMember member1 = new TeamMember();
		member1.setEmployeeId(722666);
		member1.setEmployeeName("Ron");
		member1.setSkills("Java,BI");
		member1.setDesignation("SC");
		
		TeamMember member2 = new TeamMember();
		member2.setEmployeeId(722665);
		member2.setEmployeeName("Jack");
		member2.setSkills("Java,BI");
		member2.setDesignation("SC");

		listofMembers.add(member1);
		listofMembers.add(member2);

		p.setMemberList(listofMembers);
		try {
			String successMessage = environment.getProperty("userinterface.projectAddedSuccess");
			LOGGER.info(successMessage+" "+projectService.addProject(p));
		}catch(Exception e) {
			LOGGER.info(e);
		}
	}

	public void getProjectDetails() {
		try {
			List<Project> res=projectService.getProjectDetails("BI");
			if(res.isEmpty()) {
				throw new Exception("No projects found for the specified technology.");
			}
			for(Project p:res) {
				LOGGER.info("TEAM MEMBER DETAILS");
				LOGGER.info("MemberId  MemberName  Skills");
				LOGGER.info("###################################");
				for(TeamMember m:p.getMemberList()) {
					LOGGER.info(m.getEmployeeId()+"   "+m.getEmployeeName()+"   "+m.getSkills());
				}
			}
		}catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
	}

}
