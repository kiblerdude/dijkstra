package com.kiblerdude.dijkstra;

import java.util.Map;

import com.google.common.collect.Maps;

public class Graph {
	
	public Map<Integer, Node> nodes = Maps.newHashMap();
	
	public void addEdge(Integer from, Integer to, Integer length) {
		if (nodes.containsKey(from)) {
			Node node = nodes.get(from);
			node.outgoing.put(to, length);
		} else {
			Node node = new Node(from);
			node.outgoing.put(to, length);
			nodes.put(from, node);
		}
		
		if (!nodes.containsKey(to)) {
			Node node = new Node(to);
			nodes.put(to, node);
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
