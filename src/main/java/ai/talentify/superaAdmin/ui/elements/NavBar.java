package ai.talentify.superaAdmin.ui.elements;


import java.util.HashMap;
import java.util.Map;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;

public class NavBar{
    private static NavBar single_instance = null;
    MenuBar navbar = new MenuBar(); 

    private NavBar() 
    { 
      // This is the logic where we will add different items to menu bar 
    	
    	// A top-level menu item that opens a submenu
    	MenuItem drinks = navbar.addItem("Home", null, null);
    	MenuItem courses = navbar.addItem("Courses", null, null);
    	MenuItem License_Management = navbar.addItem("License Management", null, null);
    	MenuItem ClassRoom_Management = navbar.addItem("ClassRoom Management", null, null);
    	MenuItem Assets_Management = navbar.addItem("Assets Management", null, null);
    	MenuItem Users_Management = navbar.addItem("Users Management", null, null);
    	MenuItem Talentify_Users = navbar.addItem("Talentify Users", null, null);
    } 
    
   
    public static NavBar getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new NavBar(); 
  
        return single_instance; 
    }


	public MenuBar getMenuBar() {
		// TODO Auto-generated method stub
		return navbar;
	} 
   
}