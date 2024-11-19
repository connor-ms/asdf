public class DoubleConstantExpression
   implements Expression
{
   private double val;
   public DoubleConstantExpression(double val)
   {
      this.val = val;
   }

   public String toString()
   {
      return String.valueOf(val);
   }

   public double evaluate(Bindings bindings)
   {
      return val;
   }

   public Expression simplifyAdditiveIdentity() {
      return this;
   }

   public Expression simplifyMultiplicativeIdentity() {
      return this;
   }

   public Expression simplifyMultiplicativeZero() {
      return this;
   }
}
