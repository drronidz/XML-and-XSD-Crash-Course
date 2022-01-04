package com.cleverdeveloper.staxparser.main;

/*
PROJECT NAME : xml_and_xsd_crash_course
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 1/4/2022 10:40 PM
*/

import com.cleverdeveloper.staxparser.dto.DriversLicense;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class STAXParserMain {
    public static void main(String[] args) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(
                ClassLoader.getSystemResourceAsStream("com/cleverdeveloper/xml/DriversLicense.xml"));

        DriversLicense driversLicense = null;
        String content = null;

        while (xmlStreamReader.hasNext()) {
            int event = xmlStreamReader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if(xmlStreamReader.getLocalName().equals("DriverLicence")) {
                        driversLicense = new DriversLicense();
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    content = xmlStreamReader.getText();
                    break;
            }
        }
    }
}
