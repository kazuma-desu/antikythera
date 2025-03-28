package sa.com.cloudsolutions.antikythera.evaluator.functional;

import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.WildcardType;
import sa.com.cloudsolutions.antikythera.evaluator.AntikytheraRunTime;
import sa.com.cloudsolutions.antikythera.evaluator.Variable;

import java.util.function.Consumer;

public class ConsumerEvaluator<T> extends FPEvaluator implements Consumer<T> {

    public ConsumerEvaluator(String className) {
        super(className);
    }

    @Override
    public Type getType() {
        return new ClassOrInterfaceType()
                .setName("Consumer")
                .setTypeArguments(
                        new WildcardType()
                );
    }

    @Override
    public void accept(T t) {
        AntikytheraRunTime.push(new Variable(t));
        try {
            executeMethod(methodDeclaration);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
}
