package leetcode.editor;

import java.util.List;

/**
 * @author wangqimeng
 * @date 2020/6/16 16:07
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
