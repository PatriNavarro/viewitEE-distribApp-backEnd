package entities;

import entities.Screening;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-29T13:23:51")
@StaticMetamodel(Cinema.class)
public class Cinema_ { 

    public static volatile ListAttribute<Cinema, Screening> screenings;
    public static volatile SingularAttribute<Cinema, Long> cinemaId;
    public static volatile SingularAttribute<Cinema, String> name;
    public static volatile SingularAttribute<Cinema, String> location;

}