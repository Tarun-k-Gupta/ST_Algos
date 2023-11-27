package com.example;

import com.example.datastructures.*;
import com.example.dp.*;
import com.example.graphs.*;
import com.example.searchAndSorting.*;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ST_Algos {

    @Test
    public void testBFSFromVertex1() {
        DirectedGraph graph = new DirectedGraph();
        for (int i = 0; i < 7; i++) {
            graph.addVertex(i+1);
        }
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);

        BFS bfs = new BFS(graph);
        
        List<Integer> result1 = bfs.getPathFrom(1);

        // Expected BFS path: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        List<Integer> expectedPath1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertEquals(expectedPath1, result1);
    }

    @Test
    public void testBFSWithInvalidSource() {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        BFS bfs = new BFS(graph);

        List<Integer> result = bfs.getPathFrom(4);

        // Expected result: null since 4 is not a valid vertex
        assertNull(result);
    }


    @Test
    public void testCycleDetection() {
        
        DirectedGraph graph = new DirectedGraph();
        for (int i = 0; i < 9; i++) {
            graph.addVertex(i+1);
        }
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        
        CycleDetection detector = new CycleDetection(graph);
        boolean hasCycle = detector.hasCycle();

        assertTrue(hasCycle);

    }


    @Test
    public void testDFSFromVertex1() {
        DirectedGraph graph = new DirectedGraph();

        // Add vertices
        for (int i = 0; i < 7; i++) {
            graph.addVertex(i + 1);
        }

        // Add edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);

        DFS dfs = new DFS(graph);
        List<Integer> expectedResult = Arrays.asList(1, 2, 4, 5, 3, 6, 7);
        List<Integer> result = dfs.getPathFrom(1);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testDFSWithInvalidSource() {
        DirectedGraph graph = new DirectedGraph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        BFS bfs = new BFS(graph);

        List<Integer> result = bfs.getPathFrom(4);

        // Expected result: null since 4 is not a valid vertex
        assertNull(result);
    }

    @Test
    public void testDijkstra() {

        WeightedGraph graph = new WeightedGraph(true);

        for(int i = 0; i < 4; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1, 2.0);
        graph.addEdge(1, 2, 1.0);
        graph.addEdge(2, 3, 3.0);
        graph.addEdge(3, 0, 1.0);

        Dijsktra dijsktra = new Dijsktra(graph);

        dijsktra.shortestPath(0);

        Map<Integer, Double> sd = dijsktra.distance;
        Map<Integer, Double> expected = new HashMap<>();

        expected.put(0, 0.0);
        expected.put(1, 2.0);
        expected.put(2, 3.0);
        expected.put(3, 1.0);

        assertEquals(expected, sd);

    }

    @Test
    public void testIsBipartite() {

        Graph graph = new DirectedGraph();

        for(int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(3, 4);

        IsBipartite isB = new IsBipartite(graph);
        boolean IsBipartite = isB.isBipartite();

        assertTrue(IsBipartite);

    }

    @Test
    public void testIsNotBipartite() {

        Graph graph = new DirectedGraph();

        for(int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        IsBipartite isB = new IsBipartite(graph);
        boolean IsBipartite = isB.isBipartite();

        assertFalse(IsBipartite);

    }

    @Test
    public void testConnected() {
        Graph graph = new DirectedGraph();

        for(int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(3, 4);

        IsConnected isC = new IsConnected(graph);
        boolean IsConnected = isC.isConnected();

        assertTrue(IsConnected);

    }

    @Test
    public void testNotConnected() {
        DirectedGraph graph = new DirectedGraph();
        for (int i = 0; i < 9; i++) {
            graph.addVertex(i+1);
        }
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        IsConnected isC = new IsConnected(graph);
        boolean IsConnected = isC.isConnected();

        assertFalse(IsConnected);

    }

    @Test
    public void testKruskalMST() {

        WeightedGraph graph = new WeightedGraph(true);

        for(int i = 0; i < 7; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1, 2.0);
        graph.addEdge(0, 2, 3.0);
        graph.addEdge(1, 2, 5.0);
        graph.addEdge(1, 3, 6.0);
        graph.addEdge(2, 3, 1.0);
        graph.addEdge(3, 4, 4.0);
        graph.addEdge(4, 5, 7.0);

        KruskalsMST kMST = new KruskalsMST(graph);
        List<Edge> mst = kMST.getMST();
        
        List<Edge> expected = new ArrayList<>();

        expected.add(new Edge(2, 3, 1.0));
        expected.add(new Edge(0, 1, 2.0));
        expected.add(new Edge(0, 2, 3.0));
        expected.add(new Edge(3, 4, 4.0));
        expected.add(new Edge(4, 5, 7.0));

        assertEquals(mst, expected);
        
    }

    @Test
    public void testPrimMST() {

        WeightedGraph graph = new WeightedGraph(true);

        for(int i = 0; i < 7; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1, 2.0);
        graph.addEdge(0, 2, 3.0);
        graph.addEdge(1, 2, 5.0);
        graph.addEdge(1, 3, 6.0);
        graph.addEdge(2, 3, 1.0);
        graph.addEdge(3, 4, 4.0);
        graph.addEdge(4, 5, 7.0);

        PrimsMST pMST = new PrimsMST(graph);
        List<Edge> mst = pMST.getMST();
        List<Edge> expected = new ArrayList<>();
        

        expected.add(new Edge(2, 3, 1.0));
        expected.add(new Edge(0, 1, 2.0));
        expected.add(new Edge(0, 2, 3.0));
        expected.add(new Edge(3, 4, 4.0));
        expected.add(new Edge(4, 5, 7.0));

        assertEquals(mst, expected);
        
    }

    @Test
    public void testDirectedGraph(){
        Graph graph  = new DirectedGraph();
        assertTrue(graph.addVertex(0));
        graph.addVertex(1);

        Set<Integer> vertices = graph.getVertices();
        assertTrue(vertices.contains(0));
        assertFalse(vertices.contains(2));

        Double res = graph.addEdge(0, 1);
        Double success = 0d;
        Double failure = -1d;
        assertEquals(res, success);

        Double res2 = graph.addEdge(0, 2);
        assertEquals(res2, failure);

        Set<Integer> nei = graph.getNeighbors(0);
        assertTrue(nei.contains(1));

        
    }

    @Test
    public void testTopoSort() {
        
        Graph graph = new DirectedGraph();
        for(int i = 0; i < 6; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(5, 2);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        TopologicalSorting topS = new TopologicalSorting(graph);

        List<Integer> toposort = topS.topSort();

        List<Integer> expected = Arrays.asList(5, 4, 2, 3, 1, 0);

        assertEquals(toposort, expected);
        
    }

    @Test
    public void testTopoSortForCycle() {
        DirectedGraph graph = new DirectedGraph();
        for (int i = 0; i < 9; i++) {
            graph.addVertex(i+1);
        }
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        TopologicalSorting topS = new TopologicalSorting(graph);

        List<Integer> toposort = topS.topSort();

        assertNull(toposort);
    }

    @Test
    public void testCountingSort() {
        int[] unsortedArray = {4, 2, 3, 1, 4, 6, 3};
        int[] expectedSortedArray = {1, 2, 3, 3, 4, 4, 6};

        unsortedArray = CountingSort.sort(unsortedArray);

        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testHeapSort() {
        int[] unsortedArray = {4, 2, 3, 1, 4, 6, 3};
        int[] expectedSortedArray = {1, 2, 3, 3, 4, 4, 6};

        unsortedArray = HeapSort.heapSort(unsortedArray, 7);

        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testSelectionSort() {
        int[] unsortedArray = {4, 2, 3, 1, 4, 6, 3};
        int[] expectedSortedArray = {1, 2, 3, 3, 4, 4, 6};

        unsortedArray = SelectionSort.sortt(unsortedArray);

        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testQuickSort() {
        int[] unsortedArray = {4, 2, 3, 1, 4, 6, 3};
        int[] expectedSortedArray = {1, 2, 3, 3, 4, 4, 6};

        unsortedArray = QuickSort.sort(unsortedArray);

        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testMergeSort() {
        int[] unsortedArray = {4, 2, 3, 1, 4, 6, 3};
        int[] expectedSortedArray = {1, 2, 3, 3, 4, 4, 6};

        unsortedArray = MergeSort.sort(unsortedArray);

        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testBubbleSort() {
        int[] unsortedArray = {4, 2, 3, 1, 4, 6, 3};
        int[] expectedSortedArray = {1, 2, 3, 3, 4, 4, 6};

        // unsortedArray = BubbleSort.sort(unsortedArray);
        unsortedArray = BubbleSort.sort(unsortedArray);

        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testInsertionSort() {
        int[] unsortedArray = {4, 2, 3, 1, 4, 6, 3};
        int[] expectedSortedArray = {1, 2, 3, 3, 4, 4, 6};

        unsortedArray = InsertionSort.sort(unsortedArray);

        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void LinearSearch() {
        int[] Array = {4, 2, 3, 1, 4, 6, 3};
        int[] Array2 = {};
        boolean res = LinearSearch.linearSearch(Array, 4);
        boolean res2 = LinearSearch.linearSearch(Array, 8);
        boolean res3 = LinearSearch.linearSearch(Array2, 4);
        Assert.assertTrue(res);
        Assert.assertFalse(res2);
        Assert.assertFalse(res3);
    }

    @Test
    public void BinarrySearch() {
        int[] Array = {1, 2, 3, 4, 5, 6};

        Assert.assertEquals(2, BinarySearch.search(Array, 3));
    }

    @Test
    public void testBinarySearchLowerBound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArrayWithDuplicates = {1, 2, 2, 4, 4, 6, 7, 7, 7, 10};

        // Test cases where the first occurrence of the element is found
        Assert.assertEquals(3, BinarySearch.searchLowerBound(sortedArrayWithDuplicates, 4));
        Assert.assertEquals(6, BinarySearch.searchLowerBound(sortedArrayWithDuplicates, 7));

        // Test cases where the element does not exist in the array
        Assert.assertEquals(-6, BinarySearch.searchLowerBound(sortedArrayWithDuplicates, 5)); // Position to be inserted is 5
        Assert.assertEquals(-11, BinarySearch.searchLowerBound(sortedArrayWithDuplicates, 11)); // Position to be inserted is 10
    }

    @Test
    public void testBinarySearchUpperBound() {
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArrayWithDuplicates = {1, 2, 2, 4, 4, 6, 7, 7, 7, 10};

        // Test cases where the last occurrence of the element is found
        Assert.assertEquals(4, BinarySearch.searchUpperBound(sortedArrayWithDuplicates, 4));
        Assert.assertEquals(8, BinarySearch.searchUpperBound(sortedArrayWithDuplicates, 7));

        // Test cases where the element does not exist in the array
        Assert.assertEquals(-5, BinarySearch.searchUpperBound(sortedArrayWithDuplicates, 5)); // Position to be inserted is 5
        Assert.assertEquals(-10, BinarySearch.searchUpperBound(sortedArrayWithDuplicates, 11)); // Position to be inserted is 10
    }

    @Test
    public void testFib() {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();

        // Test cases for the fib method
        assertEquals(0, fibonacciNumber.fib(0));
        assertEquals(0, fibonacciNumber.fib(1));
        assertEquals(1, fibonacciNumber.fib(2));
        assertEquals(1, fibonacciNumber.fib(3));
        assertEquals(2, fibonacciNumber.fib(4));
        assertEquals(3, fibonacciNumber.fib(5));
        assertEquals(5, fibonacciNumber.fib(6));
        assertEquals(8, fibonacciNumber.fib(7));
    }

    @Test
    public void testFibonacci() {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();

        // Test cases for the fibonacci method
        assertEquals(0, fibonacciNumber.fibonacci(0));
        assertEquals(1, fibonacciNumber.fibonacci(1));
        assertEquals(1, fibonacciNumber.fibonacci(2));
        assertEquals(2, fibonacciNumber.fibonacci(3));
        assertEquals(3, fibonacciNumber.fibonacci(4));
        assertEquals(5, fibonacciNumber.fibonacci(5));
        assertEquals(8, fibonacciNumber.fibonacci(6));
        assertEquals(13, fibonacciNumber.fibonacci(7));
    }

    @Test
    public void testKnapsack() {
        int[] values = {1, 4, 5, 7};
        int[] weights = {1, 3, 4, 5};
        int k = 7;

        int[][] result = Knapsack01.knapsack(values, weights, k);

        // Assert the maximum value
        assertEquals(9, result[values.length - 1][k]);
    }

    @Test
    public void testLPS() {

        // Test Case 1: Check the length of the LPS for the given string "GEEKSFORGEEKS"
        String seq1 = "GEEKSFORGEEKS";
        int expectedLength1 = 5; // The longest palindromic subsequence is "EEKEE"
        assertEquals(expectedLength1, lps.LPS(seq1.toCharArray(), 0, seq1.length() - 1));

      
    }
    @Test
    public void testLCS() {

        // Test Case 1: Check the length of the LCS for the given strings "ABCBDAB" and "BDCAB"
        String X1 = "ABCBDAB";
        String Y1 = "BDCAB";
        int expectedLength1 = 4; // The longest common subsequence is "BCAB"
        assertEquals(expectedLength1, lcs.LCS(X1.toCharArray(), Y1.toCharArray(), X1.length(), Y1.length()));

    }
    // @Test
    // public void testSubsetSumDP() {
    //     SubsetSum subsetSum = new SubsetSum();

    //     // Test Case 1: Positive case where there is a subset with the given sum
    //     int[] set1 = {3, 34, 4, 12, 5, 2};
    //     int sum1 = 9;
    //     assertTrue(subsetSum.subsetSum2(set1, sum1));

    //     // Test Case 2: Negative case where there is no subset with the given sum
    //     int[] set2 = {1, 2, 3, 7};
    //     int sum2 = 10;
    //     assertFalse(subsetSum.subsetSum2(set2, sum2));

    //     // Test Case 3: Edge case with an empty set and sum 0
    //     int[] set3 = {};
    //     int sum3 = 0;
    //     assertTrue(subsetSum.subsetSum2(set3, sum3));

    //     // Add more test cases as needed
    // }

    // @Test
    // public void testSubsetSumBruteForce() {
    //     SubsetSum subsetSum = new SubsetSum();

    //     // Test Case 1: Positive case where there is a subset with the given sum
    //     int[] set1 = {3, 34, 4, 12, 5, 2};
    //     int sum1 = 9;
    //     assertTrue(subsetSum.subsetSum(set1, set1.length, sum1));

    //     // Test Case 2: Negative case where there is no subset with the given sum
    //     int[] set2 = {1, 2, 3, 7};
    //     int sum2 = 10;
    //     assertFalse(subsetSum.subsetSum(set2, set2.length, sum2));

    //     // Test Case 3: Edge case with an empty set and sum 0
    //     int[] set3 = {};
    //     int sum3 = 0;
    //     assertTrue(subsetSum.subsetSum(set3, set3.length, sum3));

    //     // Add more test cases as needed
    // }

    // @Test
    // public void testNoDPSol() {
    //     MinimizeArraySize solver = new MinimizeArraySize();

    //     int[] arr1 = {100, 101, 105, 2, 10, 12, 14, 4, 22, 24, 26, 6, 500};
    //     int k1 = 2;
    //     assertEquals(4, solver.noDPSol(0, arr1.length - 1, arr1, k1));

    //     int[] arr2 = {2, 3, 4, 5, 6, 4};
    //     int k2 = 1;
    //     assertEquals(0, solver.noDPSol(0, arr2.length - 1, arr2, k2));

    // }

    // @Test
    // public void testDPSol() {
    //     MinimizeArraySize solver = new MinimizeArraySize();

    //     int[] arr1 = {100, 101, 105, 2, 10, 12, 14, 4, 22, 24, 26, 6, 500};
    //     int k1 = 2;
    //     assertEquals(4, solver.dpSol(0, arr1.length - 1, arr1, k1, new int[arr1.length][arr1.length]));

    //     int[] arr2 = {2, 3, 4, 5, 6, 4};
    //     int k2 = 1;
    //     assertEquals(0, solver.dpSol(0, arr2.length - 1, arr2, k2, new int[arr2.length][arr2.length]));

    // }

    @Test
    public void testDirectedgraph(){
        Graph graph  = new DirectedGraph();
        assertTrue(graph.addVertex(0));
        graph.addVertex(1);

        Set<Integer> vertices = graph.getVertices();
        assertTrue(vertices.contains(0));
        assertFalse(vertices.contains(2));

        Double res = graph.addEdge(0, 1);
        Double success = 0d;
        Double failure = -1d;
        assertEquals(res, success);

        Double res2 = graph.addEdge(0, 2);
        assertEquals(res2, failure);

        Double res3 = graph.addEdge(2, 0);
        assertEquals(res3, failure);

        Set<Integer> nei = graph.getNeighbors(0);
        assertTrue(nei.contains(1));

        int size = graph.size();
        assertEquals(size, 2);

        assertFalse(graph.addEdge(0, 1, 1.0));
        assertFalse(graph.removeVertex(2));
        assertTrue(graph.removeEdge(0, 1));
        assertFalse(graph.removeEdge(0, 1));
        assertFalse(graph.removeEdge(2, 1));
        assertFalse(graph.removeEdge(0, 2));

    }

    @Test
    public void testEdge() {
        Edge Edge1 = new Edge(1, 2, 1.0);
        Edge Edge2 = new Edge(2, 3, 2.0);
        Edge Edge3 = new Edge(1, 2, 1.0);
        Edge Edge4 = new Edge(1, 2, null);
        Edge Edge5 = new Edge(1, null, 1.0);
        Edge Edge6 = new Edge(null, 1, 1.0);

        assertTrue(Edge1.equals(Edge1));
        assertTrue(Edge1.equals(Edge3));
        assertFalse(Edge1.equals(Edge2));
        assertFalse(Edge1.equals(null));
        assertFalse(Edge1.equals(Edge4));
        assertFalse(Edge4.equals(Edge1));
        assertFalse(Edge5.equals(Edge6));
        assertFalse(Edge6.equals(Edge5));

        Double w = Edge1.getWeight();
        Double one = 1.0;
        Double two = 2.0;
        assertEquals(w, one);
        assertNotEquals(w, two);

        Integer _from = Edge2.getFrom();
        Integer twoi = 2;
        assertEquals(_from, twoi);

        Double weight = 1.0;
        Integer from = 1;
        Integer to = 2;
        assertEquals(Edge1.toString(), "Edge{" +
        "weight=" + weight +
        ", from=" + from +
        ", to=" + to +
        '}');

    }

    @Test
    public void testUndirectedGraph() {
        UndirectedGraph graph = new UndirectedGraph();
        assertTrue(graph.addVertex(0));
        assertTrue(graph.addVertex(1));
        assertTrue(graph.getVertices().contains(0));
        assertFalse(graph.getVertices().contains(2));

        Double res = graph.addEdge(0, 1);
        Double success = 0d;
        Double failure = -1d;
        assertEquals(res, success);

        Double res2 = graph.addEdge(0, 2);
        assertEquals(res2, failure);

        Double res3 = graph.addEdge(2, 0);
        assertEquals(res3, failure);

        Set<Integer> nei = graph.getNeighbors(0);
        assertTrue(nei.contains(1));

        int size = graph.size();
        assertEquals(size, 2);

        assertFalse(graph.addEdge(1, 2, 1.0));

    }

    @Test
    public void testVertex() {
        Vertex<?> v1 = new Vertex<>(0);
        Vertex<?> v2 = new Vertex<>(1);
        Vertex<?> v3 = new Vertex<>(1);

        assertEquals(v1.toString(), "Vertex{value=0}");
        assertFalse(v1.equals(v2));
        assertTrue(v1.equals(v1));
        assertTrue(v2.equals(v3));
        assertFalse(v1.equals(null));

        v1.setWeight(1.0);
        assertEquals(v1.getWeight(), 1.0);

        v2.setParent(v3);
        assertEquals(v2.getParent(), v3);
        
    }

    @Test
    public void testWeightedGraph() {
        WeightedGraph graph = new WeightedGraph(false);

        assertTrue(graph.addVertex(0));
        graph.addVertex(1);

        Set<Integer> vertices = graph.getVertices();
        assertTrue(vertices.contains(0));
        assertFalse(vertices.contains(2));

        assertTrue(graph.addEdge(0, 1, 1.0));

        assertFalse(graph.addEdge(0, 2, 2.0));

        assertFalse(graph.addEdge(2, 0, 3.0));

        Set<Integer> nei = graph.getNeighbors(0);
        assertTrue(nei.contains(1));

        int size = graph.size();
        assertEquals(size, 2);

        assertTrue(graph.removeVertex(2));
        assertTrue(graph.removeEdge(0, 1));
        assertFalse(graph.removeEdge(0, 1));
        assertFalse(graph.removeEdge(2, 1));
        assertFalse(graph.removeEdge(0, 2));
        
    }

    @Test
    public void testBellmanFordNoNegCycles() {
        WeightedGraph graph = new WeightedGraph(true);

        for(int i = 0; i < 4; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(0, 1, 2.0);
        graph.addEdge(1, 2, 1.0);
        graph.addEdge(2, 3, 3.0);
        graph.addEdge(3, 0, 1.0);


        BellmanFord BFA = new BellmanFord(graph);

        assertTrue(BFA.shortestPath(0));

        Map<Integer, Double> sd = BFA.distance;
        Map<Integer, Double> expected = new HashMap<>();

        expected.put(0, 0.0);
        expected.put(1, 2.0);
        expected.put(2, 3.0);
        expected.put(3, 1.0);

        assertEquals(expected, sd);

    }

}
