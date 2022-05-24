class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put('6','9');map.put('9','6');
        map.put('1','1');map.put('0','0');
        map.put('8','8');
        
        StringBuilder s=new StringBuilder();
        for(int i=0;i<num.length();i++){
            if(!map.containsKey(num.charAt(i))) return false;
            s.append(map.get(num.charAt(i)));
        }
        
        String str=s.reverse().toString();
        return str.equals(num);
    }
}