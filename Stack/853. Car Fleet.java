class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets = 0;
        float[] time = new float[target];
        float maxTime = 0, currTime;
        for (int i = 0; i < position.length; i++) {
            time[position[i]] = (float) (target - position[i]) / speed[i];
        }

        for (int i = target - 1; i >= 0; i--) {
            currTime = time[i];
            if (currTime > maxTime) {
                maxTime = currTime;
                fleets++;
            }
        }
        return fleets;
    }
}