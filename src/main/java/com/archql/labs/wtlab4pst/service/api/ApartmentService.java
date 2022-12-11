package com.archql.labs.wtlab4pst.service.api;

import com.archql.labs.wtlab4pst.entity.Apartment;
import com.archql.labs.wtlab4pst.entity.UserOrder;
import com.archql.labs.wtlab4pst.exeptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface ApartmentService {

    List<Apartment> retrieveApartamentByType(String type) throws ServiceException;

    List<Apartment> retrieveALLApartaments() throws ServiceException;


    Optional<Apartment> retrieveApartamentById(int apartament) throws ServiceException;

    List<Apartment> retrieveApartamentsByUserId(int userId) throws ServiceException;

    void removeApartmentById(int apartmentId) throws ServiceException;

    List<Apartment> retrieveApartamentByStatus(String status) throws ServiceException;

    List<Apartment> retrieveApartamentsByUserOrders(List<UserOrder> userOrders) throws ServiceException;


    boolean addNewApartment(String status,String type,String StringNumberOfRooms,
                            String StringApartmentNumber,String StringNumberOfBeds,String StringPrice,String photo) throws ServiceException;

    public void updateApartmentStatusById(int id,String status) throws ServiceException;


    boolean updateApartmentInformation(String StringId,String status,String type,String StringNumberOfRooms,
                                       String StringApartmentNumber,String StringNumberOfBeds,String StringPrice,String photo) throws ServiceException;
}
