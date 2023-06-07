package co.com.java;


/**
 * @author carlos.castiblanco
 *
 */

//Java program to illustrate the fact that
//runtime polymorphism cannot be achieved
//by data members

//class A
class A
{
	int x = 10;
}

//class B
class B extends A
{
	int x = 20;
}

public class MainJavaOOPOverrideConcept {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		A a = new B(); // object of type B

		// Data member of class A will be accessed
		System.out.println(a.x);

	}

}

//A Java program to illustrate Dynamic Method
//Dispatch using hierarchical inheritance
class D
{
	void m1()
	{
		System.out.println("Inside D's m1 method");
	}
}

class E extends D
{
	// overriding m1()
	void m1()
	{
		System.out.println("Inside E's m1 method");
	}
}

class F extends D
{
	// overriding m1()
	void m1()
	{
		System.out.println("Inside F's m1 method");
	}
}

//Driver class
class Dispatch
{
	public static void main(String args[])
	{
		// object of type D
		D d = new D();

		// object of type E
		E e = new E();

		// object of type F
		F f = new F();

		// obtain a reference of type D
		D ref;

		// ref refers to an D object
		ref = d;

		// calling D's version of m1()
		ref.m1();

		// now ref refers to a E object
		ref = e;

		// calling E's version of m1()
		ref.m1();

		// now ref refers to a F object
		ref = f;

		// calling F's version of m1()
		ref.m1();
	}
}

//A Simple Java program to demonstrate
//method overriding in java

//Base Class
class Parent {
	void show() { System.out.println("Parent's show()"); }
}

//Inherited class
class Child extends Parent {
	// This method overrides show() of Parent
	@Override void show()
	{
		System.out.println("Child's show()");
	}
}

//Driver class
class Main {
	public static void main(String[] args)
	{
		// If a Parent type reference refers
		// to a Parent object, then Parent's
		// show is called
		Parent obj1 = new Parent();
		obj1.show();

		// If a Parent type reference refers
		// to a Child object Child's show()
		// is called. This is called RUN TIME
		// POLYMORPHISM.
		Parent obj2 = new Child();
		obj2.show();
	}
}

//A Simple Java program to demonstrate
//Overriding and Access-Modifiers

class Parents {
	// private methods are not overridden
	private void m1()
	{
		System.out.println("From parent m1()");
	}

	protected void m2()
	{
		System.out.println("From parent m2()");
	}
}

class Childs extends Parents {
	// new m1() method
	// unique to Child class
	private void m1()
	{
		System.out.println("From child m1()");
	}

	// overriding method
	// with more accessibility
	@Override public void m2()
	{
		System.out.println("From child m2()");
	}
}

//Driver class
class Mains {
	public static void main(String[] args)
	{
		Parents obj1 = new Parents();
		obj1.m2();
		Parents obj2 = new Childs();
		obj2.m2();
	}
}


//A Java program to demonstrate that
//final methods cannot be overridden

class Parentp {
	// Can't be overridden
	final void show() {}
}

class Childp extends Parentp {
	// This would produce error
	void show() {}
}

//Java program to show that
//if the static method is redefined by
//a derived class, then it is not
//overriding, it is hiding

class Parenth {
	// Static method in base class
	// which will be hidden in subclass
	static void m1()
	{
		System.out.println("From parent "
						+ "static m1()");
	}

	// Non-static method which will
	// be overridden in derived class
	void m2()
	{
		System.out.println(
			"From parent "
			+ "non - static(instance) m2() ");
	}
}

class Childh extends Parenth {
	// This method hides m1() in Parent
	static void m1()
	{
		System.out.println("From child static m1()");
	}

	// This method overrides m2() in Parent
	@Override public void m2()
	{
		System.out.println(
			"From child "
			+ "non - static(instance) m2() ");
	}
}

//Driver class
class Mainh {
	public static void main(String[] args)
	{
		Parenth obj1 = new Childh();

		// As per overriding rules this
		// should call to class Child static
		// overridden method. Since static
		// method can not be overridden, it
		// calls Parent's m1()
		obj1.m1();

		// Here overriding works
		// and Child's m2() is called
		obj1.m2();
	}
}

class SuperClass {
	private void privateMethod()
	{
		System.out.println(
			"This is a private method in SuperClass");
	}

	public void publicMethod()
	{
		System.out.println(
			"This is a public method in SuperClass");
		privateMethod();
	}
}

class SubClass extends SuperClass {
	// This is a new method with the same name as the
	// private method in SuperClass
	private void privateMethod()
	{
		System.out.println(
			"This is a private method in SubClass");
	}

