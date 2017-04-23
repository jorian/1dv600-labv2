// Use this file to write and read the xml file.
// http://www.journaldev.com/1234/jaxb-tutorial-example-to-convert-object-to-xml-and-xml-to-object
// javax.xml.bind is added as a part of the sdk from java7 and forward.
package lnu.dao;

import lnu.models.catalog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class booksDAO {
    private static String XMLLocation = "src/main/java/lnu/resources/books.xml";

    // This method converts the XML stored in XMLLocation to a catalog object and returns the catalog to the caller.
    public static catalog XMLToObject() {
        try {
            JAXBContext context = JAXBContext.newInstance(catalog.class);
            Unmarshaller un = context.createUnmarshaller();
            return (catalog) un.unmarshal(new File(XMLLocation));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    return null;
    }

    // Converts a catalog to XML:
    public static void ObjectToXML(catalog listOfBooks) {
        try {
            JAXBContext context = JAXBContext.newInstance(catalog.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(listOfBooks, new File(XMLLocation));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    // For testing purposes, it should be able to change the location of the XML.
    public static void setXMLLocation(String location) {
        XMLLocation = location;
    }

    String getXMLLocation() {
        return XMLLocation;
    }
}