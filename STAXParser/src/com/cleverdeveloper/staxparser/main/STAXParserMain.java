package com.cleverdeveloper.staxparser.main;

/*
PROJECT NAME : xml_and_xsd_crash_course
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 1/4/2022 10:40 PM
*/

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class STAXParserMain {
    public static void main(String[] args) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(
                ClassLoader.getSystemResourceAsStream("com/cleverdeveloper/xml/DriversLicense.xml"));
    }
}
