package Users;

import Product.Item;

class Requests {
    private Item ItemForEdit;
    private String NameForEdit;
    private String BrandForEdit;
    private int PriceForEdit;
    private String InfoForEdit;

    @Override
    public String toString() {
        return "NameForEdit: " + NameForEdit + '\n' +
                "BrandForEdit: " + BrandForEdit + '\n' +
                "PriceForEdit: " + PriceForEdit + '\n' +
                "InfoForEdit: " + InfoForEdit + '\n';
    }

    public Requests(Item itemForEdit, String nameForEdit, String brandForEdit, int priceForEdit, String infoForEdit) {
        ItemForEdit = itemForEdit;
        NameForEdit = nameForEdit;
        BrandForEdit = brandForEdit;
        PriceForEdit = priceForEdit;
        InfoForEdit = infoForEdit;
    }

    public Item getItemForEdit() {
        return ItemForEdit;
    }

    public void setItemForEdit(Item itemForEdit) {
        ItemForEdit = itemForEdit;
    }

    public String getNameForEdit() {
        return NameForEdit;
    }

    public void setNameForEdit(String nameForEdit) {
        NameForEdit = nameForEdit;
    }

    public String getBrandForEdit() {
        return BrandForEdit;
    }

    public void setBrandForEdit(String brandForEdit) {
        BrandForEdit = brandForEdit;
    }

    public int getPriceForEdit() {
        return PriceForEdit;
    }

    public void setPriceForEdit(int priceForEdit) {
        PriceForEdit = priceForEdit;
    }

    public String getInfoForEdit() {
        return InfoForEdit;
    }

    public void setInfoForEdit(String infoForEdit) {
        InfoForEdit = infoForEdit;
    }
}
