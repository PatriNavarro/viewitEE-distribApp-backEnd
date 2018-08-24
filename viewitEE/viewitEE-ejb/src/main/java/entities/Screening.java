/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.compositePK.ScreeningId;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Patri Navarro
 */
@Entity
@Table (name = "screenings")
public class Screening implements Serializable {

    private static final long serialVersionUID = 1L;
   @EmbeddedId
   private ScreeningId screeningId;
   
    @ManyToOne 
    @MapsId("movieId")
    private Movie movie;
    
    @ManyToOne 
    @MapsId("cinemaId")
    private Cinema cinema;
    
    @Column (name = "screening_date")
    @Temporal (TemporalType.DATE)
    private Calendar screeningDate;
    
    @Column (name = "screening_time")
    @Temporal (TemporalType.TIME)
    private Calendar screeningTime;

    

    public Calendar getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Calendar screeningDate) {
        this.screeningDate = screeningDate;
    }

    public Calendar getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Calendar screeningTime) {
        this.screeningTime = screeningTime;
    }
    
    
}
