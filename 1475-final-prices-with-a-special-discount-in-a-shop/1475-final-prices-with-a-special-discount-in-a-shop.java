class Solution {
    public int[] finalPrices(int[] prices) {
        int arr[] = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            for(int j = 1; j < prices.length; j++){
                if(j > i && prices[j] <= prices[i]){
                    arr[i] = prices[i] - prices[j];
                    break;
                }
                arr[i] = prices[i];
            }
        }
        return arr;
    }
}