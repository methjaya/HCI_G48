package utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvailableFurnitures {
    public static List<FurnitureItem> items = new ArrayList<>();

    static {
        items.add(new FurnitureItem("Chair 1", "assets/chairs/chair.jpg", Arrays.asList(new Color(78, 54, 54), new Color(218, 160, 109)), Arrays.asList("30x30x45", "15x15x30"), "chair","resources/Objects/chairs/chair.obj"));
        items.add(new FurnitureItem("Chair 2", "assets/chairs/chair2.jpg", Arrays.asList(new Color(78, 54, 54), new Color(218, 160, 109)), Arrays.asList("45x45x75", "60x60x45"), "chair","resources/Objects/chairs/chair2.obj"));
        items.add(new FurnitureItem("Table 1", "assets/tables/table.png", Arrays.asList(new Color(78, 54, 54), new Color(218, 160, 109)), Arrays.asList("90x60x180", "120x60x200"), "table","resources/Objects/tables/table.obj"));
        items.add(new FurnitureItem("Table 2", "assets/tables/table2.png", Arrays.asList(new Color(78, 54, 54), new Color(218, 160, 109)), Arrays.asList("45x45x75", "60x60x45"), "table","resources/Objects/tables/table2.obj"));
        items.add(new FurnitureItem("Wardrobe 1", "assets/wardrobes/wardrobe1.png", Arrays.asList(new Color(78, 54, 54), new Color(218, 160, 109)), Arrays.asList("90x60x180", "120x60x200"), "wardrobe","resources/Objects/wardrobes/wardrobe1.obj"));
        items.add(new FurnitureItem("Wardrobe 2", "assets/wardrobes/wardrobe2.png", Arrays.asList(new Color(78, 54, 54), new Color(218, 160, 109)), Arrays.asList("90x60x180", "120x60x200"), "wardrobe","resources/Objects/wardrobes/wardrobe2.obj"));
    }
}