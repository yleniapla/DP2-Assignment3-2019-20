//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.24 at 07:13:08 PM CET 
//


package it.polito.dp2.BIB.sol3.service.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="items" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="journals" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="articles" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="books" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="shelves" type="{}MyBookshelves" minOccurs="0"/>
 *         &lt;element name="self" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "items",
    "journals",
    "articles",
    "books",
    "shelves",
    "self"
})
@XmlRootElement(name = "biblio")
public class Biblio {

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String items;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String journals;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String articles;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String books;
    protected MyBookshelves shelves;
    @XmlSchemaType(name = "anyURI")
    protected String self;

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItems(String value) {
        this.items = value;
    }

    /**
     * Gets the value of the journals property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJournals() {
        return journals;
    }

    /**
     * Sets the value of the journals property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJournals(String value) {
        this.journals = value;
    }

    /**
     * Gets the value of the articles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticles() {
        return articles;
    }

    /**
     * Sets the value of the articles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticles(String value) {
        this.articles = value;
    }

    /**
     * Gets the value of the books property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBooks() {
        return books;
    }

    /**
     * Sets the value of the books property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBooks(String value) {
        this.books = value;
    }

    /**
     * Gets the value of the shelves property.
     * 
     * @return
     *     possible object is
     *     {@link MyBookshelves }
     *     
     */
    public MyBookshelves getShelves() {
        return shelves;
    }

    /**
     * Sets the value of the shelves property.
     * 
     * @param value
     *     allowed object is
     *     {@link MyBookshelves }
     *     
     */
    public void setShelves(MyBookshelves value) {
        this.shelves = value;
    }

    /**
     * Gets the value of the self property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelf() {
        return self;
    }

    /**
     * Sets the value of the self property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelf(String value) {
        this.self = value;
    }

}
