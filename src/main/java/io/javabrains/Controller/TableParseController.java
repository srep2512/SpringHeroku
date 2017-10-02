package io.javabrains.Controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.entity.Partei;
import io.javabrains.repositories.ParteiRepository;

@RestController
public class TableParseController {

	@Autowired
	ParteiRepository partein;
	
	@RequestMapping(value="/table", method = RequestMethod.POST)
	public Iterable getTable(@RequestBody String url) throws ParseException {
		String eles ="";
		Document doc = new Document("");
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String name = "";
		List<Partei> pl = new ArrayList();
		Elements el = doc.select("tbody");
		Elements el2 = el.select("tr");
		//String ret ="";
		for(Element x : el2) {
			//List<Node> n = x.childNodes();
			//n.forEach((no) -> System.out.println(no.toString()));
			//el2.hasAttr(arg0)
		
			Elements el3 = x.select("td[style=text-align:right]");
			if(el3.size() == 4) {
				long i = partein.count();
				
				Partei p = new Partei();
				Elements names = x.select("div.parteiname-with-parteifarbe");
				for(Element n : names) {if(n.text() != null) {
					p.setName(n.text());
					}
				}
				
			
				if(el3.get(0).text().isEmpty()) p.setAnzahlErst(0.0); 
				else
				p.setAnzahlErst(Double.parseDouble(el3.get(0).text())); 
				NumberFormat nf = NumberFormat.getInstance(Locale.FRANCE);	
			
				if(el3.get(1).text().isEmpty()) p.setStimmenanteilErst(0.0);
				else
				p.setStimmenanteilErst(nf.parse(el3.get(1).text()).doubleValue()); 
				
				if(el3.get(3).text().isEmpty()) p.setAnzahlZweit(0.0);
				else
				p.setAnzahlZweit(Double.parseDouble(el3.get(2).text()));
				
				if(el3.get(3).text().isEmpty()) p.setStimmenanteilZweit(0.0);
				else
				p.setStimmenanteilZweit(nf.parse(el3.get(3).text()).doubleValue()); 
				//el3.forEach((el3x) -> System.out.println(el3x.text()));
				pl.add(p);
				
			}
			
		}
		
		
		pl.forEach(x -> {
			long ct = partein.count();
		    Partei p = new Partei();
		    p.setID(ct);
		    p.setName(x.getName());
		    p.setAnzahlErst(x.getAnzahlErst());
		    p.setAnzahlZweit(x.getAnzahlZweit());
			
			partein.save(p);
			
		});
		pl.forEach(x -> System.out.println(x.getName() + ":"));
		
		
		return partein.findAll();
	}
	
	
}
