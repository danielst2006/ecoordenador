/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 *
 * @author root
 */
public class Testes {
    public static void main(String args []) {
        //SimpleDateFormat formatISO = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        DateTime dataInicial = new DateTime(2012, 11, 24, 16, 0, 0, 0);
        System.out.println("Data inicial: "+dataInicial.toString());
        
        DateTime dataFinal = new DateTime(2012, 11, 24, 20, 0, 0, 0);
        System.out.println("Data final: "+dataFinal.toString());
       
        
        Duration dur = new Duration(dataInicial, dataFinal);
        
        if(dataFinal.getHourOfDay()<=18) {
            System.out.println("Valor lancado: "+dataFinal.toString());
        } else {
            DateTime calc = dataFinal.minus(dur);
            System.out.println("Duracao: "+calc.toString());
        }


    }

}
