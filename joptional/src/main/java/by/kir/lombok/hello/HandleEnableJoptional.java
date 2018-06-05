package by.kir.lombok.hello;

import com.sun.tools.javac.tree.JCTree.JCAnnotation;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import org.mangosdk.spi.ProviderFor;

@ProviderFor(JavacAnnotationHandler.class)
@HandlerPriority(value = 512)
public class HandleEnableJoptional extends JavacAnnotationHandler<EnableJoptional> {

    @Override
    public void handle(AnnotationValues<EnableJoptional> annotation, JCAnnotation ast, JavacNode annotationNode) {
        annotationNode.up().traverse(new JopFinderVisitor());
    }

}
