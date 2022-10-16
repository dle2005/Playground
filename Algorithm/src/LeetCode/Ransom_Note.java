package LeetCode;

public class Ransom_Note {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteAlp = new int[27];
        int[] magazineAlp = new int[27];

        for (char c : ransomNote.toCharArray()) {
            ransomNoteAlp[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            magazineAlp[c - 'a']++;
        }

        for (int idx = 0; idx < 27; idx++) {
            if (ransomNoteAlp[idx] > magazineAlp[idx]) {
                return false;
            }
        }

        return true;
    }
}
