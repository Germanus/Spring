package my.ilya.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class MethodInterceptorMain {
  public static void main(String[] args){
    MyClass target = new MyClass();

    NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
    pc.addMethodName("foo");
    pc.addMethodName("bar");
    Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

    ProxyFactory pf = new ProxyFactory();
    pf.setTarget(target);
    pf.addAdvisor(advisor);
    MyClass proxy = (MyClass)pf.getProxy();

    proxy.foo();
    proxy.foo(1);
    proxy.bar();
    proxy.yup();
  }
}
class SimpleAdvice implements MethodInterceptor {

  public Object invoke(MethodInvocation invocation) throws Throwable {
      System.out.println("start: " + invocation.getMethod().getName());
      Object retVal = invocation.proceed();
      System.out.println("end");
      return retVal;
  }
}

class MyClass {

  public void foo() {
      System.out.println("foo");
  }

  public void foo(int x) {
      System.out.println("foo " + x);
  }

  public void bar() {
      System.out.println("bar");
  }

  public void yup() {
      System.out.println("yup");
  }
}