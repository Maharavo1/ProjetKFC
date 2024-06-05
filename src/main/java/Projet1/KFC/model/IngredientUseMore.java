package Projet1.KFC.model;

public class IngredientUseMore {
    private int ingredientId;
    private String ingredientName;
    private String menuUseMore;
    private double quantitySpent;
    private int unitId;

    public IngredientUseMore(int ingredientId, String ingredientName, String menuUseMore, double quantitySpent, int unitId) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.menuUseMore = menuUseMore;
        this.quantitySpent = quantitySpent;
        this.unitId = unitId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getMenuUseMore() {
        return menuUseMore;
    }

    public void setMenuUseMore(String menuUseMore) {
        this.menuUseMore = menuUseMore;
    }

    public double getQuantitySpent() {
        return quantitySpent;
    }

    public void setQuantitySpent(double quantitySpent) {
        this.quantitySpent = quantitySpent;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
}
