package entities.embeddables;

import enumerations.Genre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-25T12:07:24")
@StaticMetamodel(MovieDetails.class)
public class MovieDetails_ { 

    public static volatile SingularAttribute<MovieDetails, Integer> duration;
    public static volatile SingularAttribute<MovieDetails, Genre> genre;
    public static volatile SingularAttribute<MovieDetails, String> sinopsis;

}