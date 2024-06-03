package Projet1.KFC.model;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private int menuId;
    private String menuName;
    private double priceSales; //prix de vente

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
