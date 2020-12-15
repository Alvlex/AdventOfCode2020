package Question15;

import java.util.HashMap;

class Sequence {
    private HashMap<Long, Long> lastPosition = new HashMap<>();
    private long currentPos = 1;

    long addNum(long x){
        Long y = lastPosition.put(x, currentPos);
        currentPos ++;
        if (y != null)
            return currentPos - y - 1;
        else
            return 0;
    }

    long getCurrentPos(){
        return currentPos;
    }


}
