package com.cleverdeveloper.xmlparsers.sax;

/*
PROJECT NAME : xml_and_xsd_crash_course
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 1/2/2022 11:04 PM
*/

import com.cleverdeveloper.xmlparsers.dto.Address;
import com.cleverdeveloper.xmlparsers.dto.DriversLicense;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.management.Attribute;

public class SAXHandler extends DefaultHandler {

    private DriversLicense driversLicense;
    private Address address;
    private String content;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("DriversLicense")) {
            setDriversLicense(new DriversLicense());

            // Retrieving attributes using SAX PARSER ...
            if (attributes.getValue("status") != null) {
                driversLicense.setStatus(attributes.getValue("status"));
            }
        }

        if (qName.equals("Address")) {
            setAddress(new Address());
            driversLicense.setAddress(address);
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
            case "street":
                driversLicense.getAddress().setStreet(content);
                break;
            case "city":
                driversLicense.getAddress().setCity(content);
                break;
            case "state":
                driversLicense.getAddress().setState(content);
                break;
            case "country":
                driversLicense.getAddress().setCountry(content);
                break;
            case "zipcode":
                driversLicense.getAddress().setZipcode(content);
                break;

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DriversLicense getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(DriversLicense driversLicense) {
        this.driversLicense = driversLicense;
    }
}
