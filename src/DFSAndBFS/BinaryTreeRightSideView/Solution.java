package DFSAndBFS.BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        q.add(node);
        while(!q.isEmpty()){
            int numOfNodesAtLevel = q.size();
            TreeNode rightMostElement = q.getLast();
            result.add(rightMostElement.val);
            for(int i = 0; i < numOfNodesAtLevel; i++){
                TreeNode firstNode = q.poll();
                if(firstNode.left != null){
                    q.add(firstNode.left);
                }
                if(firstNode.right != null){
                    q.add(firstNode.right);
                }
            }
        }

        return result;
    }
}