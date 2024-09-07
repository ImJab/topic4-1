package com.gcu.data;

import com.gcu.business.DataAccessInterface;
import com.gcu.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersDataService implements DataAccessInterface {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public OrdersDataService(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public List<OrderModel> findAll() {
        String sql = "SELECT * FROM ORDERS";
        List<OrderModel> orders = new ArrayList<OrderModel>();
        try{
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while(srs.next()){
                orders.add(new OrderModel(srs.getLong("ID"),
                                            srs.getString("ORDER_NO"),
                                            srs.getString("PRODUCT_NAME"),
                                            srs.getFloat("PRICE"),
                                            srs.getInt("QUANTITY")));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public boolean create(Object o) {
        return false;
    }

    public boolean create(OrderModel order) {
        String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?,?,?,?)";

        try{
            int rows = jdbcTemplateObject.update(sql,
                    order.getOrderNo(),
                    order.getProductName(),
                    order.getPrice(),
                    order.getQuantity());
            return rows == 1 ? true : false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Object o) {
        return true;
    }

    @Override
    public boolean delete(Object o) {
        return true;
    }
}
