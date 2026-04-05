class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPileValue = piles[0];
        for(int pile : piles){
            maxPileValue = Math.max(maxPileValue, pile);
        }

        int left = 1, right = maxPileValue, smallestSpeed = maxPileValue;

        while(right >= left){
            int mid = (left + right)/2;
            int hoursTaken = calculateHours(piles, mid);
            if(h < hoursTaken){
                left = mid + 1;
            }else{
                right = mid - 1;
                smallestSpeed = Math.min(smallestSpeed, mid);
            }
        }

        return smallestSpeed;
    }

    public int calculateHours(int[] piles, int speed){
        int hours = 0;
        for(int pile : piles){
            hours = hours + pile/speed + (pile % speed != 0 ? 1 : 0);
        }
        return hours;
    }

}
