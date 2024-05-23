package Projet1.KFC.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Offers {
    private int offersId;
    private int restaurantId;
    private int menuId;
}
