package Projet1.KFC.repository;

import Projet1.KFC.db.DBConnection;
import Projet1.KFC.model.Ingredient;
import Projet1.KFC.model.IngredientMenu;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientMenuCrudOperations implements CrudOperations<IngredientMenu>{
    private  IngredientCrudOperations ingredientCrudOperations;

    @Autowired
    public IngredientMenuCrudOperations(IngredientCrudOperations ingredientCrudOperations){
        this.ingredientCrudOperations = ingredientCrudOperations;
    }


    @Override
    public IngredientMenu findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        IngredientMenu ingredientMenu = null;

        try {
            String sql = "SELECT * FROM ingredient_menu WHERE ingredient_menu_id = ?";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ingredientMenu = new IngredientMenu(
                        resultSet.getInt("ingredient_menu_id"),
                        resultSet.getInt("menu_id"),
                        resultSet.getInt("unit_id"),
                        resultSet.getInt("ingredient_id"),
                        resultSet.getDouble("quantity_required"),
                        resultSet.getString("type"),
                        resultSet.getTimestamp("date_movement").toLocalDateTime()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return ingredientMenu;
    }

    @Override
    public List<IngredientMenu> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<IngredientMenu> ingredientMenus = new ArrayList<>();

        try {
            String sql = "SELECT * FROM ingredient_menu";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                IngredientMenu ingredientMenu = new IngredientMenu(
                        resultSet.getInt("ingredient_menu_id"),
                        resultSet.getInt("menu_id"),
                        resultSet.getInt("unit_id"),
                        resultSet.getInt("ingredient_id"),
                        resultSet.getDouble("quantity_required"),
                        resultSet.getString("type"),
                        resultSet.getTimestamp("date_movement").toLocalDateTime()
                );
                ingredientMenus.add(ingredientMenu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return ingredientMenus;
    }

    @Override
    public IngredientMenu save(IngredientMenu toSave) {
      Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO ingredient_menu (ingredient_menu_id, menu_id, unit_id, ingredient_id, quantity_required, type, date_movement) VALUES (?, ?, ?, ?, ?, ?, ?)";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,toSave.getIngredientMenuId());
            preparedStatement.setInt(2,toSave.getMenuId());
            preparedStatement.setInt(3,toSave.getUnitId());
            preparedStatement.setInt(4,toSave.getIngredientId());
            preparedStatement.setDouble(5,toSave.getQuantityRequired());
            preparedStatement.setString(6,toSave.getType());
            preparedStatement.setTimestamp(7, java.sql.Timestamp.valueOf(toSave.getDateMovement()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                if (connection != null ){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return toSave;
        }

    @Override
    public IngredientMenu Update(IngredientMenu toUpdate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "UPDATE ingredient_menu SET menu_id = ?, unit_id = ?, ingredient_id = ?, quantity_required = ?, type = ?, date_movement = ? WHERE ingredient_menu_id = ?";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, toUpdate.getMenuId());
            preparedStatement.setInt(2, toUpdate.getUnitId());
            preparedStatement.setInt(3, toUpdate.getIngredientId());
            preparedStatement.setDouble(4, toUpdate.getQuantityRequired());
            preparedStatement.setString(5, toUpdate.getType());
            preparedStatement.setTimestamp(6, java.sql.Timestamp.valueOf(toUpdate.getDateMovement()));
            preparedStatement.setInt(7, toUpdate.getIngredientMenuId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return toUpdate;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "DELETE FROM ingredient_menu WHERE ingredient_menu_id = ?";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static double stockIngredients(IngredientMenu ingredientMenu){
        double stock = 0.0;
        if(ingredientMenu.getType().equals("entrer")){
            stock += ingredientMenu.getQuantityRequired();
        }
        if (ingredientMenu.getType().equals("sortie")){
            stock -= ingredientMenu.getQuantityRequired();
        }
        return stock;
    }

    public Ingredient updateStock(IngredientMenu ingredientMenu){
        double stock = stockIngredients(ingredientMenu);
        Ingredient ingredient = ingredientCrudOperations.findById(ingredientMenu.getIngredientId());
        Ingredient ingredientUpdateStock = new Ingredient(ingredient.getIngredientId() , ingredient.getUnitId() , ingredient.getName() , ingredient.getIngredientPrice() ,ingredient.getUnitId() , stock );
        ingredientCrudOperations.Update(ingredientUpdateStock);
        return ingredientUpdateStock;
    }

}
