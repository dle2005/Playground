package LeetCode;

public class Length_of_Last_Word {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();

        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
