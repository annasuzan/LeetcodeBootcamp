package GraphStackAndQueues.NumberOfPeopleAwareOfSecret;

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long[] peopleWhoKnow = new long[n + 1];
        peopleWhoKnow[1] = 1;
        long countOfSharePeople = 0;
        for(int i = 2; i <= n; i++){
            if(i - delay > 0){
                countOfSharePeople = (countOfSharePeople + peopleWhoKnow[i - delay]) % MOD ;
            }
            if(i - forget > 0){
                countOfSharePeople = (countOfSharePeople - peopleWhoKnow[i - forget]) % MOD;
            }
            peopleWhoKnow[i] = countOfSharePeople;

        }

        long answer = 0;
        for(int i = n - forget + 1; i <= n; i++){
            answer = (answer + peopleWhoKnow[i] + MOD ) % MOD;
        }
        return (int) answer;
    }
}