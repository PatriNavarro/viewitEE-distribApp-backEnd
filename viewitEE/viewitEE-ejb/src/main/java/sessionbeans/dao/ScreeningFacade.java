/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.dao;

import entities.Screening;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Patri Navarro
 */
@Stateless
public class ScreeningFacade extends AbstractFacade<Screening> implements ScreeningFacadeLocal {

    @PersistenceContext(unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ScreeningFacade() {
        super(Screening.class);
    }
    
    @Override
    public List<Screening> getScreenings(Long movieId){
       /* //create an ejbql expression
      String ejbQL = "SELECT * FROM viewit.screenings\n" +
                     "WHERE movie_id = :movieId \n";
      //create query
      Query query = em.createQuery(ejbQL); 
      //execute the query
      return query.getResultList();*/
      
      TypedQuery<Screening> query = em.createNamedQuery("getScreeningsForMovie",Screening.class);
      query.setParameter("movieId", movieId);
      return query.getResultList();
       
    }
    
    public List<Screening> getScreenings(Long movieId, Calendar date){
        /* //create an ejbql expression
      String ejbQL = "SELECT * FROM viewit.screenings\n" +
                     "WHERE movie_id = :movieId \n"+
                     "AND  screening_date = :date";
      //create query
      Query query = em.createQuery(ejbQL);
      //execute the query
      return query.getResultList();*/
        
        
    TypedQuery<Screening> query = em.createNamedQuery("getScreeningsForMovieAndDate", Screening.class);
    query.setParameter("movieId", movieId);
    query.setParameter("date", date);
    return query.getResultList();
    }
    
    
}
