package sg.edu.nus.iss.app.workshop23.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.workshop23.models.OrderDetails;
import static sg.edu.nus.iss.app.workshop23.repositories.Queries.*;


@Repository
public class OrderDetailsRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OrderDetails getDiscountedOrderDetails(Integer orderId) {
        // prevent inheritance
        final List<OrderDetails> ords = new LinkedList<>();
        // perfrom the query
        final SqlRowSet results = jdbcTemplate.queryForRowSet(SQL_SECLECT_ORDER_DETAILS_DISCOUNT, orderId);

        while (results.next()) {
            ords.add(OrderDetails.create(results));
        }
        return ords.get(0);
    }
}
