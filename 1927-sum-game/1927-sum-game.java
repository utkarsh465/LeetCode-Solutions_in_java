class Solution {
    public boolean sumGame(String num) {
        int length=num.length();
        int leftQuestionMarks=0;
        int rightQuestionMarks=0;
        int leftSum=0;
        int rightSum=0;

        for(int i=0;i<length/2;i++){
            if(num.charAt(i)=='?')
            leftQuestionMarks++;
            else
            leftSum+=num.charAt(i)-'0';
        }

        for(int i=length/2;i<length;i++){
            if(num.charAt(i)=='?')
            rightQuestionMarks++;
            else
            rightSum+=num.charAt(i)-'0';
        }

        if((leftQuestionMarks+rightQuestionMarks)%2==1)
        return true;

        int questionDifference = 9*(rightQuestionMarks-leftQuestionMarks)/2;
        return leftSum-rightSum != questionDifference;
    }
}