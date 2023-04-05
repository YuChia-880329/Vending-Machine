package template;

import template.exception.CheckerException;

public abstract class CheckerTemplate<I, E extends CheckerException> {

	public abstract void check(I input) throws E;
}
