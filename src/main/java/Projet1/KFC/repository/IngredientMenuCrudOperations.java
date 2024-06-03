package Projet1.KFC.repository;

import Projet1.KFC.db.DBConnection;
import Projet1.KFC.model.IngredientMenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IngredientMenuCrudOperations implements CrudOperations<IngredientMenu>{
    @Override
    public IngredientMenu findById() {
        return null;
    }

    @Override
    public List<IngredientMenu> findAll() {
        return null;
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
}
