/*
    Badon Delmotte
    10/19/20
 */
package com.sg.dvdLibrary.ui;

import com.sg.dvdLibrary.dto.DVDs;
import java.util.List;

public class DVDLibraryView {
    private UserIO io;
    
    // the constructor
    public DVDLibraryView(UserIO io){
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("DVD Library");
        io.print("1. List DVDs in Your Collection");
        io.print("2. Add New DVD to Collection \n  (can also be used to update an existing DVD)");
        io.print("3. View Particular DVD Information");
        io.print("4. Remove DVD from Your Collection");
        io.print("5. Search for a DVD by Title"); // new
        io.print("6. Exit");
        
        return io.readInt("Please select from the above choices", 1, 6);            
    }
    
    // creating new dvds for the collection followed by the print statements for it
    public DVDs getNewDVDInfo() {
        String title = io.readString("Please enter movie title");
        String releaseDate = io.readString("Please enter the release date (year) of movie");
        String mpaaRating = io.readString("Please enter the movie MPAA Rating");
        String directorName = io.readString("Please enter the name of Director");
        String studio = io.readString("Please enter the name of the studio that made the movie (type n/a if unaware of studio)");
        String usrRatingNote = io.readString("Please enter a short note or personal rating for the film");
        
        DVDs currentDVD = new DVDs(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAArating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUsrRatingNote(usrRatingNote);
        
        return currentDVD;
    }
    
    public void displayCreateDVDBanner(){
        io.print("<--- DVD Creation Tool --->");
    }
    
    public void displayCreationSuccessBanner(){
        io.readString("DVD was successfully add to your collection. Hit enter to continue.");
    }
    
    // displaying list of added dvds and the print statements for it
    public void displayDVDList (List<DVDs> dvdList){
        for (DVDs currentDVD : dvdList) 
        {
            String dvdInfo = String.format("#%s : %s %s", 
                            currentDVD.getTitle(),
                            currentDVD.getReleaseDate(),
                            currentDVD.getMPAArating(),
                            currentDVD.getDirectorName(),
                            currentDVD.getStudio(),
                            currentDVD.getUsrRatingNote());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayDisplayAllDVDsBanner(){
        io.print("<--- Display All DVDs --->");
    }
    
    // prompts user to enter the title of the dvd (in order to display particular results
    public String getTitleChoice() {
        return io.readString("Please enter the Title of the DVD.");
    }
    
    // displays the details of a particular DVD and the "display dvd" banner 
    public void displayDVD (DVDs dvd) {
        if (dvd != null)
        {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAArating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUsrRatingNote());
            io.print("");
        }
        else
            io.print("You don't have that DVD.");
        
        io.readString("Please hit enter to continue");
    }
    
    public void displayDisplayDVDBanner(){
        io.print("<--- Display DVD --->");
    }
    
    public void displayRemoveDVDBanner() {
        io.print("<--- Remove DVD --->");
    }
    
    public void displayRemoveResult(DVDs dvdRecord) {
        if (dvdRecord != null)
            io.print("DVD successfully removed from collection.");
        else
            io.readString("No such DVD in your collection.");
        
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner(){
        io.print("Goodbye friend...");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command my friend...");
    }
    
    public void displayErrorMessage (String errorMsg) {
        io.print("<--- ERROR --->");
        io.print(errorMsg);
    }
    
    // used in the "search" function of the DVD collection
    public void displayDVDSearchBanner(){
        io.print("<--- DVD Search --->"); 
    }
    
    public void displaySearchedDVD(DVDs dvd){
        
        if (dvd != null)
        {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAArating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUsrRatingNote());
            io.print("");
        }
        else
            io.print("My apologies, but that DVD is not in your collection.");
        
        io.readString("Please hit enter to continue"); 
    }
    
    
}
