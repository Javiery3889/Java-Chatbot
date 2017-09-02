/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Javiery
 */
public class Questions {

    String qn = "";
    String[] ans = new String[3];

    //Constructor invoked to create new Questions object    
    public Questions(String q, String[] a) {
        qn = q;
        ans = a;
    } //end of Questions

    public String getQnString() {
        return qn;
    } //end of getQnString

    public String getansString() {
        int decider = (int) (Math.random() * 3);
        return ans[decider];

    } //end of getansString

}// end of class
