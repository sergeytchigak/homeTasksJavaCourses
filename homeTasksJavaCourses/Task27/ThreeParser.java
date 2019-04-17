package core;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class CountriesStaxParser {
	private static final String CODE = "Code";
	private static final String NAME = "Name";
	private static final String DESCRIPTION = "Description";
	private static final String ID = "id";
	private static final String COUNTRY = "Country";
	private Country country;
	List<Country> countries = new ArrayList<>();

	private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException {
		if (xmlEvent.isStartElement()) {
			StartElement startElement = xmlEvent.asStartElement();
			if (isTagNameEqual(startElement, COUNTRY)) {
				country = new Country();
				Attribute attribute = startElement.getAttributeByName(new QName(ID));
				if (attribute != null) {
					country.setId(Integer.parseInt(attribute.getValue()));
				}
			} 
		}
	}

	private void proceedEndElement(XMLEvent xmlEvent) {
		if (xmlEvent.isEndElement()) {
			EndElement endElement = xmlEvent.asEndElement();
			if (endElement.getName().getLocalPart().equals(COUNTRY)) {
				countries.add(country);
			}
		}
	}

}
