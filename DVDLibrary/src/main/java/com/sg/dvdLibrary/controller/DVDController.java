/*
    Badon Delmotte
    10/19/20
 */
package com.sg.dvdLibrary.controller;

import com.sg.dvdLibrary.dao.DVDLibraryDAO;
import com.sg.dvdLibrary.dao.DVDLibraryDAOException;
import com.sg.dvdLibrary.dto.DVDs;
import com.sg.dvdLibrary.ui.DVDLibraryView;
import java.util.List;

public class DVDController {
    private DVDLibraryView view;
    private DVDLibraryDAO dao;
    
    // constructor...but why?
    public DVDController (DVDLibraryDAO dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while(keepGoing)
            {
                menuSelection = getMenuSelection();
                
                switch(menuSelection) 
                {
                    case 1:
                        displayDVDList();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        displayDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;                    
                    case 5:
                        searchDVD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDLibraryDAOException e)
        {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
    // creates new dvd record
    private void createDVD() throws DVDLibraryDAOException {
        view.displayCreateDVDBanner();
        DVDs newDVD = view.getNewDVDInfo();
        dao.addDVDs(newDVD.getTitle(), newDVD);
        view.displayCreationSuccessBanner();
    }
    // outputs the list of dvds in collection
    private void displayDVDList() throws DVDLibraryDAOException {
        view.displayDisplayAllDVDsBanner();
        List<DVDs> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }
    
    private void displayDVD() throws DVDLibraryDAOException {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVDs dvd = dao.getDVDs(title);
        view.displayDVD(dvd);
    }
    
    private void removeDVD() throws DVDLibraryDAOException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVDs removedDVD = dao.removeDVDs(title);
        view.displayRemoveResult(removedDVD);
    }
    
    private void searchDVD() throws DVDLibraryDAOException {
        view.displayDVDSearchBanner();
        String title = view.getTitleChoice();
        DVDs dvd = dao.searchDVDs(title);
        view.displaySearchedDVD(dvd);
    }
    
    
}
