package com.kiblerdude.dijkstra;

import java.util.Map;

import com.google.common.collect.Maps;

public class Graph {
	
	public Map<Integer, Node> nodes = Maps.newHashMap();
	
	public void addNode(Node node) {
		nodes.put(node.value, node);
	}
	
	public void addEdge(Integer from, Integer to) {
		if (nodes.containsKey(from)) {
			Node node = nodes.get(from);
			node.outgoing.add(to);
		} else {
			Node node = new Node(from, 0);
			node.outgoing.add(to);
			nodes.put(from, node);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		nodes.forEach( (k,v) -> {
			builder.append(v).append("\n");
		});
		return builder.toString();
	}
}
