class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
       char a[] = allowed.toCharArray();
       int count = 0;
       for(int i = 0; i < words.length; i++){
        String k = words[i];
        char s[] = k.toCharArray(); 
        boolean consistent = true;
        for(int j = 0; j < s.length; j++){
            boolean found = false;
            for(int x = 0; x < a.length; x++){

                if(s[j] == a[x]){
                    found = true;
                    break;
                }
            }
            if(!found){
                consistent = false;
                break;
            }
        }
        if(consistent){
            count++;
        }
       }
       return count;  
    }
}