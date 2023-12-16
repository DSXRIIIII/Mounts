package cn.dsxriiiii.PowerPointOffer;



/*
* LCR 117 相似字符串组
* 考察并查集算法，其中union方法和similar方法分别实现了判断是否为同一祖先节点和判断是否满足相似条件的功能
*
*
* */
public class SimilarStringArray {
    public int numSimilarGroups(String[] strings){
        int groups = strings.length;
        int[] fathers = new int[strings.length];
        for(int i = 0; i < strings.length; ++i){
            fathers[i] = i;
        }
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if(similar(strings[i],strings[j]) && union(fathers,i,j)){
                    groups--;
                }
            }
        }
        return groups;
    }
    public static boolean similar(String str1, String str2){
        int diffCount = 0;
        for(int i = 0 ;i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diffCount++;
            }
        }
        return diffCount <= 2;
    }
    public static boolean union(int[] fathers,int i, int j){
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if(fatherOfI != fatherOfJ){
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }
    public static int findFather(int[] fathers, int i){
        if(fathers[i] != i){
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

    public static void main(String[] args) {
        SimilarStringArray similarStringArray = new SimilarStringArray();
        int Result = similarStringArray.numSimilarGroups(new String[]{"tars","rats","arts","star"});
        System.out.println(Result);
    }
}
