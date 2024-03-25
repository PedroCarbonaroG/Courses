package view;

import java.util.ArrayList;
import java.util.List;

import service.UtilityService;

import entities.Shape;
import entities.Circle;
import entities.Rectangle;

public class Prompt {

    public void startPrompt() {

        List<Object> myObjs = new ArrayList<>();
        List<Shape> myShapes = new ArrayList<>();
        List<Circle> myCircles = new ArrayList<>();
        List<Rectangle> myRectangles = new ArrayList<>();

        //SHAPES
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        //CIRCLES
        myCircles.add(new Circle(1.0));
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));

        //RECTANGLES
        myRectangles.add(new Rectangle(1.0, 2.0));
        myRectangles.add(new Rectangle(2.0, 3.0));
        myRectangles.add(new Rectangle(3.0, 4.0));

        //SAME METHOD TESTS
        System.out.println("Total shapes area: " + String.format("%.2f", UtilityService.totalArea(myShapes)));
        System.out.println("Total circle area: " + String.format("%.2f", UtilityService.totalArea(myCircles)));
        System.out.println("Total rectangle area: " + String.format("%.2f", UtilityService.totalArea(myRectangles)));

        //COPY TESTS
        UtilityService.copy(myShapes, myObjs);
        System.out.println("content: " + String.format("%.2f", UtilityService.totalArea(myObjs)));
        myObjs.clear();

        UtilityService.copy(myCircles, myObjs);
        System.out.println("content: " + String.format("%.2f", UtilityService.totalArea(myObjs)));
        myObjs.clear();

        UtilityService.copy(myRectangles, myObjs);
        System.out.println("content: " + String.format("%.2f", UtilityService.totalArea(myObjs)));
    }
}
