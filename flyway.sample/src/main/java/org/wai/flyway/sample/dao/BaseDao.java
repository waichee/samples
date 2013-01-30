package org.wai.flyway.sample.dao;


import org.apache.cayenne.BaseContext;
import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.query.SelectQuery;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public abstract class BaseDao {

    public List<? extends CayenneDataObject>  getAllObjects (Class<? extends CayenneDataObject> clazz) {
        SelectQuery select1 = new SelectQuery(clazz);
        return BaseContext.getThreadObjectContext().performQuery(select1);
    }

    public ObjectContext getObjectContext(){
       return BaseContext.getThreadObjectContext();

    }
    public void save(){
        getObjectContext().commitChanges();
    }

    public void delete(CayenneDataObject dataObject){
        getObjectContext().deleteObject(dataObject);
    }

    public void deleteObjects(Collection<? extends CayenneDataObject> dataObjectCollection) {
        getObjectContext().deleteObjects(dataObjectCollection);
    }

}
