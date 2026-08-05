import java.util.*;

class Solution {
    int[] demand;
    int[] fuel;
    int limit;
    HashMap<Long, Boolean> memo;

    public int minMaxWaitingTime(int[] demand, int[] fuel) {
        this.demand = demand;
        this.fuel = fuel;

        int n = demand.length;

        // Find maximum number of cars that can be served.
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (canServe(mid, 20))
                lo = mid;
            else
                hi = mid - 1;
        }

        int served = lo;
        if (served == 0) return -1;

        // Binary search minimum possible maximum waiting time.
        int left = 0, right = 20;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canServe(served, mid))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean canServe(int cars, int maxWait) {
        limit = cars;
        memo = new HashMap<>();
        return dfs(0, fuel[0], fuel[1], 0, 0, maxWait);
    }

    private boolean dfs(int idx, int f0, int f1, int r0, int r1, int maxWait) {
        if (idx == limit) return true;

        long key = encode(idx, f0, f1, r0, r1);
        if (memo.containsKey(key))
            return memo.get(key);

        int need = demand[idx];

        // Assign to dispenser 0
        if (f0 >= need && r0 <= maxWait) {
            if (dfs(idx + 1,
                    f0 - need,
                    f1,
                    need,
                    Math.max(0, r1 - r0),
                    maxWait)) {
                memo.put(key, true);
                return true;
            }
        }

        // Assign to dispenser 1
        if (f1 >= need && r1 <= maxWait) {
            if (dfs(idx + 1,
                    f0,
                    f1 - need,
                    Math.max(0, r0 - r1),
                    need,
                    maxWait)) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private long encode(int idx, int f0, int f1, int r0, int r1) {
        long key = idx;
        key = key * 51 + f0;
        key = key * 51 + f1;
        key = key * 21 + r0;
        key = key * 21 + r1;
        return key;
    }
}