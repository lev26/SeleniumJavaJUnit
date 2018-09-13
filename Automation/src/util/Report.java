package util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Report

{
	public String HTMLContent;
	public String FileToSave;
	
	// Constructor builds the start of HTML
	public Report (String fileToSave) throws FileNotFoundException {
		 // If file does not exist - create
		 FileToSave = fileToSave;

         HTMLContent ="<html><head>";
         HTMLContent+="<title>Equivalent HTML</title>";
         HTMLContent+="</head><body>";
         HTMLContent+= "<h2 style=\"text-align: center;\">Execution Time : "+ LocalDateTime.now().toString() +"</h2>\r\n" + 
         		"<table style=\"margin-left: auto; margin-right: auto;\">";
         
         HTMLContent+= "<tr> <th>Info </th> <th>Result</th> </tr>";
	}
	
	
    public void reportToHTML(String description, String result) {

     try {
            // Add in description and result to HTMLContent variable by amending it
    	 if(result == "Fail") {
    		 HTMLContent += "<tr><td>"+description+"</td><td><span style=\"color: #ff0000;\">"+result+"</span></td></tr>";
    	 }
    	 else{
    		 HTMLContent += "<tr><td>"+description+"</td><td><span style=\"color: #68f702;\">"+result+"</span></td></tr>";
    	 
    	 }
	    }
	
	    catch (Exception e) {
	    	
	    	}
    }
    
    public void FinalizeFile() {
    	// Close the HTML Elements
    	HTMLContent += "</table></body>";
    	
    	//Print and save to file
        try (PrintWriter out = new PrintWriter(FileToSave)) {
            out.println(HTMLContent);
            
        }
        catch(Exception e) {
        	
        }
    }
}