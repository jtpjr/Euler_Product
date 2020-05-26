public class Test_Expression_Generation {
    public static void main(String[] args) {
        Expression_Builder expression_builder = new Expression_Builder();

        int numExpressionsToGen = 10;

        for (int i = 0; i < numExpressionsToGen; i++) {
            System.out.println(expression_builder.getExpression());
        }
    }
}
