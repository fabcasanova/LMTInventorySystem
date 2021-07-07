package phatsmalone.com.Main;

import javafx.beans.property.*;

import java.util.Date;

/*  Item
 *
 *  This class is for retrieving and modifying item data
 *
 */
public class Item {
    private StringProperty name;
    private IntegerProperty issueNumber;
    private SimpleObjectProperty<Date> date;
    private StringProperty description;
    private FloatProperty price;
    private IntegerProperty rarityScale;

    public Item(){
        this.name = new SimpleStringProperty();
        this.issueNumber = new SimpleIntegerProperty();
        this.date = new SimpleObjectProperty<>();
        this.description = new SimpleStringProperty();
        this.price = new SimpleFloatProperty();
        this.rarityScale = new SimpleIntegerProperty();
    }

    public void setName(String itemName) {
        this.name.set(itemName);
    }
    public String getName() {
        return name.get();
    }


    public void setName(String itemName) {
        this.name.set(itemName);
    }
    public String getName() {
        return name.get();
    }


    public void setName(String itemName) {
        this.name.set(itemName);
    }
    public String getName() {
        return name.get();
    }


    public void setName(String itemName) {
        this.name.set(itemName);
    }
    public String getName() {
        return name.get();
    }
}
