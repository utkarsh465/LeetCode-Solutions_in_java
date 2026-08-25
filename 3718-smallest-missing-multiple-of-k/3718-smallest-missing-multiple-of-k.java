class Solution {
    public int missingMultiple(int[] nums, int k) {
        ArrayList <Integer> arr = new ArrayList<>();
        int i = 0;
        for(i = 0; i < nums.length;i++){
            if(nums[i] % k == 0){
                arr.add(nums[i]);
            }    
        }
        Collections.sort(arr);
        // System.out.print(arr);
        int len = arr.size()+1;
        int arr1 [] = new int[len];
        for(int j = 0;j<arr1.length;j++){
            arr1[j] = k*(j+1);
        }
        // System.out.println(Arrays.toString(arr1));
        int[] num = new int[arr.size()];

        for(int n = 0; n < arr.size(); n++) {
            num[n] = arr.get(n);
        }
        ArrayList <Integer> array = new ArrayList<>();
        for(int l = 0; l < arr1.length; l++) {

            boolean found = false;

            for(int j = 0; j < num.length; j++) {

                if(arr1[l] == num[j]) {
                    found = true;
                    break;
                }
            }

            if(!found) {
                return arr1[l];
            }
        }
        // System.out.print(array);
        return Collections.min(array);
    }
}