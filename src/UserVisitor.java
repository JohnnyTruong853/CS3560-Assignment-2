/*
 * Visitor that visits users, user groups, and total stats
 */

public class UserVisitor implements Visitor {

    public String visit(TotalStats totalStats) {
        return "" + totalStats.getUserTotal();
    }
    public String visitGroupTotal(TotalStats totalStats) {
        return "" + totalStats.getGroupTotal();
    }
    public String visit(MessageTotal messageTotal) {
        return "" + messageTotal.getMessageTotal();
    }

    public String visit(PositiveMessage positiveMessage) {
        return positiveMessage.getPositiveMessagePercent();
    }
}
