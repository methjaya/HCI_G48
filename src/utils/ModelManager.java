package utils;

import utils.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelManager {
    public static List<Model> models = new ArrayList<>();
    public static int selectedModelIndex = -1;

    public static float halfWidth = 2f ;
    public static float halfDepth =  1f ;
    public static float floorHeight = -0.11f;

    public static String floorMaterialPath = "resources/dark floor.jpg";

}
