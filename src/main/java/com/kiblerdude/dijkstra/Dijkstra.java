package com.kiblerdude.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Optional;
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
		Integer[] distances = new Integer[g.nodes.size() + 1];
		
		Arrays.fill(distances, NO_PATH_LENGTH);
		
		distances[from] = 0;
		
		Integer v = from;
		
		while (!processed.contains(to)) {
			Node node = g.nodes.get(v);
			// find the edge with the minimum value
			// TODO filter edges already processed
			
			Optional<Entry<Integer, Integer>> minEdge = node.outgoing.entrySet().stream().min(
					(p1,p2) -> Integer.compare(p1.getValue(), p2.getValue()));
			
			if (minEdge.isPresent()) {
				System.out.println(minEdge.get());			
				processed.add(minEdge.get().getKey());

				v =	minEdge.get().getValue();
			} else {
				// no path
				System.out.println("no path");
				processed.add(to);
			}
		}		
		
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
        
        new Dijkstra().shortestPath(graph, 1, 4);
    }
}
