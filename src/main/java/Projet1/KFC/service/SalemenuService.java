package Projet1.KFC.service;

import Projet1.KFC.model.Ingredient;
import Projet1.KFC.model.IngredientMenu;
import Projet1.KFC.model.Menu;
import Projet1.KFC.repository.IngredientCrudOperations;
import Projet1.KFC.repository.IngredientMenuCrudOperations;
import Projet1.KFC.repository.MenuCrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalemenuService {
    @Autowired
    private IngredientMenuCrudOperations ingredientMenuCrudOperations;

     @Autowired
    private IngredientCrudOperations ingredientCrudOperations;

     @Autowired
    private MenuCrudOperations menuCrudOperations;

    public double saleOfMenu(List<IngredientMenu> ingred){
        for (IngredientMenu ingredientMenu : ingred){
            Ingredient ingredient = ingredientCrudOperations.findById(ingredientMenu.getIngredientId());
            if (ingredient.getStock() <  ingredientMenu.getQuantityRequired()){
                throw new RuntimeException("" +
                        "Insufficient Stock");
            }
        }
        double priceTotal = 0.00;
        for (IngredientMenu ingredientMenu : ingred){
            Menu menu = menuCrudOperations.findById(ingredientMenu.getMenuId());
            ingredientMenuCrudOperations.save(ingredientMenu);
            priceTotal += menu.getPriceSales();
        }
        return priceTotal;
    }}
