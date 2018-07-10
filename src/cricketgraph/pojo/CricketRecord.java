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
public class CricketRecord {
    private String First;
    private String Last;
    private int year;
    private String format;
    private int score;

    public CricketRecord() {
    }

    public CricketRecord(String First, String Last, int year, String format, int score) {
        this.First = First;
        this.Last = Last;
        this.year = year;
        this.format = format;
        this.score = score;
    }

    public String getFirst() {
        return First;
    }

    public void setFirst(String First) {
        this.First = First;
    }

    public String getLast() {
        return Last;
    }

    public void setLast(String Last) {
        this.Last = Last;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
