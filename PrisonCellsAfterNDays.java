class Solution {

    public int[] prisonAfterNDays(int[] cells, int N) {
        
        int num = 0;
        HashMap <Integer, Integer> dayToNextDay = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            num += cells[7 - i] * (int) Math.pow(2, i);
        }
        
        int day = 1;
        while (day <= N) {
            int cur = num;
            if (dayToNextDay.containsKey(cur)) {
                int repeatDays = day - dayToNextDay.get(cur);
                int remainingDays = N - day;
                N = remainingDays % repeatDays;
                N += 1;
                day = 1;
                dayToNextDay.clear();
                continue;
            } else {
                int leftShiftNum = num >> 1;
                int rightShiftNum = num << 1;
                rightShiftNum = rightShiftNum & 255;
                num = leftShiftNum ^ rightShiftNum;
                num = ~num & 255;
                num &= ~(1 << 0);
                num &= ~(1 << 7);
                dayToNextDay.put(cur, day);
            }
            day++;
        }
        
        for (int i = 0; i < 8; i++) {
            cells[7 - i] = num % 2;
            num /= 2;
        }
        return cells;
    }
}
