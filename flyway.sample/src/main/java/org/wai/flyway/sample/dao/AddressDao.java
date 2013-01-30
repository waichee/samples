package org.wai.flyway.sample.dao;

import org.springframework.stereotype.Repository;
import org.wai.flyway.sample.entity.Address;

@Repository
public class AddressDao extends BaseDao{

    public Address newAddress(){
        return getObjectContext().newObject(Address.class);
    }

}
