package sg.edu.nus.iss.app.workshop23.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.workshop23.models.OrderDetails;
import sg.edu.nus.iss.app.workshop23.repositories.OrderDetailsRepository;

@Service
public class OrderDetailsService {
    
    @Autowired
    private OrderDetailsRepository ordRepo;

    public OrderDetails getDiscountedOrderDetails(Integer orderId) {
        return ordRepo.getDiscountedOrderDetails(orderId);
    }
}
