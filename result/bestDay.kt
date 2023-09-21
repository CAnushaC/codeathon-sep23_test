fun findMaxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) {
        return -1
    }

    var minPrice = prices[0]
    var maxProfit = -1

    var buyDay = 0
    var sellDay = 0

    for (i in 1 until prices.size) {
        val currentPrice = prices[i]

        if (currentPrice < minPrice) {
            minPrice = currentPrice
            buyDay = i
        } else {
            val potentialProfit = currentPrice - minPrice
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit
                sellDay = i
            }
        }
    }

    if (maxProfit > 0) {
        println("Buy on day ${buyDay + 1} at price ${prices[buyDay]}")
        println("Sell on day ${sellDay + 1} at price ${prices[sellDay]}")
        println("Max profit: $maxProfit")
    }

    return maxProfit
}

fun main() {
    val prices = intArrayOf(100, 180, 260, 310, 40, 535, 695)
    val maxProfit = findMaxProfit(prices)
    if (maxProfit == -1) {
        println("No profit can be made.")
    }
}
