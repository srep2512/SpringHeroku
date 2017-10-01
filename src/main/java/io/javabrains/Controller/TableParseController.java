package io.javabrains.Controller;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableParseController {

	
	@RequestMapping(value="/table", method = RequestMethod.POST)
	public String getTable(@RequestBody String url) {
		String eles ="";
		Document doc = new Document("");
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> pnamen = new ArrayList<>();
		ArrayList<String> zahlen = new ArrayList<>();
		
		String title = doc.title();
		Element element = doc.select("table").get(0);
		//Get first Table of HTML
		
		Elements rows = doc.getElementsByTag("tbody");
		/*
		for (int i = 2; i <= rows.size(); i++) { //first row is the col names so skip it.
		    //Get Parteiname
			Element parteiname = rows.select("span").get(i);
			
			//Name Speichern in Array
			pnamen.add(parteiname.html());
			
			//Sammle Children
			
					    
		    eles += parteiname.html() + i;
		    	    
		    
		}*/
		
		
		Element tabelle = rows.get(0);
		
		//Alle TR's
		for(Element el : tabelle.select("tr")) {
			
			//Alle Td's in TR
			for(Element el2 : el.select("td")) {
			//FailFormat aber wenigstens kommt was raus
			//if(el2.hasText())					
			//eles += el2.text();
			
		    //Nur Parteien!!! in spans -.-
			eles += el2.select("span").not("[class]").text() + "\n";
			
			//Nur Zahlen
			eles += el2.getElementsByIndexEquals(4).text() + "\n";
			
				
			}
		}
			
		
		
		
		
		
		
		
		return eles;
	}
}
