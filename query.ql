// custom-security-query.ql
import java

from
  Method method,
  Expression parameter
where
  method.getNumberOfParameters() > 5 and
  parameter.getType().(ArrayType).getElementType().(ClassType).getASingleMemberClass().getExtension().equals("Remote") or
  parameter.getType().(ArrayType).getElementType().(ClassType).getASingleMemberClass().getExtension().equals("Session")
select method, "Potential security vulnerability: " + method.getName() + " contains a parameter of sensitive type"
