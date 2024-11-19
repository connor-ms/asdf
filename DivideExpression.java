public class DivideExpression
   extends BinaryExpression
{
   public DivideExpression(Expression lft, Expression rht)
   {
      super(lft, rht, "/");
   }

   protected double _applyOperator(double lft, double rht)
   {
      return lft / rht;
   }

   public Expression simplifyAdditiveIdentity() {
      return new DivideExpression(lft.simplifyAdditiveIdentity(), rht.simplifyAdditiveIdentity());
   }

   public Expression simplifyMultiplicativeIdentity() {
      return new DivideExpression(lft.simplifyMultiplicativeIdentity(), rht.simplifyMultiplicativeIdentity());
   }

   public Expression simplifyMultiplicativeZero() {
      return new DivideExpression(lft.simplifyMultiplicativeZero(), rht.simplifyMultiplicativeZero());
   }
}