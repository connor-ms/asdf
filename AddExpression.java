public class AddExpression
   extends BinaryExpression
{
   public AddExpression(Expression lft, Expression rht)
   {
      super(lft, rht, "+");
   }

   protected double _applyOperator(double lft, double rht)
   {
      return lft + rht;
   }

   public Expression simplifyAdditiveIdentity() {
      Expression simplifiedLft = lft.simplifyAdditiveIdentity();
      Expression simplifiedRht = rht.simplifyAdditiveIdentity();

      if (simplifiedLft.evaluate(null) == 0) {
         return simplifiedRht;
      }

      if (simplifiedRht.evaluate(null) == 0) {
         return simplifiedLft;
      }

      return new AddExpression(simplifiedLft, simplifiedRht);
   }

   public Expression simplifyMultiplicativeIdentity() {
      return new AddExpression(lft.simplifyMultiplicativeIdentity(), rht.simplifyMultiplicativeIdentity());
   }

   public Expression simplifyMultiplicativeZero() {
      return new AddExpression(lft.simplifyMultiplicativeZero(), rht.simplifyMultiplicativeZero());
   }
}