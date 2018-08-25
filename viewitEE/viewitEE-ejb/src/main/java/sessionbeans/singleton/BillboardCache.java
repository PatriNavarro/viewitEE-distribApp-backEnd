package sessionbeans.singleton;

import entities.Movie;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import sessionbeans.dao.ScreeningFacadeLocal;

@Singleton
@Startup
public class BillboardCache {
    
    @EJB
    private ScreeningFacadeLocal screeningFacade;
    
    private static List<Movie> billboardCache;
   
    @PostConstruct
    void init(){
        resetBillboardCache();
    }
    
    public static List<Movie> getBillboardCache() {
        return billboardCache;
    }
    
    public void resetBillboardCache(){
       Calendar today = Calendar.getInstance();
       billboardCache = screeningFacade.getScreeningMovies(today);
    }
}
