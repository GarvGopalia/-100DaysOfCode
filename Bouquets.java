public class Bouquets {
    public int canMakeBouq(int[] bloomDay, int mid, int k) {
        int bouqCount = 0;
        int count = 0;

        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if(count == k) {
                bouqCount++;
                count = 0;
            }
        }
        return bouqCount;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int start_day = Integer.MAX_VALUE;        
        int end_day = Integer.MIN_VALUE;        
        for(int day:bloomDay) {
            start_day = Math.min(start_day, day);
            end_day = Math.max(end_day, day);
        }

        int minDays = -1;
        while(start_day <= end_day) {
            int mid = start_day + (end_day - start_day)/2;

            if(canMakeBouq(bloomDay, mid, k) >= m) {
                minDays = mid;
                end_day = mid-1;
            } else {
                start_day = mid+1;
            }
        }
        return minDays;
    }
}