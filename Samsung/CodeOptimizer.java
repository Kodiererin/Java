import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class CodeOptimizer {
    public static void main(String[] args) {
        // Input source code
        String sourceCode = "public class Main { public static void main(String[] args) { int result = 2 + 3 * 4; System.out.println(result); } }";

        // Parse the source code
        CompilationUnit cu = JavaParser.parse(sourceCode);

        // Apply optimization
        ConstantFoldingOptimizer optimizer = new ConstantFoldingOptimizer();
        optimizer.visit(cu, null);

        // Print the optimized code
        System.out.println(cu.toString());
    }

    static class ConstantFoldingOptimizer extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(BinaryExpr expr, Void arg) {
            super.visit(expr, arg);

            // Check if both operands are literals (constants)
            if (expr.getLeft().isLiteralExpr() && expr.getRight().isLiteralExpr()) {
                Expression optimizedExpr = expr.calculateResolvedValue();
                expr.replace(optimizedExpr);
            }
        }
    }
}
