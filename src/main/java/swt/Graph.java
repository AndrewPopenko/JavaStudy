package swt;

import java.util.ArrayList;

public class Graph {
    class Edge {
        int v;

        Edge(int v) {
            this.v = v;
        }
    }

    ArrayList<Edge>[] adj;

    int n;

    Graph(int n) {
        this.n = n;
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addUndirectEdge(int u, int v) {
        adj[u].add(new Edge(v));
        adj[v].add(new Edge(u));
    }

    void addDirectEdge(int u, int v) {
        adj[u].add(new Edge(v));
    }

    void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + ":");
            for (Edge edge : adj[i]) {
                System.out.print(" " + edge.v);
            }
            System.out.println();
        }
    }

    void bfs(int s) {
        int[] queue = new int[n];
        int head = 0;
        int tail = -1;
        boolean[] visited = new boolean[n];

        for (int u = 0; u < n; u++) {
            visited[u] = false;
        }

        visited[s] = true;
        queue[++tail] = s;

        while (head <= tail) {
            int u = queue[head++];
            for (Edge edge : adj[u]) {
                int v = edge.v;
                if (!visited[v]) {
                    visited[v] = true;
                    queue[++tail] = v;
                }
            }
        }
    }
}
