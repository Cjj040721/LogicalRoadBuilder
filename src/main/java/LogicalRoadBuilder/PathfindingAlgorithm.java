package LogicalRoadBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * This class implements a pathfinding algorithm using Breadth-First Search (BFS) on a 2D array.
 * The algorithm finds the shortest path from a starting point to an ending point on the array,
 * navigating through obstacles represented by cells with value 1.
 *
 * The class contains a nested Node class representing a cell in the grid with its coordinates,
 * step count from the starting point, and a list of Nodes representing the path taken to reach it.
 *
 * The 'bfs' method takes a 2D grid, starting and ending coordinates as input, and performs BFS
 * traversal to find the shortest path. It returns a list of Nodes representing the shortest path.
 *
 * The 'dir' array defines the possible movement directions (right, down, left, up).
 * The 'a' array stores the grid cells with obstacles.
 * The 'visited' array tracks visited cells to avoid revisiting them.
 *
 * The 's' variable stores the length of the shortest path found.
 *
 * @author BJTU course team (public release anonymized)
 */
public class PathfindingAlgorithm {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] a = new int[100][100];
    static int[][] visited = new int[100][100];
    static int n, m, startx, starty, endx, endy;
    public static int s=0;
    static class Node {
        int x, y, step;
        List<Node> path;

        Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.path = new LinkedList<>();
        }
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    public static List<Node> bfs(int[][] Board, int startX, int startY, int endX, int endY) {
        n = Board.length;
        m = Board[0].length;
        startx = startX;
        starty = startY;
        endx = endX;
        endy = endY;

        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[0].length; j++) {
                a[i][j] = Board[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = 0;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(startx, starty, 0);
        start.path.add(start);
        queue.offer(start);
        visited[startx][starty] = 1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == endx && cur.y == endy) {
                List<Node> shortestPath = new LinkedList<>(cur.path);
                s=cur.step;
                return shortestPath;
            }

            for (int k = 0; k < 4; k++) {
                int tx = cur.x + dir[k][0];
                int ty = cur.y + dir[k][1];
                if (tx >= 0 && tx < n && ty >= 0 && ty < m && a[tx][ty] == 1 && visited[tx][ty] == 0) {
                    Node next = new Node(tx, ty, cur.step + 1);
                    next.path.addAll(cur.path);
                    next.path.add(next);
                    queue.offer(next);
                    visited[tx][ty] = 1;
                }
            }
        }

        System.out.println("Couldn't find the access road！");
        return null;
    }
}
