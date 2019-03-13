import org.jetbrains.annotations.NotNull;

public class findNumberFromStringGeneric {

    public static void main(@NotNull String[] args){
        if (args.length == 1)                   //check if there is no second string in input
            System.out.println(0);
        else {
            String in = args[0];
            int c = in.length();
            char[] alphabet = in.toCharArray();
            String l = args[1];
            if (l == "")
                System.out.println(0);
            else {
                int charsNumber = l.length();
                StringToNumber(l, charsNumber, alphabet, c);
            }
        }

    }

    private static void StringToNumber(String l, int c, char[] a, int card){
        int result = 0;
        for(int i =0; i < c; i++){
            result = result + (int)Math.pow(card,i);       //set the offset for the number
        }

        for(int i = 0; i < c; i++){
            int position = findValue(a, l.charAt(i), card);         //calculate the value of every symbol
            result = result + position*(int)Math.pow(card,c-i-1);
        }
        System.out.println(result);
    }

    private static int findValue (char[] a, char c, int card){
        int result = -1;
        for(int i = 0; i<card;i++) {        //pick the right position in the alphabet
            if (c == a[i])
                result = i;
        }
        if (result == -1)
            System.out.println("Simbolo non definito nell'alfabeto");
        return result;
    }

}
