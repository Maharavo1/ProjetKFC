package Projet1.KFC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {
    private int ingredientsId;
    private int unitId;
    private String name;
    private double ingredientsPrice;
}
