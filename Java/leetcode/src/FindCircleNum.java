public class FindCircleNum {
    public static void main(String[] args) {
        int[][] isConnected1 = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        int[][] isConnected2 = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected1));
        System.out.println(findCircleNum(isConnected2));

    }

    public static int findCircleNum(int[][] isConnected) {
        int city = isConnected.length;
        boolean[] visited = new boolean[city];
        int provinces = 0; // 计数器

        for (int i = 0; i < city; i++) {
            if (!visited[i]) {
                dfs(i, city, visited, isConnected);
                provinces++;
            }
        }
        return provinces;
    }

    public static void dfs(int i, int city, boolean[] visited, int[][] isConnected) {
        for (int j = 0; j < city; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, city, visited, isConnected);
            }
        }
    }
}