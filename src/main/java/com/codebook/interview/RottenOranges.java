package com.codebook.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        System.out.println(
                orangeRotting(
                        new int[][]{
                                {2, 1, 1},
                                {0, 1, 1},
                                {1, 0, 1}
                        }
                )
        );

        System.out.println(
                orangeRotting(
                        new int[][]{
                                {0, 2}
                        }
                )
        );
    }

    private static int orangeRotting(int[][] grid) {
        GridCell rottenOrangeCell = null;
        for(int rowIndex = 0; rowIndex < grid.length; rowIndex++){
            for(int columnIndex = 0; columnIndex < grid[0].length; columnIndex++){
                if(grid[rowIndex][columnIndex] == 2){
                    rottenOrangeCell = new GridCell(rowIndex, columnIndex);
                }
            }
        }

        int time = bfs(grid, rottenOrangeCell);

        return isFreshOrangeLeft(grid) ? -1 : time;
    }

    private static boolean isFreshOrangeLeft(int[][] grid){
        for(int rowIndex = 0; rowIndex < grid.length; rowIndex++){
            for(int columnIndex = 0; columnIndex < grid[0].length; columnIndex++){
                if(grid[rowIndex][columnIndex] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    private static int bfs(int[][] grid, GridCell rottenOrangeCell) {
        int time = -1;
        Queue<GridCell> queue = new LinkedList<>();
        grid[rottenOrangeCell.rowIndex][rottenOrangeCell.columnIndex] = 3;
        queue.add(rottenOrangeCell);
        int levelCellCount = 1;
        int nextLevelCellCount = 0;
        while (!queue.isEmpty()) {
            GridCell gridCell = queue.remove();
            levelCellCount--;
            List<GridCell> nearbyGridCells = getNearbyGridCells(grid, gridCell.rowIndex, gridCell.columnIndex);
            nextLevelCellCount = nextLevelCellCount + nearbyGridCells.size();
            if(levelCellCount == 0){
                levelCellCount = nextLevelCellCount;
                nextLevelCellCount = 0;
                time++;
            }

            for(GridCell cell: nearbyGridCells){
                grid[cell.rowIndex][cell.columnIndex] = 3;
            }
            queue.addAll(nearbyGridCells);
        }

        return time;
    }

    private static List<GridCell> getNearbyGridCells(int[][] grid, int rowIndex, int columnIndex) {
        List<GridCell> nearByCells = new LinkedList<>();

        if (rowIndex + 1 < grid.length && grid[rowIndex + 1][columnIndex] != 3 && grid[rowIndex + 1][columnIndex] != 0) {
            nearByCells.add(new GridCell(rowIndex + 1, columnIndex));
        }

        if(rowIndex - 1 >= 0 && grid[rowIndex -1][columnIndex] != 3 && grid[rowIndex -1][columnIndex] != 0){
            nearByCells.add(new GridCell(rowIndex -1, columnIndex));
        }

        if(columnIndex + 1 < grid[0].length && grid[rowIndex][columnIndex + 1] != 3 && grid[rowIndex][columnIndex + 1] != 0){
            nearByCells.add(new GridCell(rowIndex, columnIndex + 1));
        }

        if(columnIndex - 1 >= 0 && grid[rowIndex][columnIndex - 1] != 3 && grid[rowIndex][columnIndex - 1] != 0){
            nearByCells.add(new GridCell(rowIndex, columnIndex - 1));
        }

        return nearByCells;
    }

    static class GridCell {
        int rowIndex;
        int columnIndex;

        public GridCell(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }
}
