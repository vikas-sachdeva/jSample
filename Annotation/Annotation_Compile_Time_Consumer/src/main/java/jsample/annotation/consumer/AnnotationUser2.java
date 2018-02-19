package jsample.annotation.consumer;

import jsample.annotation.MethodCounter;

@MethodCounter
public class AnnotationUser2 {

	private String message;

	public AnnotationUser2(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
