/*
    Badon Delmotte
    10/19/20
 */
package com.sg.dvdLibrary.dao;

import com.sg.dvdLibrary.dto.DVDs;
import java.util.List;

public interface DVDLibraryDAO {
    
    DVDs addDVDs (String title, DVDs dvd) throws DVDLibraryDAOException;
    
    List<DVDs> getAllDVDs() throws DVDLibraryDAOException;
    
    DVDs getDVDs (String title) throws DVDLibraryDAOException;
    
    DVDs removeDVDs (String title) throws DVDLibraryDAOException;

    DVDs searchDVDs (String title) throws DVDLibraryDAOException;
  
}



















