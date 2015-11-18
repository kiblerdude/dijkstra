package com.kiblerdude.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * Dijkstra's Shortest Path Algorithm
 *
 */
public class Dijkstra 
{
	private static final int NO_PATH_LENGTH = 1000000;
	public Dijkstra() {
		
	}
	
	public Integer shortestPath(Graph g, Integer from, Integer to) {
		Set<Integer> processed = Sets.newHashSet();
		
		
		
		return NO_PATH_LENGTH;
	}
	
    public static void main( String[] args ) throws IOException
    {
        //Files.newBufferedReader(Paths.get("dijkstraData.txt"));
        BufferedReader reader = Files.newBufferedReader(Paths.get("dijkstraTest.txt"));
        Graph graph = new Graph();
        
        reader.lines().forEach(line -> {
        	String[] vertexData = line.split("\\t");
        	Integer vertex = Integer.parseInt(vertexData[0]);        	
        	for (int i = 1; i < vertexData.length; i++) {
        		String[] edgeData = vertexData[i].split(",");
        		Integer to = Integer.parseInt(edgeData[0]);
        		Integer length = Integer.parseInt(edgeData[1]);
        		graph.addEdge(vertex, to, length);
        	}
        });
        
        System.out.println(graph);
    }
}
