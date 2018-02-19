package jsample.annotation.user;

import java.util.ArrayList;
import java.util.List;

import jsample.annotation.MethodInfo;

public class AnnotationUser {

	@Override
	@MethodInfo(author = "Robert", comments = "overriding toString method", date = "10-May-2018")
	public String toString() {
		return "Overriden toString method";
	}

	@Deprecated
	@MethodInfo(comments = "deprecated method", date = "12-May-2018")
	public static void oldMethod() {
		System.out.println("old method, don't use it.");
	}

	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@MethodInfo(author = "Bob", comments = "test annotation", date = "10-May-2014", revision = 10)
	public static void genericsTest() throws NumberFormatException {
		List l = new ArrayList();
		l.add("abc");
		oldMethod();
	}

}
