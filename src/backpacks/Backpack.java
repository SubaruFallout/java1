package backpacks;

import exceptons.MyException;
import shapes.*;

import java.util.*;

public class Backpack extends Shape {
    List<Shape> shapes = new ArrayList<>();
    int capacity;

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    public void tryAddShape(Shape shape) {
        if (getVolume() + shape.getVolume() > capacity) {
            throw new MyException();
        }
        shapes.add(shape);
        this.sort();
    }

    public void removeByIndex(int index) {
        shapes.remove(index);
    }

    public double getVolume() {
        double volume = 0;
        for (Shape shape : shapes) {
            volume += shape.getVolume();
        }
        return volume;
    }

    public void sort() {
        shapes.sort(Comparator.comparingDouble(Shape::getVolume).reversed());
    }

    public List<String> getShapesInfo() {
        List<String> shapesInfo = new ArrayList<>();
        for (Shape shape : shapes) {
            shapesInfo.add(shape.toString());
        }
        return shapesInfo;
    }

    @Override
    public String toString() {
        return "Backpack total volume = " + getVolume() + ". Max volume = " + capacity;
    }
}
