/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans.dao;

import entities.Screening;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Patri Navarro
 */
@Local
public interface ScreeningFacadeLocal {

    void create(Screening screening);

    void edit(Screening screening);

    void remove(Screening screening);

    Screening find(Object id);

    List<Screening> findAll();

    List<Screening> findRange(int[] range);

    int count();
    
}
