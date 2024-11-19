public class MultiplyExpression
   extends BinaryExpression
{
   public MultiplyExpression(Expression lft, Expression rht)
   {
      super(lft, rht, "*");
   }

   protected double _applyOperator(double lft, double rht)
   {
      return lft * rht;
   }

   public Expression simplifyAdditiveIdentity() {
      return new MultiplyExpression(lft.simplifyAdditiveIdentity(), rht.simplifyAdditiveIdentity());
   }

   public Expression simplifyMultiplicativeIdentity() {
      Expression simplifiedLeft = lft.simplifyMultiplicativeIdentity();
      Expression simplifiedRight = rht.simplifyMultiplicativeIdentity();

      if (simplifiedLeft instanceof DoubleConstantExpression && ((DoubleConstantExpression) simplifiedLeft).evaluate(null) == 1) {
         return simplifiedRight;
      }

      if (simplifiedRight instanceof DoubleConstantExpression && ((DoubleConstantExpression) simplifiedRight).evaluate(null) == 1) {
         return simplifiedLeft;
      }

      return new MultiplyExpression(simplifiedLeft, simplifiedRight);
   }

   public Expression simplifyMultiplicativeZero() {
      Expression simplifiedLeft = lft.simplifyMultiplicativeZero();
      Expression simplifiedRight = rht.simplifyMultiplicativeZero();

      if ((simplifiedLeft instanceof DoubleConstantExpression && ((DoubleConstantExpression) simplifiedLeft).evaluate(null) == 0) ||
         (simplifiedRight instanceof DoubleConstantExpression && ((DoubleConstantExpression) simplifiedRight).evaluate(null) == 0)
      ) {
         return new DoubleConstantExpression(0);
      }

      return new MultiplyExpression(simplifiedLeft, simplifiedRight);
   }
}