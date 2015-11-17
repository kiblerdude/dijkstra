package com.kiblerdude.dijkstra;

import java.util.Iterator;
import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;

public class Node {
	public Integer value = -1;
	public Integer weight = Integer.MAX_VALUE;
	public Set<Integer> outgoing = Sets.newTreeSet(); // use natural ordering
	public Iterator<Integer> iter = outgoing.iterator();
	
	public boolean explored = false;
	
	public Node(Integer value, Integer weight) {
		this.value = value;
		this.weight = weight;
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
		builder.append(value).append(" (");
		builder.append(Joiner.on(",").join(weight, explored));
		builder.append(")").append(" -> ");
		builder.append(Joiner.on(",").join(outgoing));
		return builder.toString();
	}
}
