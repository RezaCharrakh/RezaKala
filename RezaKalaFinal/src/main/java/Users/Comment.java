package Users;

import Product.Item;

public class Comment {
    //---------------(Fields)---------------
    private Item Product;
    private String CommenterName;
    private String CommenterFamily;
    private String Text;

    //---------------(Constructor)---------------
    public Comment(String commenterName, String commenterFamily, String text, Item product) {
        setCommenterName(commenterName);
        setCommenterFamily(commenterFamily);
        setText(text);
        setProduct(product);
    }

    //---------------(Setters & Getters)---------------
    public String getCommenterName() {
        return CommenterName;
    }

    public void setCommenterName(String commenterName) {
        CommenterName = commenterName;
    }

    public String getCommenterFamily() {
        return CommenterFamily;
    }

    public void setCommenterFamily(String commenterFamily) {
        CommenterFamily = commenterFamily;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Item getProduct() {
        return Product;
    }

    public void setProduct(Item product) {
        Product = product;
    }

}
