/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author root
 */
public class GeraBanco {
    public static void main(String args []) {
        AnnotationConfiguration conf = new AnnotationConfiguration();
        conf.configure("database/hibernate.cfg.xml");
        SchemaExport se = new SchemaExport(conf);
        se.drop(true, true);
        se.create(true, true);
    }

}
