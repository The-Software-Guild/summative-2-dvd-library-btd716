/*
    Badon Delmotte
    10/19/20
 */
package com.sg.dvdLibrary.dao;

public class DVDLibraryDAOException extends Exception {
    
    public DVDLibraryDAOException (String message) {
        super(message);
    }
    
    public DVDLibraryDAOException (String message, Throwable cause) {
        super(message, cause);
    }
    
}
