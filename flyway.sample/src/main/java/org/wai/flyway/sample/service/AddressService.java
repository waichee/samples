package org.wai.flyway.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wai.flyway.sample.dao.AddressDao;
import org.wai.flyway.sample.entity.Address;

import java.util.List;

@Service
public class AddressService{

    @Autowired
    private AddressDao addressDao;

    public Address createNewAddress(){
        return addressDao.newAddress();
    }

    public List<Address> findAllAddres(){
        return (List<Address>) addressDao.getAllObjects(Address.class);
    }

    public void save(){
        addressDao.save();
    }

    public void deleteAddress(Address address) {
        addressDao.delete(address);
    }

}
