// --== CS400 File Header Information ==--
// Name: Ali Alawami
// Email: aalawami@wisc.edu
// Team: JE
// Role: Data wrangler 2
// TA: Tingjia Cao
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private CS400Graph<Integer> graph;
    @BeforeEach
    /**
     * Instantiate graph from last week's shortest path activity.
     */
    public void createGraph() {
        graph = new CS400Graph<>();
        // insert vertices 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        // insert edges from Week 08. Dijkstra's Activity
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,7,2);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(3,7,2);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,0,2);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1);
        graph.insertEdge(7,0,3);
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
    }

    /**
     * Checks the distance/total weight cost from the vertex labelled 0 to 8
     * (should be 15), and from the vertex labelled 9 to 8 (should be 17).
     */
    @Test
    public void providedTestToCheckPathCosts() {
        assertTrue(graph.getPathCost(0,8) == 15);    
        assertTrue(graph.getPathCost(9,8) == 17);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex 
     * labelled 0 to 8, and from the vertex labelled 9 to 8.
     */
    @Test
    public void providedTestToCheckPathContents() {
        assertTrue(graph.shortestPath(0, 8).toString().equals(
            "[0, 2, 6, 3, 1, 8]"
        ));
        assertTrue(graph.shortestPath(9, 8).toString().equals(
            "[9, 4, 5, 1, 8]"
        ));
    }
    
    /**
     * Checks if the shortest path between node 7 and 9 is weighted 13
     *  as I got in the activity
     */
    @Test
    public void djkstraActivityLongestDistanceTest() {
    	assertTrue(graph.getPathCost(7,9) == 13); 
    }
    
    /**
     *  tests if the shortest path between node 7 and node 9
     *  is the same as what I submited as my answer in the activity
     */
    @Test
    public void djkstraActivityLongestPathTest() {
        assertTrue(graph.shortestPath(7, 9).toString().equals(
            "[7, 0, 2, 4, 5, 9]"
        ));
       
    }
    
    /**
     * tests if the dijkstraAlgorithem will throw a NSEE if a node is unreachable.
     */
    @Test
    public void unreachableNodeTest() {
    	
    	graph = new CS400Graph<>();
        // insert vertices 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        
    	graph.insertEdge(0,2,1);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,0,2);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1);
        graph.insertEdge(7,0,3);
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
    	
        try {
        	
        	graph.shortestPath(5, 7);
        }
    	catch(NoSuchElementException e){
    		assertTrue(true); return;
    	}
        fail();
    }
    
    /**
     * checks if NSEE is thrown if start does not exist 
     *  
     */
    @Test
    public void chooseAnotherPathTest() {
    	
    	graph = new CS400Graph<>();
        // insert vertices 0-9
        for(int i=0;i<10;i++)
            graph.insertVertex(i);
        
        
        graph.insertEdge(1,7,2);
        graph.insertEdge(1,8,4);
        graph.insertEdge(2,4,4);
        graph.insertEdge(2,6,3);
        graph.insertEdge(3,1,6);
        graph.insertEdge(3,7,2);
        graph.insertEdge(4,5,4);
        graph.insertEdge(5,1,4);
        graph.insertEdge(5,9,1);
        graph.insertEdge(6,3,1); 
        graph.insertEdge(7,6,1);
        graph.insertEdge(8,9,3);
        graph.insertEdge(9,4,5);
    	
        try {
        	
        	graph.shortestPath(0, 7);
        }
    	catch(NoSuchElementException e){
    		assertTrue(true); return;
    	}
        fail();
    }

}
