class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = max(piles);

        int minK = Integer.MAX_VALUE;

        while(right >= left){
            int mid = (left + right)/2;
            int hoursTaken = getHoursTaken(piles, mid);
            
            if(hoursTaken <= h){
                // able to finish the pile within alloted time
                minK = Math.min(mid, minK);
                right = mid - 1; 
            }else{
                // not able to complete within alloted time
                //increase speed
                left = mid + 1;
            }
        }

        return minK;
    }

    // minK = 2
    // left = 1, right = 1, mid = 1

    public int max(int[] piles){
        int max = piles[0];
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        return max;
    }

    public int getHoursTaken(int[] piles, int speed){
        int hoursTaken = 0;
        for(int pile : piles){
            if(pile % speed == 0){
                hoursTaken += pile/speed;
            }else{
                hoursTaken += pile/speed + 1;
            }
        }
        return hoursTaken;
    }
}
