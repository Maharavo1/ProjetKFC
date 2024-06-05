package Projet1.KFC.model;

import java.time.LocalDateTime;

public class StockMovement {
    private LocalDateTime dateMovement;
    private String ingredientName;
    private String type;
    private double quantity;
    private int unitId;

    public StockMovement(LocalDateTime dateMovement, String ingredientName, String type , double quantity ,int unitId) {
        this.dateMovement = dateMovement;
        this.ingredientName = ingredientName;
        this.type = type;
        this.quantity=quantity;
        this.unitId = unitId;
    }

    public LocalDateTime getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(LocalDateTime dateMovement) {
        this.dateMovement = dateMovement;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
}
