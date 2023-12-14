import java.io.*;
import java.util.*;

/**
 * A class representing a character binary search tree.
 * Author: Veer Saini
 */
public class CharTree {

    /**
     * Inner class representing a tree node.
     */
    private static class TreeNode {
        public TreeNode leftLink;
        private char data;
        public TreeNode rightLink;

        /**
         * Parametrized constructor to build a node.
         *
         * @param newData       The character data of the node.
         * @param newLeftLink   The left link of the node.
         * @param newRightLink  The right link of the node.
         */
        public TreeNode(char newData, TreeNode newLeftLink, TreeNode newRightLink) {
            data = newData;
            leftLink = newLeftLink;
            rightLink = newRightLink;
        }
    }

    // The first node of the tree, called root
    private TreeNode root;

    /**
     * Default constructor to build the CharTree.
     */
    public CharTree() {
        root = null;
    }

    /**
     * Adds a character to the tree.
     *
     * @param item The character to be added.
     */
    public void add(char item) {
        root = insertInSubtree(item, root);
    }

    /**
     * Checks if the tree contains a specific character.
     *
     * @param item The character to check for.
     * @return True if the character is found, false otherwise.
     */
    public boolean contains(char item) {
        return isInSubtree(item, root);
    }

    /**
     * Displays the elements of the tree in sorted order.
     */
    public void showElements() {
        showElementsInSubtree(root);
    }

    private static TreeNode insertInSubtree(char item, TreeNode subTreeRoot) {
        if (subTreeRoot == null)
            return new TreeNode(item, null, null);
        else if (item < subTreeRoot.data) {
            subTreeRoot.leftLink = insertInSubtree(item, subTreeRoot.leftLink);
            return subTreeRoot;
        } else {
            subTreeRoot.rightLink = insertInSubtree(item, subTreeRoot.rightLink);
            return subTreeRoot;
        }
    }

    private static boolean isInSubtree(char item, TreeNode subTreeRoot) {
        if (subTreeRoot == null) return false;
        else if (item == subTreeRoot.data) return true;
        else if (item < subTreeRoot.data) return isInSubtree(item, subTreeRoot.leftLink);
        else return isInSubtree(item, subTreeRoot.rightLink);
    }

    private static void showElementsInSubtree(TreeNode subTreeRoot) {
        if (subTreeRoot != null) {
            showElementsInSubtree(subTreeRoot.leftLink);
            System.out.print(subTreeRoot.data + " ");
            showElementsInSubtree(subTreeRoot.rightLink);
        }
    }

    /**
     * Main method to test the CharTree class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        CharTree tree = new CharTree();
        tree.add('d');
        tree.add('a');
        tree.add('b');
        tree.add('z');
        tree.add('s');
        tree.add('y');
        tree.showElements();

        System.out.println();
        System.out.println(tree.contains('b'));
        System.out.println(tree.contains('x'));

/*
        // Uncomment the lines below to test the remove() functionality.
        tree.remove('e');
        System.out.println();
        tree.showElements();
        tree.remove('a');
        System.out.println();
        tree.showElements();
        tree.remove('z');
        System.out.println();
        tree.showElements();
        tree.remove('b');
        System.out.println();
        tree.showElements();
        tree.remove('d');
        System.out.println();
        tree.showElements();
*/

    }

    /**
     * Removes a character from the tree.
     *
     * @param item The character to be removed.
     */
    public void remove(char item) {
        root = removeFromSubtree(item, root);

    }

    private TreeNode removeFromSubtree(char item, TreeNode subtree) {
        if (subtree == null) {
            return null;
        }

        if (item < subtree.data) {
            subtree.leftLink = removeFromSubtree(item, subtree.leftLink);

        } else if (item > subtree.data) {
            subtree.rightLink = removeFromSubtree(item, subtree.rightLink);

        } else {
            if (subtree.leftLink == null) {
                return subtree.rightLink;

            } else if (subtree.rightLink == null) {
                return subtree.leftLink;

            } else {
                subtree.data = findMin(subtree.rightLink);
                subtree.rightLink = removeFromSubtree(subtree.data, subtree.rightLink);

            }

        }

        return subtree;
    }

    private char findMin(TreeNode node) {
        while (node.leftLink != null) {
            node = node.leftLink;

        }

        return node.data;
    }
}
