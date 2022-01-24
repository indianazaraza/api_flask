package arguments.provider;

import arguments.holder.ProductValidationArgsHolder;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Map;
import java.util.stream.Stream;

public class ProductValidationArgsProvider implements ArgumentsProvider {
    @Override
    public Stream provideArguments(ExtensionContext context) {
        return Stream.of(
                new ProductValidationArgsHolder(
                        Map.of("id", "gtg"),
                        500
                ),
                new ProductValidationArgsHolder(
                        Map.of("id", "100"),
                        200
                ),
                new ProductValidationArgsHolder(
                        Map.of("id", 123),
                        200
                )
        ).map(Arguments::of);
    }
}
