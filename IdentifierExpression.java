public class IdentifierExpression
   implements Expression
{
   private String id;

   public IdentifierExpression(String id)
   {
      this.id = id;
   }

   public String toString()
   {
      return id;
   }

   public double evaluate(Bindings bindings)
   {
      return bindings.lookupBinding(id);
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