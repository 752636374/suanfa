package 牛客网.二期.yaoheng.class_06;

/**
 * 在每一次调用中选择左侧或右侧的卡牌，并返回差值作为得分。最后，使用Math.max方法来比较左侧和右侧的得分，返回较大的得分值。main方法用于测试示例输入。
 */
public class CardsInLine2 {
    public static int maxScore(int[] cards) {
        return calculateMaxScore(cards, 0, cards.length - 1);
    }

    private static int calculateMaxScore(int[] cards, int left, int right) {
        if (left == right) {
            return cards[left];
        }

        int scoreLeft = cards[left] - calculateMaxScore(cards, left + 1, right);
        int scoreRight = cards[right] - calculateMaxScore(cards, left, right - 1);

        return Math.max(scoreLeft, scoreRight);
    }

    public static void main(String[] args) {
        int[] cards = {1, 2, 3, 4, 5};
        int maxScore = maxScore(cards);
        System.out.println("Max Score: " + maxScore);
    }
}
