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
                ClassLoader.getSystemResourceAsStream("com/xml/DriversLicense.xml"));

        DriversLicense driversLicense = null;
        String content = null;

        while (xmlStreamReader.hasNext()) {
            int event = xmlStreamReader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if (xmlStreamReader.getLocalName().equals("DriversLicense")) {
                        driversLicense = new DriversLicense();

                        for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {

                            switch (xmlStreamReader.getAttributeLocalName(i)) {

                                case "status":
                                    driversLicense.setStatus(xmlStreamReader.getAttributeValue(i));
                                    break;
                            }
                        }
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    content = xmlStreamReader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:

                    switch (xmlStreamReader.getLocalName()) {
                        case "Number":
                            driversLicense.setNumber(Long.parseLong(content));
                            break;
                        case "FirstName":
                            driversLicense.setFirstName(content);
                            break;
                        case "LastName":
                            driversLicense.setLastName(content);
                            break;
                    }
            }
        }
        System.out.println(driversLicense.getStatus());
        System.out.println(driversLicense.getNumber());
        System.out.println(driversLicense.getFirstName());
        System.out.println(driversLicense.getLastName());

    }
}
