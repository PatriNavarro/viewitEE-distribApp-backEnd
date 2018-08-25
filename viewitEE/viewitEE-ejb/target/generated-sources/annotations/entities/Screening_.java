package entities;

import entities.Cinema;
import entities.Movie;
import entities.compositePK.ScreeningId;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-25T12:07:24")
@StaticMetamodel(Screening.class)
public class Screening_ { 

    public static volatile SingularAttribute<Screening, Movie> movie;
    public static volatile SingularAttribute<Screening, Calendar> screeningDate;
    public static volatile SingularAttribute<Screening, Calendar> screeningTime;
    public static volatile SingularAttribute<Screening, ScreeningId> screeningId;
    public static volatile SingularAttribute<Screening, Cinema> cinema;

}