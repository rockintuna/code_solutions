package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution149 {
    public int maxPoints(int[][] points) {
        if ( points.length == 1 ) {
           return 1;
        }
        Map<Function, Integer> functionMap = new HashMap<>();

        for (int i = 0; i < points.length-1; i++) {
            for (int j = i+1; j < points.length; j++) {
                double inclination = getInclination(points[i], points[j]);
                double yIntercept = getYIntercept(inclination, points[i][0], points[i][1]);

                Function function = new Function(inclination, yIntercept, points[i][0]);

                if ( !functionMap.containsKey(function) ) {
                    functionMap.put(function, 0);
                }
            }
        }

        for (int i = 0; i < points.length; i++) {
            for (Function function : functionMap.keySet()) {
                if ( function.onTheLine(points[i]) ) {
                    functionMap.replace(function, functionMap.get(function) + 1);
                }
            }
        }

        return functionMap.values().stream().max(Integer::compareTo).get();
    }

    private double getInclination(int[] point1, int[] point2) {
        double incX = point2[0] - point1[0];
        double incY = point2[1] - point1[1];
        return incY/incX;
    }

    private double getYIntercept(double inclination, int x, int y) {
        return y - inclination * x;
    }

    public static void main(String[] args) {
        Solution149 solution149 = new Solution149();
        int[] point1 = {-6, -1};
        int[] point2 = {3, 1};
        int[] point3 = {12, 3};
//        int[] point4 = {4, 1};
//        int[] point5 = {2, 3};
//        int[] point6 = {1, 4};
//        System.out.println(solution149.maxPoints(new int[][]{point1, point2, point3, point4, point5, point6}));
        System.out.println(solution149.maxPoints(new int[][]{point1, point2}));
    }
}

class Function {
    double inclination;
    double yIntercept;

    double xIntercept;

    public Function(double inclination, double yIntercept, int x) {
        this.inclination = inclination;
        this.yIntercept = yIntercept;
        if ( Double.isInfinite(inclination) ) {
            xIntercept = x;
        }
    }

    public boolean onTheLine(int[] point) {
        int yValue = point[1];
        int xValue = point[0];

        if ( Double.isInfinite(inclination) ) {
            return xIntercept == xValue;
        }
        double v = Math.round(inclination * xValue + yIntercept * 1000);
        System.out.println(v);
        return (double) yValue == v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Function function = (Function) o;
        return Double.compare(function.inclination, inclination) == 0 && Double.compare(function.yIntercept, yIntercept) == 0 && Double.compare(function.xIntercept, xIntercept) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inclination, yIntercept, xIntercept);
    }
}