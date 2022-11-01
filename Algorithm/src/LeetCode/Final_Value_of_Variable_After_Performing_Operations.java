package LeetCode;

public class Final_Value_of_Variable_After_Performing_Operations {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));
        System.out.println(finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"}));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int output = 0;

        for (String operation : operations) {
            output += operation.equals("++X") || operation.equals("X++") ? 1 : -1;
        }

        return output;
    }
}
