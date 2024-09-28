package com.codebook.daily;

import java.util.*;

public class NearestPoints {

    public static void main(String[] args) {

        System.out.println(
                findNearestPoint(
                        Arrays.asList(new Point(3, 3), new Point(5, -1), new Point(-2, 4)),
                        new Point(0, 0),
                        2
                )
        );
    }

    private static List<Point> findNearestPoint(List<Point> points, Point centre, int count){
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(
                (Point point1, Point point2) ->
                {
                    int point1DistanceSquare = getDistanceSquare(centre, point1);
                    int point2DistanceSquare = getDistanceSquare(centre, point2);
                    return point1DistanceSquare - point2DistanceSquare;
                }
        );
        priorityQueue.addAll(points);
        List<Point> result = new LinkedList<>();
        for(int index = 0; index < count; index++){
            result.add(priorityQueue.remove());
        }
        return result;
    }

    private static int getDistanceSquare(Point point1, Point point2){
        int xDistance = point1.x - point2.x;
        int yDistance = point1.y - point2.y;
        return (xDistance * xDistance) + (yDistance * yDistance);
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
