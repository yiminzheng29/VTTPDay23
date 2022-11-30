package sg.edu.nus.iss.app.workshop23.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.workshop23.models.OrderDetails;
import sg.edu.nus.iss.app.workshop23.services.OrderDetailsService;

@RestController
@RequestMapping(path="/order/total", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsRESTController {

    // http://localhost:8080/order/total/30
    
    @Autowired
    private OrderDetailsService ordSvc;

    @GetMapping(path="{orderId}")
    public ResponseEntity<String> getAllCustomer(@PathVariable Integer orderId) {
        OrderDetails ord = ordSvc.getDiscountedOrderDetails(orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ord.toJson().toString());
    }
    
}
