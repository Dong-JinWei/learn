class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int rob(TreeNode root) {
        int[] robStatus = dfs(root);
        return Math.max(robStatus[0], robStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[] { selected, notSelected };

    }
}

public class HouseRobber3 {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(3, null, node4);
        TreeNode node1 = new TreeNode(2, null, node3);
        TreeNode root = new TreeNode(3, node1, node2);

        Solution test = new Solution();
        int rob = test.rob(root);
        System.out.println(rob);

    }
}