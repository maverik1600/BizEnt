/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bizent;

import javax.swing.event.TreeModelEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author ggmoy
 */
public class CategoriasTreeModel extends DefaultTreeModel implements TreeModelListener {
    /* Constructores */
    public CategoriasTreeModel(TreeNode root) {
        super(root);
        this.addTreeModelListener(this);
    }

    public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode)(e.getTreePath().getLastPathComponent());

            /*
             * If the event lists children, then the changed
             * node is the child of the node we've already
             * gotten.  Otherwise, the changed node and the
             * specified node are the same.
             */
            //int index = e.getChildIndices()[0];
            //node = (DefaultMutableTreeNode)(node.getChildAt(index));

            System.out.println("The user has finished editing the node.");
            System.out.println("New value: " + ((Categoria) node.getUserObject()).getId());
        }
        public void treeNodesInserted(TreeModelEvent e) {
        }
        public void treeNodesRemoved(TreeModelEvent e) {
        }
        public void treeStructureChanged(TreeModelEvent e) {
        }
}
