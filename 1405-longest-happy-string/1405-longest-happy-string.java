class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb=new StringBuilder(); 
        int acnt=0;int bcnt=0;int ccnt=0;
        int size=a+b+c;
        for(int i=0;i<size;i++){
            if((a>=b&&a>=c&&acnt!=2)||(bcnt==2&&a>0)||(ccnt==2&&a>0)){
                sb.append('a');
                a--;
                acnt++;
                ccnt=0;
                bcnt=0;
            }else if((b>=a&&b>=c&&bcnt!=2)||(acnt==2&&b>0)||(ccnt==2&&b>0)){
                sb.append('b');
                b--;
                bcnt++;
                acnt=0;
                ccnt=0;
            }else if((c>=a&&c>=b&&ccnt!=2)||(acnt==2&&c>0)||(bcnt==2&&c>0)){
                sb.append('c');
                c--;
                ccnt++;
                acnt=0;
                bcnt=0;
            }
        }
        
        return sb.toString();
    }
}