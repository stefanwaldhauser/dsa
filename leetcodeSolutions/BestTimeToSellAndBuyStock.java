class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int maxProfit = 0;
        while(buy <= prices.length - 1) {
            int sell = buy + 1;
            while(sell <= prices.length - 1) {
                int profit = prices[sell] - prices[buy];
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
                sell++;
            }
            buy++;
        }
        return maxProfit;
    }
}

// Time Complexity: O(N^2)
// Space Complexity: O(1)



class Solution {
    public int maxProfit(int[] prices) {
    int maxProfit = 0;    
    int b = 0;
    int s = b + 1;
    while(s <= prices.length - 1) {
        // we have found a new cheaper buy price. It makes no sense to keep the old buy price
        // waste of computing resources as everything with the cheaper buy price will lead to a higher profit
        // move buy price
        if(prices[s] <= prices[b]) {
            b = s;
            s = b+1;
        } else {
            // profit as sell prices > buy price
            int profit = prices[s] - prices[b];
            if(profit > maxProfit) {
                maxProfit = profit;
            }
            s++;
        }
    }   
    return maxProfit;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)