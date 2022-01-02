package com.cleverdeveloper.xmlparsers.sax;

/*
PROJECT NAME : xml_and_xsd_crash_course
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 1/2/2022 11:04 PM
*/

import com.cleverdeveloper.xmlparsers.dto.DriversLicense;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

    private DriversLicense driversLicense;
    private String content;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("DriversLicense")) {
            setDriversLicense(new DriversLicense());
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch (qName) {
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

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

    public DriversLicense getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(DriversLicense driversLicense) {
        this.driversLicense = driversLicense;
    }
}
