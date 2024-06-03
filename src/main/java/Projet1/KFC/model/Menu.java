package Projet1.KFC.model;


public class Menu {
    private int menuId;



    private String menuName;
    private double priceSales; //prix de vente

    public Menu(int menuId, String menuName , double priceSales) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.priceSales = priceSales;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getPriceSales() {
        return priceSales;
    }

    public void setPriceSales(double priceSales) {
        this.priceSales = priceSales;
    }
}
