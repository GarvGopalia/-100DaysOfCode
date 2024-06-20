import java.util.*;
public class MaxDistance {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = 1;
        int max = position[position.length - 1] - position[0];
        int result = 0;
        while(min <= max) {
            int mid = min + (max - min)/2;
            if(possible(mid,position,m)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return result;
    }

    public boolean possible(int mid, int[] position, int m) {
        int prev = position[0];
        int count = 1;
        for(int i=0; i<position.length; i++) {
            int curr = position[i];
            if(curr - prev >= mid) {
                count++;
                prev = curr;
            }
            if(count == m) {
                break;
            }
        }
        return count == m;
    }
}