	// This method overrides the public method in SuperClass
	public void publicMethod()
	{
		System.out.println(
			"This is a public method in SubClass");
		privateMethod(); // calls the private method in
						// SubClass, not SuperClass
	}
}

class Test {
	public static void main(String[] args)
	{
		SuperClass obj1 = new SuperClass();
		obj1.publicMethod(); // calls the public method in
							// SuperClass

		SubClass obj2 = new SubClass();
		obj2.publicMethod(); // calls the overridden public
							// method in SubClass
	}
}


class SuperClassc {
	public Object method()
	{
		System.out.println(
			"This is the method in SuperClass");
		return new Object();
	}
}

class SubClassc extends SuperClassc {
	public String method()
	{
		System.out.println(
			"This is the method in SubClass");
		return "Hello, World!";
	}
}

class Testc {
	public static void main(String[] args)
	{
		SuperClassc obj1 = new SuperClassc();
		obj1.method();

		SubClassc obj2 = new SubClassc();
		obj2.method();
	}
}

//A Java program to demonstrate that overridden
//method can be called from sub-class

//Base Class
class Parentss {
	void show() { System.out.println("Parent's show()"); }
}

//Inherited class
class Childss extends Parentss {
	// This method overrides show() of Parent
	@Override void show()
	{
		super.show();
		System.out.println("Child's show()");
	}
}

//Driver class
class Mainss {
	public static void main(String[] args)
	{
		Parent obj = new Child();
		obj.show();
	}
}

/* Java program to demonstrate overriding when
superclass method does not declare an exception
*/

class Parentt {
	void m1() { System.out.println("From parent m1()"); }

	void m2() { System.out.println("From parent m2()"); }
}

class Childt extends Parentt {
	@Override
	// no issue while throwing unchecked exception
	void m1() throws ArithmeticException
	{
		System.out.println("From child m1()");
	}

	@Override
	// compile-time error
	// issue while throwing checked exception
	void m2() throws Exception
	{
		System.out.println("From child m2");
	}
}

//Java program to demonstrate overriding when
//superclass method does declare an exception

class Parentee {
	void m1() throws RuntimeException
	{
		System.out.println("From parent m1()");
	}
}

class Child1 extends Parentee {
	@Override
	// no issue while throwing same exception
	void m1() throws RuntimeException
	{
		System.out.println("From child1 m1()");
	}
}
class Child2 extends Parentee {
	@Override
	// no issue while throwing subclass exception
	void m1() throws ArithmeticException
	{
		System.out.println("From child2 m1()");
	}
}
class Child3 extends Parentee {
	@Override
	// no issue while not throwing any exception
	void m1()
	{
		System.out.println("From child3 m1()");
	}
}
class Child4 extends Parentee {
	@Override
	// compile-time error
	// issue while throwing parent exception
	void m1() throws Exception
	{
		System.out.println("From child4 m1()");
	}
}

//A Java program to demonstrate
//multi-level overriding

//Base Class
class Parento {
	void show() { System.out.println("Parent's show()"); }
}

//Inherited class
class Childo extends Parento {
	// This method overrides show() of Parent
	void show() { System.out.println("Child's show()"); }
}

//Inherited class
class GrandChildo extends Childo {
	// This method overrides show() of Parent
	void show()
	{
		System.out.println("GrandChild's show()");
	}
}

//Driver class
class Maino {
	public static void main(String[] args)
	{
		Parento obj1 = new GrandChildo();
		obj1.show();
	}
}

//A Simple Java program to demonstrate application
//of overriding in Java

//Base Class
class Employeee {
	public static int base = 10000;
	int salary() { return base; }
}

//Inherited class
class Managere extends Employeee {
	// This method overrides salary() of Parent
	int salary() { return base + 20000; }
}

//Inherited class
class Clerke extends Employeee {
	// This method overrides salary() of Parent
	int salary() { return base + 10000; }
}

//Driver class
class Maine {
	// This method can be used to print the salary of
	// any type of employee using base class reference
	static void printSalary(Employeee e)
	{
		System.out.println(e.salary());
	}

	public static void main(String[] args)
	{
		Employeee obj1 = new Managere();

		// We could also get type of employee using
		// one more overridden method.loke getType()
		System.out.print("Manager's salary : ");
		printSalary(obj1);

		Employeee obj2 = new Clerke();
		System.out.print("Clerk's salary : ");
		printSalary(obj2);
	}
}
