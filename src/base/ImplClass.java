package base;
public class ImplClass extends BaseClass implements IInterface {

	public void interfaceMethod() {
	}

	public void abstractMethod() {
	}
	
	public void implMethod() {
	}
	
	private void privateMethod(){
		
	}	
	
	//Member classes
	public class ImplClassPublicInnerClass {}
	private class ImplClassPrivateInnerClass {}
	protected class ImplClassProtectedInnerClass {}
	class ImplClassDefaultInnerClass {}
		
	private interface ImplClassPrivateInterface{}
	public interface ImplClassPublicInterface{}
	protected interface ImplClassProtectedInterface{}
	interface ImplClassDefaultInterface{}
	
	public enum ImplClassPublicEnum{}
	private enum ImplClassPrivateEnum{}
	protected enum ImplClassProtectedEnum{}
	enum ImplClassDefaultEnum{}
		
}
