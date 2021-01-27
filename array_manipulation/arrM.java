/*ARRAY MANIPULATION IN JAVA:
* Methods:
* 1) Adding elements into array at position n
*       .add()
* ----------------------------------------------
* 2)
*
* */

public class arrM {

/*------.add() functions------*/
    /*Add integer*/
    public static int[] add(int[] arr, int in){
        int[] out = new int[arr.length+1];

        for(int i=0; i<arr.length; i++) out[i] = arr[i]; //copy arr elements into out
        out[arr.length] = in;

        return out;
    }

    public static int[] add(int[] arr, int in, int pos){
        int[] out = new int[arr.length+1];

        for(int i=0; i<pos; i++) out[i] = arr[i];
        out[pos] = in;
        for(int i=pos+1; i<out.length; i++) out[i] = arr[i-1];

        return out;
    }

    /*Add String*/
    public static String[] add(String[] arr, String in){
        String[] out = new String[arr.length+1];

        for(int i=0; i<arr.length; i++) out[i] = arr[i]; //copy arr elements into out
        out[arr.length] = in;

        return out;
    }

    public static String[] add(String[] arr, String in, int pos){
        String[] out = new String[arr.length+1];

        for(int i=0; i<pos; i++) out[i] = arr[i];
        out[pos] = in;
        for(int i=pos+1; i<out.length; i++) out[i] = arr[i-1];

        return out;
    }

    /*Add double*/
    public static double[] add(double[] arr, double in){
        double[] out = new double[arr.length+1];

        for(int i=0; i<arr.length; i++) out[i] = arr[i]; //copy arr elements into out
        out[arr.length] = in;

        return out;
    }

    public static double[] add(double[] arr, double in, int pos){
        double[] out = new double[arr.length+1];

        for(int i=0; i<pos; i++) out[i] = arr[i];
        out[pos] = in;
        for(int i=pos+1; i<out.length; i++) out[i] = arr[i-1];

        return out;
    }

    /*Add boolean*/
    public static boolean[] add(boolean[] arr, boolean in){
        boolean[] out = new boolean[arr.length+1];

        for(int i=0; i<arr.length; i++) out[i] = arr[i]; //copy arr elements into out
        out[arr.length] = in;

        return out;
    }

    public static boolean[] add(boolean[] arr, boolean in, int pos){
        boolean[] out = new boolean[arr.length+1];

        for(int i=0; i<pos; i++) out[i] = arr[i];
        out[pos] = in;
        for(int i=pos+1; i<out.length; i++) out[i] = arr[i-1];

        return out;
    }

    /*Add char*/
    public static char[] add(char[] arr, char in){
        char[] out = new char[arr.length+1];

        for(int i=0; i<arr.length; i++) out[i] = arr[i]; //copy arr elements into out
        out[arr.length] = in;

        return out;
    }

    public static char[] add(char[] arr, char in, int pos){
        char[] out = new char[arr.length+1];

        for(int i=0; i<pos; i++) out[i] = arr[i];
        out[pos] = in;
        for(int i=pos+1; i<out.length; i++) out[i] = arr[i-1];

        return out;
    }
}
