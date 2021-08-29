package phatsmalone.com.Main;

import javafx.beans.property.*;

/*  Item
 *
 *  This class is for retrieving and modifying item data.
 *
 */
public class Item {
    public StringProperty name;
    public StringProperty issueNumber;
    public SimpleStringProperty date;
    public StringProperty description;
    public FloatProperty price;
    public IntegerProperty rarityScale;

    /*  Item()
     *
     *  Constructor for class item.  Instantiates objects used from the UX.
     *
     */
    public Item(){
        this.name = new SimpleStringProperty();
        this.issueNumber = new SimpleStringProperty();
        this.date = new SimpleStringProperty();
        this.description = new SimpleStringProperty();
        this.price = new SimpleFloatProperty();
        this.rarityScale = new SimpleIntegerProperty();
    }

    /*  setName()
     *
     *  Sets the item name
     *
     */
    public void setName(String itemName) { this.name.set(itemName); }

    /*  getName()
     *
     *  Retrieves the itemname
     *
     */
    public String getName() { return name.get(); }

    /*  nameProperty()
     *
     *  retrieves name object
     *
     */
    public StringProperty nameProperty() { return name; }

    /*  setIssueNumber()
     *
     *  Sets issueNumber
     *
     */
    public void setIssueNumber(String issueNumber) {
        this.issueNumber.set(issueNumber);
    }

    /*  getIssueNumber()
     *
     *  Retrieves issueNumber
     *
     */
    public String getIssueNumber() { return issueNumber.get(); }

    /*  issueNumProperty()
     *
     *  Retrieves issueNumber object
     *
     */
    public StringProperty issueNumProperty() {
        return issueNumber;
    }

    /*  setDate()
     *
     *  Sets date object
     *
     */
    public void setDate(String date) {
        this.date.set(date);
    }

    /*  getDate()
     *
     *  Retrieves date object
     *
     */
    public String getDate() {


        return date.get();
    }

    /*  dateProperty()
     *
     *  Retrieves date property.
     *
     */
    public StringProperty dateProperty() {
        return date;
    }
    /*  setDescription()
     *
     *  sets description
     *
     */
    public void setDescription(String description) {
        this.description.set(description);
    }

    /*  getDescription()
     *
     *  retrieves description
     *
     */
    public String getDescription() {
        return description.get();
    }

    /*  descriptionProperty()
     *
     *  Retrieves description object.
     *
     */
    public StringProperty descriptionProperty() {
        return description;
    }

    /*  setPrice()
     *
     *  set price
     *
     */
    public void setPrice(float price) {
        this.price.set(price);
    }

    /*  getPrice()
     *
     *  Retrieve price
     *
     */
    public Float getPrice() {
        return price.get();
    }

    /*  priceProperty()
     *
     *  Retrieves price object
     *
     */
    public FloatProperty priceProperty() {
        return price;
    }

    /*  setRarityScale()
     *
     *  set rarityscale
     *
     */
    public void setRarityScale(int scale) {
        this.rarityScale.set(scale);
    }

    /*  getRarityScale()
     *
     *  retrieve rarityscale
     *
     */
    public int getRarityScale() {
        return rarityScale.get();
    }

    /*`rarityScaleProperty()
     *
     * Retrieves rarity scale property;
     *
     */
    public IntegerProperty rarityScaleProperty() {
        return rarityScale;
    }
}
