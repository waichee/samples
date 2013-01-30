package org.wai.flyway.sample.dao;

import org.springframework.stereotype.Repository;
import org.wai.flyway.sample.entity.Project;

@Repository
public class ProjectDao extends BaseDao{

    public Project newProject(){
        return getObjectContext().newObject(Project.class);
    }
}
