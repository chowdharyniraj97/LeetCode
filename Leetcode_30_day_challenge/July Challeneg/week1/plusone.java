class Solution {
    public int[] plusOne(int[] digit) {
        int carry=0;
        boolean first=true;
        for(int i=digit.length-1;i>=0;i--){
            if(first ){
                if(digit[i]+1>9){
                     carry=1;
                digit[i]=0;
                
                }
                else{
                    digit[i]++;
                }
                first=false;
               
            }
            else if(carry==1){
                if(digit[i]+1>9){
                carry=1;
                digit[i]=0;
              }
            else{
                carry=0;
                digit[i]++;
            }
          }
            else 
                break;
        }
        
        if(carry==1){
            int x[]=new int[digit.length+1];
            
            for(int i=1,j=0;i<x.length;i++){
               x[i]= digit[j++];
            }
            x[0]=1;
            return x;
        }
        return digit;
    }
}
