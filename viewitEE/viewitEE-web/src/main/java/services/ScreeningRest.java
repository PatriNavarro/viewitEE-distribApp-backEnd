package services;

import entities.Screening;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sessionbeans.dao.ScreeningFacadeLocal;
import utils.CalendarConverterLocal;

@Path("/screenings")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScreeningRest {
    @Context 
    private UriInfo uriInfo;
    @PersistenceContext (unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;
    @EJB
    private ScreeningFacadeLocal screeningFacade;
    @EJB
    private CalendarConverterLocal calendarConverter;
    
    @GET
    public List<Screening> getAll(){
        return screeningFacade.findAll();
    }
    
    @GET
    @Path("/{movieId}")
    public List<Screening> getScreening(@PathParam("movieId") Long movieId){
        System.out.println("Received input parameter:" + movieId);
        return screeningFacade.getScreenings(movieId);
    }
    
    @GET
    @Path("/{movieId}/{date}")
    public List<Screening> getScreening(@PathParam("movieId") Long movieId, 
                                        @PathParam("date") String sdate) throws ParseException{
        System.out.println("Received input parameter:" + movieId + " and " + sdate);
        Calendar date_calendar = calendarConverter.stringToCalendar(sdate,"yyyy-MM-dd");
        return screeningFacade.getScreenings(movieId,date_calendar);
    }
    
}
