package Projet1.KFC.model;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
public class IngredientMenu {
    private int ingredientMenuId;
    private int menuId;
    private int unitId;
    private int IngredientId;
    private double quantityRequired;
    private String type;
    private LocalDateTime dateMovement;

    public int getIngredientMenuId() {
        return ingredientMenuId;
    }

    public void setIngredientMenuId(int ingredientMenuId) {
        this.ingredientMenuId = ingredientMenuId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getIngredientId() {
        return IngredientId;
    }

    public void setIngredientId(int ingredientId) {
        IngredientId = ingredientId;
    }

    public double getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(double quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(LocalDateTime dateMovement) {
        this.dateMovement = dateMovement;
    }
}
