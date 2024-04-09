package utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<float[]> vertices = new ArrayList<>();
    private List<int[]> faces = new ArrayList<>();
    private float posX = 0, posY = 0, posZ = 0;
    private float rotX = 0, rotY = 0, rotZ = 0;
    private float scale = 1.0f;
    private Color color;
    private String name;

    // Add a constructor that includes the name parameter
    public Model(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    // Add a toString method that returns the model's name
    @Override
    public String toString() {
        return name;
    }

    // Constructor with parameters
    public Model(List<float[]> vertices, List<int[]> faces) {
        this.vertices = vertices;
        this.faces = faces;
    }

    // Getters

    public float[] getColor() {
        return new float[] {
                this.color.getRed() / 255.0f,   // Red component
                this.color.getGreen() / 255.0f, // Green component
                this.color.getBlue() / 255.0f   // Blue component
        };
    }
    public List<float[]> getVertices() {
        return vertices;
    }

    public List<int[]> getFaces() {
        return faces;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getPosZ() {
        return posZ;
    }

    public float getRotX() {
        return rotX;
    }

    public float getRotY() {
        return rotY;
    }

    public float getRotZ() {
        return rotZ;
    }

    public float getScale() {
        return scale;
    }

    // Setters
    public void setVertices(List<float[]> vertices) {
        this.vertices = vertices;
    }

    public void setFaces(List<int[]> faces) {
        this.faces = faces;
    }

    public void translate(float dx, float dy, float dz) {
        this.posX += dx;
        this.posY += dy;
        this.posZ += dz;
    }

    public void rotate(float dRotX, float dRotY, float dRotZ) {
        this.rotX += dRotX;
        this.rotY += dRotY;
        this.rotZ += dRotZ;
    }

    public void scale(float scaleFactor) {
        this.scale *= scaleFactor;
    }

}
