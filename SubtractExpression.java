public class SubtractExpression
   extends BinaryExpression
{
   public SubtractExpression(Expression lft, Expression rht)
   {
      super(lft, rht, "-");
   }

   protected double _applyOperator(double lft, double rht)
   {
      return lft - rht;
   }

   public Expression simplifyAdditiveIdentity() {
      return new SubtractExpression(lft.simplifyAdditiveIdentity(), rht.simplifyAdditiveIdentity());
   }

   public Expression simplifyMultiplicativeIdentity() {
      return new SubtractExpression(lft.simplifyMultiplicativeIdentity(), rht.simplifyMultiplicativeIdentity());
   }

   public Expression simplifyMultiplicativeZero() {
      return new SubtractExpression(lft.simplifyMultiplicativeZero(), rht.simplifyMultiplicativeZero());
   }
}