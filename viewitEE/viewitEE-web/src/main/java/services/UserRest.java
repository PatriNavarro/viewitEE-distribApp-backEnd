package services;

import entities.OrderDetail;
import entities.TotalOrder;
import entities.User;
import interceptors.LoggerInterceptor;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sessionbeans.dao.UserFacadeLocal;
import sessionbeans.singleton.TheLogger;
import sessionbeans.stateful.OrderLocal;

@Path("/user")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes (MediaType.APPLICATION_JSON)
@Interceptors(LoggerInterceptor.class)
public class UserRest {
    @Context 
    private UriInfo uriInfo;
    @PersistenceContext (unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;
    @EJB
    private UserFacadeLocal userFacade;
    @EJB
    private OrderLocal order;
    
    @GET
    //@Path("/all")
    public List<User> getAllUsers(){
        return userFacade.findAll();
    }
    
    @POST
    @Path("/register")
    public User createUser(User user){
        System.out.println(user.getEmail());
        System.out.println(userFacade.checkEmail(user.getEmail()));
        if(!userFacade.checkEmail(user.getEmail()).isEmpty()){
            TheLogger.getLog().warning("There is already a user registered with this email");
            return null;
        }
        userFacade.create(user);
        return user;
    }
    
    @POST
    @Path("/login")
    public User loginUser(User user){
        System.out.println(user.getEmail());
        System.out.println(userFacade.checkEmail(user.getEmail()));
        if(userFacade.checkEmail(user.getEmail()).isEmpty()){
            TheLogger.getLog().warning("There is no user registered with this email");
            return null;
        }
        if(userFacade.checkPassword(user.getPassword()).isEmpty()){
            TheLogger.getLog().warning("Wrong password");
            return null;
        }
        //Start a new session for this user
        Long id = userFacade.getIdFromEmail(user.getEmail());
        order.initOrder(id);
        return user;
    }
    
    @POST
    @Path("/logout")
    public User logoutUser(User user) {
        order.remove();
        return user;
    }
    
    @POST
    @Path("/order/add")
    public OrderDetail addOrderDetail (OrderDetail od){
        od.setOrderDetailPrice(od.getProduct().getUnitPrice()*od.getQuantity());
        order.addOrderDetail(od);
        return od;
    }
    
    
    @GET
    @Path("order/list")
    public List<OrderDetail> getOrderList () {
        return order.getList();
    }
    
    @GET
    @Path("/order/purchase")
    public void purchaseOrder(){
        //return order.purchase();
        order.purchase();
    }
    /*
    @POST
    @Path("/order/createOrder")
    public TotalOrder createOrder(TotalOrder totalOrder){
        return order.createOrder(totalOrder);
    }*/
}
