/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Test {
    public static void main (String [] args)
    {
        Date d= new Date(2013,1,1);
        Utilisateur u=new Utilisateur("Ala","werghmi",11896334,d,"rue khaled abi kais tunis","login","ala.werghemi@esprit.tn","new3245");
    }
}
