package com.cleverdeveloper.xmlparsers.sax;

/*
PROJECT NAME : xml_and_xsd_crash_course
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 1/2/2022 11:16 PM
*/

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXParserMain {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();

        SAXHandler handler = new SAXHandler();
        parser.parse(ClassLoader.getSystemResourceAsStream("com/xml/DriversLicense.xml"), handler);

        System.out.println("####################### Displaying Information #######################");

        System.out.println("Status is : " + handler.getDriversLicense().getStatus());
        System.out.println("Number is : " + handler.getDriversLicense().getNumber());
        System.out.println("First name is : " + handler.getDriversLicense().getFirstName());
        System.out.println("Last name is : " + handler.getDriversLicense().getLastName());
        System.out.println(handler.getDriversLicense().getAddress());
    }
}
