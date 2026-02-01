import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllPossibleRecipesfromGivenSupplies {

    static class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> recipyDict = new HashMap<>();
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        for (int i = 0; i < recipes.length; i++) {
            recipyDict.put(recipes[i], i);
        }
        Map<String, Set<String>> recipeToIngredients = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            addAllIngridients(recipeToIngredients, recipyDict, recipes[i], ingredients);
        }

        List<String> result = new ArrayList<>();

        for (var recipy: recipes) {
            if (suppliesSet.containsAll(recipeToIngredients.get(recipy))) {
                result.add(recipy);
            }
        }

        return result;
    }

    private void addAllIngridients(Map<String, Set<String>> recipeToIngredients, Map<String, Integer> recipyDict, String recipy, List<List<String>> ingredients) {
        var ingredientsList = ingredients.get(recipyDict.get(recipy));
        recipeToIngredients.putIfAbsent(recipy, new HashSet<>());
        for (var ingredient: ingredientsList) {
            if (!recipeToIngredients.containsKey(ingredient)) {
                recipeToIngredients.get(recipy).add(ingredient);
            } else {
                addAllIngridients(recipeToIngredients, recipyDict, ingredient, ingredients);
                recipeToIngredients.get(recipy).addAll(recipeToIngredients.get(ingredient));
            }
        }
    }
}

}
