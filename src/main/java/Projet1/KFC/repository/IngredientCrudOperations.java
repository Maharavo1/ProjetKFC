package Projet1.KFC.repository;

import Projet1.KFC.db.DBConnection;
import Projet1.KFC.model.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class IngredientCrudOperations implements CrudOperations<Ingredient>{
    @Override
    public Ingredient findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ingredient ingredient = null;

        try {
            String sql = "SELECT * FROM ingredient WHERE ingredient_id = ?";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
              ingredient = new Ingredient(
                      resultSet.getInt("ingredient_id"),
                      resultSet.getInt("unit_id"),
                      resultSet.getString("name"),
                      resultSet.getDouble("ingredient_price"),
                      resultSet.getDouble("price")
              );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

        return ingredient;
    }

    @Override
    public List<Ingredient> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Ingredient> ingredients = new ArrayList<>();

        try {
            String sql = "SELECT * FROM ingredient";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                Ingredient ingredient = new Ingredient(
                        resultSet.getInt("ingredient_id"),
                        resultSet.getInt("unit_id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("ingredient_price"),
                        resultSet.getDouble("stock")
                );
                ingredients.add(ingredient);
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

        return ingredients;
    }

    @Override
    public Ingredient save(Ingredient toSave) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO ingredient (ingredient_id, unit_id, name, ingredient_price, stock) VALUES (?, ?, ?, ?, ?)";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, toSave.getIngredientId());
            preparedStatement.setInt(2, toSave.getUnitId());
            preparedStatement.setString(3, toSave.getName());
            preparedStatement.setDouble(4, toSave.getIngredientPrice());
            preparedStatement.setDouble(5, toSave.getStock());

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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return toSave;
    }

    @Override
    public Ingredient Update(Ingredient toUpdate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "UPDATE ingredient SET unit_id = ?, name = ?, ingredient_price = ?, stock = ? WHERE ingredient_id = ?";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, toUpdate.getUnitId());
            preparedStatement.setString(2, toUpdate.getName());
            preparedStatement.setDouble(3, toUpdate.getIngredientPrice());
            preparedStatement.setDouble(4, toUpdate.getStock());
            preparedStatement.setInt(5, toUpdate.getIngredientId());

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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return toUpdate;
    }
}
