public class Dish {
    private int foodAmount;

    public Dish(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean tryToEat(int amountToEat) {
        if (amountToEat <= foodAmount) {
            foodAmount -= amountToEat;
            return true;
        } else {
            return false;
        }

    }

    public void addFood(int amount) {
        foodAmount += amount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
