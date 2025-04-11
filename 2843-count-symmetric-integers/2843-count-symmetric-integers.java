class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int result=0;
        for(int i=low;i<=high;i++){
            String digit = String.valueOf(i);
            int len = digit.length();
            if(len%2==0){
                int sum1=0,sum2=0;
                int half=len/2;
                for(int j=0;j<half;j++){
                    sum1+=Character.getNumericValue(digit.charAt(j));
                }
                for(int k=half;k<len;k++){
                    sum2+=Character.getNumericValue(digit.charAt(k));
                }
                if(sum1==sum2){
                    result+=1;
                    // sum1=sum2=0;
                }
            }
        }
        return result;
    }
}