public interface Operation
{
   double evaluate(Bindings bindings);
   Expression simplifyAdditiveIdentity();
   Expression simplifyMultiplicativeIdentity();
   Expression simplifyMultiplicativeZero();
}
