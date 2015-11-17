# dijkstra

Dijkstra's Shortest Path Algorihtm

### Algorithm

	ShortestPath(Vertice s, Vertice t)

	X = { s }	// vertices processed so far
	A[s] = 0	// computed shortest path distances
	B[s] = (empty)	// computed shortest path

	while vertice v not in X
		-among all edges (v,w) in G, with v in X and w not in X,
		pick one that minimizes A[v] + len(w)
		- add w to X
		- set A[w*] = A[v*] + len(w)

	