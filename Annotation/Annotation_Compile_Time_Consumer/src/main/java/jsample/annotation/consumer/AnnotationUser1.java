package jsample.annotation.consumer;

import jsample.annotation.MethodCounter;

@MethodCounter
public class AnnotationUser1 {

	private String message;

	public AnnotationUser1(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
