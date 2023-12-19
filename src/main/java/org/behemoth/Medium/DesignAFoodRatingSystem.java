package org.behemoth.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class DesignAFoodRatingSystem {
    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};


        FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
        String param_1 = obj.highestRated("japanese");
        obj.changeRating("ramen", 1);
        String param_2 = obj.highestRated("japanese");
        System.out.println(param_1);
        System.out.println(param_2);


    }

    private static class FoodRatings {

        private final Map<String, PriorityQueue<Food>> map = new HashMap<>();
        private final Map<String, String> mapForCuisinesAndFood = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                mapForCuisinesAndFood.put(foods[i], cuisines[i]);
                if (!map.containsKey(cuisines[i])) {
                    PriorityQueue<Food> queue = new PriorityQueue<>();
                    map.put(cuisines[i], queue);
                    queue.add(new Food(cuisines[i], foods[i], ratings[i]));
                }
                else {
                    map.get(cuisines[i]).add(new Food(cuisines[i], foods[i], ratings[i]));
                }
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = mapForCuisinesAndFood.get(food);
            map.get(cuisine).removeIf(e -> e.getName().equals(food));
            map.get(cuisine).add(new Food(cuisine, food, newRating));
        }

        public String highestRated(String cuisine) {
            return Objects.requireNonNull(map.get(cuisine).peek()).getName();
        }

        private static class Food implements Comparable<Food>{
            String cuisine;
            String name;
            int rating;

            Food(String cuisine, String name, int rating){
                this.cuisine = cuisine;
                this.name = name;
                this.rating = rating;
            }

            @Override
            public int compareTo(Food food){
                return Integer.compare(food.rating, this.rating);
            }

            @Override
            public boolean equals(Object o){
                if (this == o) return true;
                if (o == null || this.getClass() != o.getClass()) return false;
                Food f = (Food) o;
                return Objects.equals(this.cuisine, f.cuisine) && Objects.equals(this.name, f.name);
            }

            @Override
            public int hashCode(){
                return Objects.hash(this.cuisine, this.name);
            }

            public String getCuisine() {
                return cuisine;
            }

            public void setCuisine(String cuisine) {
                this.cuisine = cuisine;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }
        }
    }
}
