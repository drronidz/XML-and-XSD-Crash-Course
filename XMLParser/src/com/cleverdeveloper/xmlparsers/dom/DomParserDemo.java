package com.cleverdeveloper.xmlparsers.dom;

/*
PROJECT NAME : xml_and_xsd_crash_course
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 1/2/2022 10:22 PM
*/

import com.cleverdeveloper.xmlparsers.dto.Address;
import com.cleverdeveloper.xmlparsers.dto.DriversLicense;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(DomParserDemo.class
                .getClassLoader().getSystemResourceAsStream("com/xml/DriversLicense.xml"));
        DriversLicense driversLicense = new DriversLicense();

        /* Reading the elements by name */
                                    /*              - BEGIN -              */
        NodeList numberList = document.getElementsByTagName("Number");
        Node numberItem = numberList.item(0);
        driversLicense.setNumber(Long.parseLong(numberItem.getTextContent()));

        NodeList firstNameList = document.getElementsByTagName("FirstName");
        Node firstNameItem = firstNameList.item(0);
        driversLicense.setFirstName(firstNameItem.getTextContent());

        NodeList lastNameList = document.getElementsByTagName("LastName");
        Node lastNameItem = lastNameList.item(0);
        driversLicense.setLastName(lastNameItem.getTextContent());
                                    /*              -  END -              */
        /* Reading the attribute values */
                                    /*              - BEGIN -              */
        Element documentElement = document.getDocumentElement();
        driversLicense.setStatus(documentElement.getAttribute("status"));
                                    /*              -  END -              */

        /* Reading the elements Hierarchically */
                                    /*              - BEGIN -              */
        NodeList addressList = document.getElementsByTagName("Address");
        Node addressNode = addressList.item(0);
        NodeList addressChildNodes = addressNode.getChildNodes();
        Address address = new Address();

        for (int i = 0; i < addressChildNodes.getLength(); i++) {
            Node item = addressChildNodes.item(i);

            if (item instanceof Element) {
                switch (item.getNodeName()) {
                    case "street":
                        address.setStreet(item.getTextContent());
                        break;
                    case "city":
                        address.setCity(item.getTextContent());
                        break;
                    case "state":
                        address.setState(item.getTextContent());
                        break;
                    case "country":
                        address.setCountry(item.getTextContent());
                        break;
                    case "zipcode":
                        address.setZipcode(item.getTextContent());
                        break;
                }
            }
        }

        driversLicense.setAddress(address);
                                    /*              -  END -              */


        System.out.println("####################### Displaying Information #######################");

        System.out.println("Status is : " + driversLicense.getStatus());
        System.out.println("Number is : " + driversLicense.getNumber());
        System.out.println("First name is : " + driversLicense.getFirstName());
        System.out.println("Last name is : " + driversLicense.getLastName());
        System.out.println(driversLicense.getAddress());
    }
}
