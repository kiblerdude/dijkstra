package com.kiblerdude.dijkstra;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class Node {
	
	public Integer value = -1;
	public Map<Integer, Integer> outgoing = Maps.newHashMap();
	public Iterator<Entry<Integer,Integer>> iter = outgoing.entrySet().iterator();
	
	public boolean explored = false;
	
	public Node(Integer value) {
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (o instanceof Node) {
			Node that = (Node)o;
			return value.equals(that.value);
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(value).append(" -> ");
		
		outgoing.entrySet().forEach(e -> {
			builder.append(e.getKey()).append("[").append(e.getValue()).append("]").append(" ");
		});
		
		return builder.toString();
	}
}
