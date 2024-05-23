package Projet1.KFC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientsMenu {
    private int ingredientsMenuId;
    private int menuId;
    private int unitId;
    private int getIngredientsId;
    private double quantityRequired;

}
