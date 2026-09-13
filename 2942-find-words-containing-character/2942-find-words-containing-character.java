class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        ArrayList <Integer> list = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            String arr = words[i];
            char arr1[] = arr.toCharArray();
            for(int j = 0;j<arr1.length;j++){
                if(arr1[j] == x){
                    list.add(i); 
                    break;
                }
                
            }
            
        }
        return list;
    }
}