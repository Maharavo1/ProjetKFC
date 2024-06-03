package Projet1.KFC.model;





import java.time.LocalDateTime;


public class IngredientMenu {
    public IngredientMenu(int ingredientMenuId, int menuId, int unitId, int ingredientId, double quantityRequired, String type, LocalDateTime dateMovement) {
        this.ingredientMenuId = ingredientMenuId;
        this.menuId = menuId;
        this.unitId = unitId;
        IngredientId = ingredientId;
        this.quantityRequired = quantityRequired;
        this.type = type;
        this.dateMovement = dateMovement;
    }

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
