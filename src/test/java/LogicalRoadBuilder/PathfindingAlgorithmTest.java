package LogicalRoadBuilder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathfindingAlgorithmTest {
    private static final int[][] BOARD = {{1, 1, 0}, {0, 1, 1}};

    @Test
    void findsShortestPath() {
        List<PathfindingAlgorithm.Node> path = PathfindingAlgorithm.bfs(BOARD, 0, 0, 1, 2);

        assertNotNull(path);
        assertEquals(4, path.size());
        assertEquals(3, PathfindingAlgorithm.s);
        assertEquals(0, path.get(0).getX());
        assertEquals(0, path.get(0).getY());
        assertEquals(1, path.get(3).getX());
        assertEquals(2, path.get(3).getY());
    }

    @Test
    void resetsVisitedStateBetweenCalls() {
        PathfindingAlgorithm.bfs(BOARD, 0, 0, 1, 2);
        List<PathfindingAlgorithm.Node> repeated = PathfindingAlgorithm.bfs(BOARD, 0, 0, 1, 2);

        assertNotNull(repeated);
        assertEquals(4, repeated.size());
        assertEquals(3, PathfindingAlgorithm.s);
    }

    @Test
    void returnsNullWhenDestinationIsUnreachable() {
        int[][] blocked = {{1, 0}, {0, 1}};

        assertNull(PathfindingAlgorithm.bfs(blocked, 0, 0, 1, 1));
    }
}
