import java.util.HashMap;

public class CanSpell {
    //Write a method named CanSpell
    public static boolean canSpell(String tiles, String word) {

        HashMap<Character, Integer> tileFrequency = new HashMap<>();
        for (char tile : tiles.toCharArray()) {
            tileFrequency.put(tile, tileFrequency.getOrDefault(tile, 0) + 1);
        }

        // Can the tiles spell the word
        for (char letter : word.toCharArray()) {
            if (!tileFrequency.containsKey(letter) || tileFrequency.get(letter) <= 0) {
                return false;
            }
            tileFrequency.put(letter, tileFrequency.get(letter) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        //Two strings as parameters
        String tiles = "quijibo";
        String input = "jib";

        if (canSpell(tiles, input)) {
            System.out.println(input + "' can be spelled using the tiles.");
        } else {
            System.out.println(input + "' cannot be spelled using the tiles.");
        }
    }
}
