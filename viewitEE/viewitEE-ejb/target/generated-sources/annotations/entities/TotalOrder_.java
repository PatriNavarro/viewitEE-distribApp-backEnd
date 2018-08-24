package entities;

import entities.OrderDetail;
import entities.User;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-25T00:53:31")
@StaticMetamodel(TotalOrder.class)
public class TotalOrder_ { 

    public static volatile ListAttribute<TotalOrder, OrderDetail> orderDetails;
    public static volatile SingularAttribute<TotalOrder, Double> total;
    public static volatile SingularAttribute<TotalOrder, Calendar> createdDate;
    public static volatile SingularAttribute<TotalOrder, Long> orderId;
    public static volatile SingularAttribute<TotalOrder, Long> orderDetail;
    public static volatile SingularAttribute<TotalOrder, User> user;

}