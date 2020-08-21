class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        
        map.put(1,"I");
         map.put(2,"II");
         map.put(3,"III");
         map.put(4,"IV");
         map.put(5,"V");
         map.put(6,"VI");
         map.put(7,"VII");
         map.put(8,"VIII");
         map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        
        int i =0;
        String ans ="";
        while(num>0){
            int d = num%10;
            if(d == 0)
            {
                i++;
                num=num/10;
                continue;
            }
            
            if(i==0){
                ans+= map.get(d)+ ans;
            }
            else if(i==1){
                if(d<=3){
                    
                     ans= getR(d,"X")+ans;
                }
                else if(d==4){
                    ans= map.get(40)+ans;
                }
                else if(d<9){
                    ans="L"+getR(d-5,"X")+ans;
                }
                else{
                    ans= "XC"+ans;
                }
            }
            
            else if(i ==2){
                if(d<=3){
                    
                     ans= getR(d,"C")+ans;
                }
                else if(d==4){
                    ans= "CD"+ans;
                }
                else if(d<9){
                    ans="D"+getR(d-5,"C")+ans;
                }
                else{
                    ans= "CM"+ans;
                }
                
            }
            else{
                ans= getR(d,"M")+ans;
            }
            i++;
            num=num/10;
        }
        
        return ans;
        
    }
    
    
    String getR(int d ,String res){
        String ans ="";
        for(int i = 0;i <d;i++){
            ans+=res;
        }
        
        return ans;
    }
}


/*
create a map of special characters



*/
