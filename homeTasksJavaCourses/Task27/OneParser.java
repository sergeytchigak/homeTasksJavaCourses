package core;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CountriesDomParser {

	public List<Country> parse(Document document) throws FileNotFoundException, XMLStreamException {
		
		NodeList nodeList = document.getElementsByTagName("Country");
		
		List<Country> countries = new ArrayList<Country>();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			
			countries.add(getCountry(nodeList.item(i)));
		}
		
		return countries;
	}

	private static Country getCountry(Node node) {
		
		Country country = new Country();
		
		Element element = (Element) node;
	
		country.setName(getTagValue("Name", element));
		
		country.setDescription(getTagValue("Description", element));
		
		return country;
	}

}
