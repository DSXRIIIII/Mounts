package cn.dsxriiiii.Algorithm.Tree;

//判断是否是二叉搜索树
public class BST{
    public static boolean isValid(TreeNode<Long> root){
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean isValid(TreeNode<Long> node,Long lower,Long upper){
        if(node == null){
            return true;
        }
        if(node.val <= lower || node.val >= upper){
            return false;
        }
        return isValid(node.left ,lower,node.val) && isValid(node.right, node.val, upper);
        //传递参数，走左边那么最大值就是node.val ,走右边就是最小值就是node.val
    }

    /**
     *
     * @param root
     * @param value
     * @return 该方法可能不适用泛型 需自行调整
     * @param <T>
     */
    public static<T> TreeNode<T> insertIntoBST(TreeNode<T> root,T value) {
        if(root == null){
            return new TreeNode<>(value);
        }
        TreeNode<T> temp = root;
        while(temp != null){
            if(compareTo(value,temp.val)){
                if(temp.left == null){
                    temp.left = new TreeNode<>(value);
                    break;
                }else{
                    temp = temp.left;
                }
            }else{
                if(temp.right == null){
                    temp.right = new TreeNode<>(value);
                    break;
                }else{
                    temp = temp.right;
                }
            }
        }
        return root;
    }
    public static <T> boolean compareTo(T value1, T value2) {
        // 在这里实现你的自定义比较逻辑
        // 返回值>0表示value1大于value2，返回值<0表示value1小于value2，返回值=0表示value1等于value2
        // 示例逻辑：假设T类型是Integer，我们比较两个整数的大小
        Integer intValue1 = (Integer) value1;
        Integer intValue2 = (Integer) value2;
        return intValue1.compareTo(intValue2) == 0;
    }

    public static void main(String[] args) {
        Long[] nums = {2L,1L,3L};
        TreeNode<Long> root = TreeBuilder.buildTreeFromArray(nums);
        System.out.println(isValid(root));
    }
}
