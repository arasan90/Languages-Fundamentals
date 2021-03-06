public class findStringFromNumberGeneric {

    public static void main(String[] args){
        char[] alphabet = args[0].toCharArray();
        int c = alphabet.length;
        int n = Integer.parseInt(args[1]);
        if (n == 0)
            System.out.println("");
        else {
            int charsNumber = findNumberOfChars(n, c);     //find n. of chars to represent the associated string
            int realn = n;                                 //find the offset to find the correct string
            for(int i = charsNumber-1;i>0;i--){
                realn= realn - (int)Math.pow(c,i);
            }
            numberToString(realn-1, alphabet, c, charsNumber);
        }
    }

    /*
    findNumberOfChars returns the number of characters needed to print
    the string with the chosen number sequence.
     */
    private static int findNumberOfChars(int n, int c){
        int result = 1; //number of chars
        int poss = (int)Math.pow(c,result);   //max number with 'result' chars
        while (poss < n){
            result++;
            poss = poss + (int)Math.pow(c, result); //add the new possibilities to the prev result
        }
        return result;
    }

    /*
    numberToString prints the String of the selected number
    in the sequence that can be generated by the chosen alphabet.
     */
    private static void numberToString(int n, char[] a, int c, int chars){
        char[] result = new char[chars];
        for(int i = 0; i < chars; i++){         //initialize the output array
            result[i]='0';
        }
        for(int i = chars-1; i > -1; i--){      //check modulus to pick the correct value from alphabet
            result[i] = a[n%c];
            n=n/c;
        }

        for(int i = 0; i < chars; i++){         //print the array in order
            System.out.print(result[i]);
        }
        System.out.println("");

    }
}
