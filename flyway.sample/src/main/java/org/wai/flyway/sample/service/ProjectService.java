package org.wai.flyway.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wai.flyway.sample.dao.ProjectDao;
import org.wai.flyway.sample.entity.Project;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public Project createNewProject(){
        return projectDao.newProject();
    }

    public List<Project> findAllProject(){
        return (List<Project>) projectDao.getAllObjects(Project.class);
    }

    public void save(){
        projectDao.save();
    }

    public void deleteProject(Project project) {
        projectDao.delete(project);
    }
}
