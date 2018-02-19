package jsample.annotation.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import jsample.annotation.MethodCounter;

@SupportedAnnotationTypes("jsample.annotation.MethodCounter")
@SupportedSourceVersion(SourceVersion.RELEASE_9)
public class MethodCounterProcessor extends AbstractProcessor {

	public MethodCounterProcessor() {
		super();
	}

	@Override
	public boolean process(Set<? extends TypeElement> typeElementSet, RoundEnvironment roundEnv) {

		for (Element e : roundEnv.getElementsAnnotatedWith(MethodCounter.class)) {
			String className = e.toString();
			String message = "Annotated class - " + className;
			System.out.println(message);
			processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
		}

		return false;
	}
}