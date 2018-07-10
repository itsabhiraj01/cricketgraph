/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cricketgraph.pojo;

/**
 *
 * @author ABHIRAJ
 */
public class CricketArgs {
    private String first;
    private String format;
    private int year;

    public CricketArgs(String first, String format, int year) {
        this.first = first;
        this.format = format;
        this.year = year;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
