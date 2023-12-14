import java.io.*;
import java.util.Scanner;

/**
 * A class representing a Morse code binary tree.
 * Author: Veer Saini
 */

public class MorseTree {

    private TreeNode<Character> root;

    /**
     * Constructs a MorseTree and initializes it by reading Morse code data from a file.
     */
    public MorseTree() {
        root = new TreeNode<>();
        initializeTreeFromFile();
    }

    private void initializeTreeFromFile() {
        Scanner file;

        try {
            file = new Scanner(new FileInputStream("data.txt"));

            while (file.hasNextLine()) {
                String line = file.nextLine();
                char letter = line.charAt(0);
                String morseCode = line.substring(1).trim();
                add(morseCode, letter);
                System.out.println("Added: " + letter + " " + morseCode);
            }
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a Morse code and its corresponding character to the tree.
     *
     * @param morseStr The Morse code string.
     * @param letter   The character associated with the Morse code.
     */
    public void add(String morseStr, char letter) {
        root = insertInSubtree(morseStr, letter, root);
    }

    private TreeNode<Character> insertInSubtree(String morseStr, char letter, TreeNode<Character> subtree) {
        if (subtree == null) {
            subtree = new TreeNode<>();
        }

        if (morseStr.length() == 0) {
            subtree.data = letter;
        } else {
            char direction = morseStr.charAt(0);

            if (direction == '.') {
                subtree.right = insertInSubtree(morseStr.substring(1), letter, subtree.right);
            } else if (direction == '-') {
                subtree.left = insertInSubtree(morseStr.substring(1), letter, subtree.left);
            }
        }

        return subtree;
    }

    /**
     * Translates a Morse code string to its corresponding character.
     *
     * @param morseStr The Morse code string to be translated.
     * @return The translated character.
     */
    public Character translate(String morseStr) {
        return findInSubtree(morseStr, root);
    }

    private Character findInSubtree(String morseStr, TreeNode<Character> subtree) {
        if (subtree == null) {
            return null;
        }

        if (morseStr.isEmpty()) {
            return subtree.data;
        }

        char direction = morseStr.charAt(0);

        if (direction == '.') {
            return findInSubtree(morseStr.substring(1), subtree.right);
        } else if (direction == '-') {
            return findInSubtree(morseStr.substring(1), subtree.left);
        }

        return null;
    }

    /**
     * Translates a space-separated string of Morse code tokens to its corresponding characters.
     *
     * @param tokens The space-separated Morse code string.
     * @return The translated string of characters.
     */
    public String translateString(String tokens) {
        StringBuilder retVal = new StringBuilder();
        Scanner scanner = new Scanner(tokens);

        while (scanner.hasNext()) {
            String token = scanner.next();
            Character translatedChar = translate(token);

            if (translatedChar != null) {
                retVal.append(translatedChar);
            }
        }

        return retVal.toString();
    }

    /**
     * Converts a character to its Morse code representation.
     *
     * @param c The character to be converted.
     * @return The Morse code representation of the character.
     */
    public String toMorseCode(Character c) {
        return toMorseCodeHelper(c, root, "");
    }

    private String toMorseCodeHelper(Character c, TreeNode<Character> subtree, String path) {
        if (subtree == null) {
            return null;
        }

        if (subtree.data != null && subtree.data.equals(c)) {
            return path;
        }

        String leftPath = toMorseCodeHelper(c, subtree.left, path + "-");
        if (leftPath != null) {
            return leftPath;
        }

        return toMorseCodeHelper(c, subtree.right, path + ".");
    }

    /**
     * Returns a string representation of the tree by performing an inorder walk.
     *
     * @return The string representation of the tree.
     */
    public String toString() {
        return inorderWalk(root);
    }

    private String inorderWalk(TreeNode<Character> subtree) {
        StringBuilder result = new StringBuilder();

        if (subtree != null) {
            result.append(inorderWalk(subtree.left));
            result.append(subtree.data);
            result.append(inorderWalk(subtree.right));
        }

        return result.toString();
    }

    /**
     * Main method to test the MorseTree class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        MorseTree mt = new MorseTree();

        System.out.println(mt.translate("..."));
        System.out.println(mt.translate("---"));
        System.out.println(mt.translate(".......-"));

        System.out.println(mt.translateString("... --- ..."));
        System.out.println(mt.toMorseCode('S'));

    }

    /**
     * Inner class representing a tree node.
     *
     * @param <T> The type of data stored in the node.
     */
    private static class TreeNode<T> {
        T data;
        TreeNode<T> right;
        TreeNode<T> left;

    }
}
