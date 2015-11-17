# dijkstra

Dijkstra's Shortest Path Algorithm

Given a directed graph `G` where each edge has a non-negative length `l` and a source vertex `s`.

##### Algorithm

	ShortestPath(Vertice s, Vertice t)

	X = { s }	// vertices processed so far
	A[s] = 0	// computed shortest path distances
	B[s] = (empty)	// computed shortest path

	while vertice v not in X
		-among all edges (v,w) in G, with v in X and w not in X,
		pick one that minimizes A[v] + len(w)
		- add w to X
		- set A[w*] = A[v*] + len(w)

##### Example

	s->v = 1
	s->w = 4
	v->v = 2
	v->t = 6
	w->t = 3

	shortest path (s,t) = s->v->w->t = 6