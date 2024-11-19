public class Assignment
   implements Operation
{
   private String _id;
   private Expression _e;

   public Assignment(String id, Expression e)
   {
      _id = id;
      _e = e;
   }

   public double evaluate(Bindings bindings)
   {
      double value = _e.evaluate(bindings);
      bindings.addBinding(_id, value);
      return value;
   }

   public String toString()
   {
      return "set " + _id + " = " + _e;
   }

   public Expression simplifyAdditiveIdentity() {
      return this._e.simplifyAdditiveIdentity();
   }
   
   public Expression simplifyMultiplicativeIdentity() {
      return this._e.simplifyMultiplicativeIdentity();
   }

   public Expression simplifyMultiplicativeZero() {
      return this._e.simplifyMultiplicativeZero();
   }
}
