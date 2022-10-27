package LeetCode;

public class Excel_Sheet_Column_Title {
    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber != 0) {
            sb.insert(0, (char)('A' + --columnNumber % 26));
            columnNumber /= 26;
        }

        return sb.toString();
    }
}
