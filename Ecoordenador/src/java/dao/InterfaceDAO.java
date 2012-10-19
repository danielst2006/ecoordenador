/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author root
 */
public interface InterfaceDAO<T> {
    void save (T bean);
    void update (T bean);
    void remove (T bean);
    T getBean (Serializable codigo);
    List<T> list();
}
