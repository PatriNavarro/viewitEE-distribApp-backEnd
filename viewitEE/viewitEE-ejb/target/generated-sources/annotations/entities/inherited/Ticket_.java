package entities.inherited;

import entities.Product_;
import enumerations.TicketType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-26T11:23:36")
@StaticMetamodel(Ticket.class)
public class Ticket_ extends Product_ {

    public static volatile SingularAttribute<Ticket, TicketType> ticketType;

}