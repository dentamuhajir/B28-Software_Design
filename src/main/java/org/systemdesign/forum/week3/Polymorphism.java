package org.systemdesign.forum.week3;

public class Polymorphism {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 7);
        rectangle.area();
        Triangle triangle = new Triangle(15, 2);
        triangle.area();
    }
}

class Shape{
    public void area() {};
}

class Rectangle extends Shape {
    public String name = "Rectangle";
    private int length = 0;
    private int width = 0;
    private int area;

    Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    public void area() {
        setArea(getWidth() * getLength());
        System.out.println(name + " area : " + getArea());
    }
}

class Triangle extends Shape {
    public String name = "Triangle";
    private int base = 0;
    private int height = 0;
    private Double area;

    Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getArea() {
        return area;
    }

    public void area() {
        setArea(0.5 * getBase() * getHeight());
        System.out.println(name + " area : " + getArea());
    }
}
