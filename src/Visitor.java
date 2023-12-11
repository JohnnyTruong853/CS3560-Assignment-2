public interface Visitor {
    String visit(TotalStats totalStats);

    String visit(MessageTotal messageTotal);

    String visit(PositiveMessage positiveMessage);
}
