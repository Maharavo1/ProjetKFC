package Projet1.KFC.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private int ingredientId;
    private int unitId;
    private String name;

    public double getIngredientPrice() {
        return ingredientPrice;
    }

    public void setIngredientPrice(double ingredientPrice) {
        this.ingredientPrice = ingredientPrice;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    private double ingredientPrice;
    private double stock;

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }
}
