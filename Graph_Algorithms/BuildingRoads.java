import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildingRoads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int roads = sc.nextInt();
        DisjoinSet djs = new DisjoinSet(cities + 1);
        for (int i = 0; i < roads; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            djs.unionBySize(u, v);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= cities; i++) {
            if (djs.findParent(i) == i) {
                list.add(i);
            }
        }
        int roadsNeeded = list.size() - 1;
         System.out.println(roadsNeeded);
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(0) + " " + list.get(i));
        }
        sc.close();

    }
}

class DisjoinSet {
    int[] size;
    int[] parent;

    public DisjoinSet(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node) {
        if (node == parent[node])
            return node;

        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int x = findParent(u);
        int y = findParent(v);
        if (x == y)
            return;
        else if (size[x] < size[y]) {
            parent[x] = y;
            size[y] += size[x];
        } else {
            parent[y] = x;
            size[x] += size[y];
        }
    }

    public boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }
}
