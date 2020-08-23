class Solution {
    public int romanToInt(String s) {
        int ans =0;
        int i =0;
        while(i<s.length()){
            char c =  s.charAt(i);
            
            if(c == 'M'){
                int count=0;
                while(i<s.length() && s.charAt(i)=='M'){
                    count++;
                    i++;
                }
                ans += 1000*count;
            }
            
            else if(c == 'C'){

                if(i+1<s.length() && s.charAt(i+1)=='C'){
                     int count=0;
                    while(i<s.length() && s.charAt(i)=='C'){
                        count++;
                        i++;
                    }
                     ans += 100*count;
                }
                else if(i+1<s.length() && s.charAt(i+1)=='D'){
                    ans+=400;
                    i+=2;
                }
                else if(i+1<s.length() && s.charAt(i+1)=='M'){
                    ans+=900;
                    i+=2;
                }
                else{
                    ans+=100;
                    i++;
                }
            }
            
            else if(c =='D'){
                ans+=500;
                i++;
                if(i<s.length() && s.charAt(i)=='C'){
                    int count=0;
                    while(i<s.length() && s.charAt(i) =='C'){
                        count++;
                        i++;
                    }
                     ans += 100*count;
            }
            }
            
            else if(c == 'X'){

                if(i+1<s.length() && s.charAt(i+1)=='X'){
                     int count=0;
                    while(i<s.length() && s.charAt(i)=='X'){
                        count++;
                        i++;
                    }
                     ans += 10*count;
                }
                else if(i+1<s.length() && s.charAt(i+1)=='L'){
                    ans+=40;
                    i+=2;
                }
                else if(i+1<s.length() && s.charAt(i+1)=='C'){
                    ans+=90;
                    i+=2;
                }
                else{
                    ans+=10;
                    i++;
                }
            }
                else if(c =='L'){
                ans+=50;
                i++;
                if(i<s.length() && s.charAt(i)=='X'){
                    int count=0;
                    while(i<s.length() && s.charAt(i) =='X'){
                        count++;
                        i++;
                    }
                     ans += 10*count;
            }
            
            
        }
                
                 else if(c == 'I'){

                if(i+1<s.length() && s.charAt(i+1)=='I'){
                     int count=0;
                    while(i<s.length() && s.charAt(i)=='I'){
                        count++;
                        i++;
                    }
                     ans += 1*count;
                }
                else if(i+1<s.length() && s.charAt(i+1)=='V'){
                    ans+=4;
                    i+=2;
                }
                else if(i+1<s.length() && s.charAt(i+1)=='X'){
                    ans+=9;
                    i+=2;
                }
                     else{
                        ans+=1;
                    i++; 
                     }
            }
                else{
                ans+=5;
                i++;
                if(i<s.length() && s.charAt(i)=='I'){
                    int count=0;
                    while(i<s.length() && s.charAt(i) =='I'){
                        count++;
                        i++;
                    }
                     ans += 1*count;
            }
                }
       
            
}
        return ans;
    }
}
