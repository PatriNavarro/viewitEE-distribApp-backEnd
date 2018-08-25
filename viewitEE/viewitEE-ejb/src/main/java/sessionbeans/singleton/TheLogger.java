
package sessionbeans.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class TheLogger {
    private String status;
    private Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    @PostConstruct
    void init() {
        status = "Ready";
        System.out.println(status);
        
        LOG.log(Level.INFO,"Logger ready too!");
    }
    
    public Logger getLog() {
        return LOG;
    }
    
}
