/*
    Badon Delmotte
    10/19/20
 */
package com.sg.dvdLibrary.dao;

import com.sg.dvdLibrary.dto.DVDs;
import java.util.*;
import java.io.*;

public class DVDLibraryDAOFileImp implements DVDLibraryDAO {
    
    public static final String DVD_FILE = "dvdlist.txt";
    public static final String DELIMITER = "::";
    
    private final Map<String, DVDs> dvdCollection = new HashMap<>();

    @Override
    public DVDs addDVDs(String title, DVDs dvd) throws DVDLibraryDAOException {
        loadDVD();
        DVDs newDVD = dvdCollection.put(title, dvd);
        try
        {
            writeDVD(dvdCollection);
        } catch (IOException e) 
        {
            throw new DVDLibraryDAOException ("ERROR");
        }
        return newDVD;
    }

    @Override
    public List<DVDs> getAllDVDs() throws DVDLibraryDAOException {
        loadDVD();
        return new ArrayList<DVDs>(dvdCollection.values());
    }

    @Override
    public DVDs getDVDs(String title) throws DVDLibraryDAOException {
        loadDVD();
        return dvdCollection.get(title);
    }

    @Override
    public DVDs removeDVDs(String title) throws DVDLibraryDAOException {
        loadDVD();
        DVDs removedDVD = dvdCollection.remove(title);
        try
        {
            writeDVD(dvdCollection);
        } catch (IOException e)
        {
            throw new DVDLibraryDAOException ("ERROR");
        }
        return removedDVD;
    }
    
    // used to search for a DVD; essentially the same as getDVDs (just differed in print statements)
    @Override
    public DVDs searchDVDs(String title) throws DVDLibraryDAOException {
        loadDVD();
                
        /*
        Scanner usrSearch = new Scanner(System.in);
        String usrSearchedDVD = usrSearch.nextLine();
        if (usrSearchedDVD == title)
        {}
        */   
        return dvdCollection.get(title);
    }
    
    private DVDs unmarshallDVD (String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        // index 0
        String title = dvdTokens[0];
        DVDs dvdFromFile = new DVDs(title);
        // index 1
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        // index 2
        dvdFromFile.setMPAArating(dvdTokens[2]);
        // index 3
        dvdFromFile.setDirectorName(dvdTokens[3]);
        // index 4
        dvdFromFile.setStudio(dvdTokens[4]);
        // index 5
        dvdFromFile.setUsrRatingNote(dvdTokens[5]);
        
        return dvdFromFile;   
    }
    
    private String marshallDVD (DVDs aDVD) {
        String dvdAsText = aDVD.getTitle() + DELIMITER;
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getMPAArating()+ DELIMITER;
        dvdAsText += aDVD.getDirectorName() + DELIMITER;
        dvdAsText += aDVD.getStudio() + DELIMITER;
        dvdAsText += aDVD.getUsrRatingNote() + DELIMITER;
        
        return dvdAsText;
    }
    
    private void loadDVD() throws DVDLibraryDAOException {
        Scanner dvdScanner;
        try
        {
            // this scanner reads the file
            dvdScanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) 
        {
            throw new DVDLibraryDAOException("Failed to load DVD information from file into memory.", e);
        }
        String currentLine;
        DVDs currentDVD;
        while (dvdScanner.hasNextLine())
        {
            currentLine = dvdScanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvdCollection.put(currentDVD.getTitle(), currentDVD);
        }
        dvdScanner.close();
    }
    
    private void writeDVD(Map<String, DVDs> dvdCollection) 
            throws DVDLibraryDAOException, IOException {
        PrintWriter dvdScanner;
        try
        {
            dvdScanner = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (FileNotFoundException e)
        {
            throw new DVDLibraryDAOException ("Failed to load DVD collection from memory to file.", e);
        }
        String currentLine;
        for (Map.Entry<String, DVDs> thisDVD: dvdCollection.entrySet())
        {
            dvdScanner.println(marshallDVD(thisDVD.getValue()));
        }
        dvdScanner.close();
    }
  
}
