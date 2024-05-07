package cn.dsxriiiii.DataStructure.StringStructure;

public class StringGetter {
    public static void main(String[] args) {
        String string = "abc";
        StringGetter stringGetter = new StringGetter();
        String result = stringGetter.reverseString(string);
        String result_By_Builder = stringGetter.reverseStringByBuilder(string);
        System.out.println(result_By_Builder);
        System.out.println(result);
    }
    public String reverseStringByBuilder(String string){
        StringBuilder reversed = new StringBuilder(string);
        return reversed.reverse().toString();
    }
    public String reverseString(String string){
        char[] StringArray = string.toCharArray();
        for (int i = 0,j = StringArray.length - 1 ; i < StringArray.length/2; i++,j--) {
            char temp = StringArray[i];
            StringArray[i] = StringArray[j];
            StringArray[j] = temp;
        }
        return new String(StringArray);
    }
}
