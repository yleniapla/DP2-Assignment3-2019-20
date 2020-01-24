
package it.polito.dp2.BIB.sol3.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MyBookshelves complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MyBookshelves">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}MyBookshelfType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MyBookshelves", propOrder = {
    "myBookshelfType"
})
public class MyBookshelves {

    @XmlElement(name = "MyBookshelfType")
    protected List<MyBookshelfType> myBookshelfType;

    /**
     * Gets the value of the myBookshelfType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the myBookshelfType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMyBookshelfType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MyBookshelfType }
     * 
     * 
     */
    public List<MyBookshelfType> getMyBookshelfType() {
        if (myBookshelfType == null) {
            myBookshelfType = new ArrayList<MyBookshelfType>();
        }
        return this.myBookshelfType;
    }

}
