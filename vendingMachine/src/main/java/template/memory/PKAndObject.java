package template.memory;

public class PKAndObject<P, O> {

	private P pk;
	private O obj;
	
	
	public PKAndObject() {
	}
	public PKAndObject(P pk, O obj) {
		this.pk = pk;
		this.obj = obj;
	}
	
	
	public P getPk() {
		return pk;
	}
	public void setPk(P pk) {
		this.pk = pk;
	}
	public O getObj() {
		return obj;
	}
	public void setObj(O obj) {
		this.obj = obj;
	}
}
