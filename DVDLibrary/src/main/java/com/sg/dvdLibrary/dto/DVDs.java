/*
    Badon Delmotte
    10/19/20
 */
package com.sg.dvdLibrary.dto;

public class DVDs {
    private String title;
    private String releaseDate; // the year of release
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String usrRatingNote;
    
    // constuctor? the possible "identifier" of the class/DTO
    public DVDs (String title){
        this.title = title;
    }
    
    // the below are all properties of a film (or for the purpose of the assignment, a DVD)
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getReleaseDate(){
        return releaseDate;
    }  
    public void setReleaseDate(String releaseDate){
        this.releaseDate =  releaseDate;
    }
    
    public String getMPAArating(){
        return mpaaRating;
    }   
    public void setMPAArating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }
    
    public String getDirectorName(){
        return directorName;
    }   
    public void setDirectorName(String directorName){
        this.directorName = directorName;
    }
    
    public String getStudio(){
        return studio;
    }   
    public void setStudio(String studio){
        this.studio = studio;
    }
    
    public String getUsrRatingNote(){
        return usrRatingNote;
    }   
    public void setUsrRatingNote(String usrRatingNote){
        this.usrRatingNote = usrRatingNote;
    }
    
    
}
