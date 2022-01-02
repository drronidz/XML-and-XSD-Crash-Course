package com.cleverdeveloper.xmlparsers.dom;

/*
PROJECT NAME : xml_and_xsd_crash_course
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 1/2/2022 10:22 PM
*/

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicence.xml"));
    }
}
