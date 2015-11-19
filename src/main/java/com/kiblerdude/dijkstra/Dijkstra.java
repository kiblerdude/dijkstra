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
public class Dijkstra {
	private static final int NO_PATH_LENGTH = 1000000;

	private final Graph graph;

	public Dijkstra(Graph graph) {
		this.graph = graph;
	}

	public Integer shortestPath(Integer from, Integer to) {
		Set<Integer> processed = Sets.newHashSet();
		Set<Integer> unprocessed = Sets.newHashSet(graph.nodes.keySet());

		Integer[] distances = new Integer[graph.nodes.size() + 1];

		Arrays.fill(distances, 0);

		Integer n = from;
		processed.add(n);
		unprocessed.remove(n);

		// while (!processed.contains(to)) {
		getShortestEdge(processed, unprocessed, distances);
		// find the edge with the minimum value from processed nodes to
		// unprocessed nodes
		// TODO filter edges already processed

		// }

		return NO_PATH_LENGTH;
	}

	public Optional<Node> getShortestEdge(Set<Integer> processed, Set<Integer> unprocessed, Integer[] distances) {


		processed.stream().forEach(p -> {
			Node from = graph.nodes.get(p);
			Optional<Entry<Integer, Integer>> edge = from.outgoing.entrySet().stream()
				.filter(v -> unprocessed.contains(v.getKey()))
				.min((e1, e2) -> Integer.compare(distances[p] + e1.getValue(), distances[p] + e2.getValue()));
			
			if (edge.isPresent()) {
				System.out.println(edge.get());
			}
		});
		
		return Optional.empty();
	}

	public static void main(String[] args) throws IOException {
		// Files.newBufferedReader(Paths.get("dijkstraData.txt"));
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

		new Dijkstra(graph).shortestPath(1, 4);
	}
}
