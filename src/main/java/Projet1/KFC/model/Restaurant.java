package Projet1.KFC.model;


public class Restaurant {
    private int restaurantId;
    private String restaurantLocation;

    public Restaurant(int restaurantId, String restaurantLocation) {
        this.restaurantId = restaurantId;
        this.restaurantLocation = restaurantLocation;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }
}
