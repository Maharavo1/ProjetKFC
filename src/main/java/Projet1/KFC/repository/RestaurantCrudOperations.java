package Projet1.KFC.repository;

import Projet1.KFC.db.DBConnection;
import Projet1.KFC.model.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantCrudOperations implements CrudOperations <Restaurant>{
    @Override
    public Restaurant findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Restaurant restaurant = null;

        try {
            String sql = "SELECT * FROM restaurant WHERE restaurant_id = ?";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                restaurant = new Restaurant(
                        resultSet.getInt("restaurant_id"),
                        resultSet.getString("restaurant_location")
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

        return restaurant;
    }

    @Override
    public List<Restaurant> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Restaurant> restaurants = new ArrayList<>();

        try {
            String sql = "SELECT * FROM restaurant";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant(
                        resultSet.getInt("restaurant_id"),
                        resultSet.getString("restaurant_location")
                );
                restaurants.add(restaurant);
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

        return restaurants;
    }

    @Override
    public Restaurant save(Restaurant toSave) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO restaurant (restaurant_id, restaurant_location) VALUES (?, ?)";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, toSave.getRestaurantId());
            preparedStatement.setString(2, toSave.getRestaurantLocation());

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
    public Restaurant Update(Restaurant toUpdate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "UPDATE restaurant SET restaurant_location = ? WHERE restaurant_id = ?";
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, toUpdate.getRestaurantLocation());
            preparedStatement.setInt(2, toUpdate.getRestaurantId());

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

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "DELETE FROM restaurant WHERE restaurant_id = ?";
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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
