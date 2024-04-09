package utils;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class FurnitureItem {
    private List<Color> colors = new ArrayList<>();
    private List<String> dimentions = new ArrayList<>();
    private String name;
    private String imgPath;
    private String mdlPath;
    private String type;


    public FurnitureItem(String name, String imgPath, List<Color> colors, List<String> dimensions, String type, String mdlPath) {
        this.name = name;
        this.imgPath = imgPath;
        this.colors = colors;
        this.dimentions = dimensions;
        this.mdlPath = mdlPath;
        this.type = type;
    }

    public List<Color> getColors() {
        return colors;
    }

    public List<String> getDimensions() {
        return dimentions;
    }

    public String getName() {
        return name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getType() {
        return type;
    }

    public String getMdlPath() {
        return mdlPath;
    }
}
