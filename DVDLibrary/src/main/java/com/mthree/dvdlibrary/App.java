/*
    Badon Delmotte
    10/19/20
 */
package com.mthree.dvdlibrary;

import com.sg.dvdLibrary.controller.DVDController;
import com.sg.dvdLibrary.dao.DVDLibraryDAO;
import com.sg.dvdLibrary.dao.DVDLibraryDAOFileImp;
import com.sg.dvdLibrary.ui.DVDLibraryView;
import com.sg.dvdLibrary.ui.UserIO;
import com.sg.dvdLibrary.ui.UserIOConsoleImp;

public class App {
    public static void main(String[] args){
        UserIO myIo = new UserIOConsoleImp();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDAO myDAO = new DVDLibraryDAOFileImp();
        DVDController controller = new DVDController(myDAO, myView);      
        controller.run();
    }
}
