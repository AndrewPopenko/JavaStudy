package swt;

import java.util.ArrayList;

public class GraphDistPredecessor {
    class Edge {
        int v;

        Edge(int v) {
            this.v = v;
        }
    }

    ArrayList<Edge>[] adj;
    int n;

    GraphDistPredecessor(int n) {
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

    boolean[] visited;
    int[] predecessor;

    void bfs(int s) {
        int[] queue = new int[n];
        visited = new boolean[n];
        predecessor = new int[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
            predecessor[i] = -1;
        }

        int head = 0;
        int tail = 0;

        visited[s] = true;
        queue[tail] = s;

        while (head <= tail) {
            int u = queue[head++];

            for (Edge e : adj[u]) {
                int v = e.v;
                if(!visited[v]) {
                    visited[v] = true;
                    predecessor[v] = u;
                    queue[++tail] = v;
                }
            }
        }
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

    void pathBackward(int s, int t) {
        if (predecessor[t] == -1) {
            System.out.println("No path from '" + s + "' to '" + t + "'");
        } else {
            int u = t;

            System.out.print("Path from '" + t + "' to '" + s + "' is:");

            while (u != s) {
                System.out.print(" " + u);
                u = predecessor[u];
            }
            System.out.print(" " + s);
        }
    }

    void pathForward(int s, int u) {
        if (u == s) {
            System.out.print("Path from '" + s + "' to '" + u + "' is:" /*+ s*/);
        } else if (predecessor[u] == -1) {
            System.out.println("No path from '" + s + "' to '" + u + "'");
        } else {
            pathForward(s, predecessor[u]);
        }
        System.out.print(" " + u);
    }
}
