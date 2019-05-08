import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private String input;

    public InputParser(String input) {
        this.input = input;
    }

    public String getLocation() {
        String[] arraySentences = input.split(",");
        String locationSentence = arraySentences[0];
        String[] words = locationSentence.split(":");
        if(words.length > 1) {
            return words[1].trim();
        }
        return null;
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        String[] arraySentences = input.split(",");
        for (int j = 1; j < arraySentences.length - 1; j++) {
            String sentence = arraySentences[j];
            String[] words = sentence.split(" ");
            Item item = new Item();
            item.setQuantity(Integer.parseInt(words[1]));
            item.setPrice(Double.parseDouble(words[words.length - 1]));
            StringBuilder builder = new StringBuilder();
            for (int i = 2; i < words.length - 2; i++) {
                builder.append(words[i]);
            }
            item.setProduct(new Product(builder.toString()));
            items.add(item);
        }
        return items;
    }
}
