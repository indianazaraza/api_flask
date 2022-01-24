package arguments.provider;

import arguments.holder.ProductBodyValidationArgsHolder;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

public class ProductBodyValidationArgsProvider implements ArgumentsProvider {
    @Override
    public Stream provideArguments(ExtensionContext context) {
        return Stream.of(
                new ProductBodyValidationArgsHolder(
                        Collections.emptyMap(),
                        "1",
                        500
                ),
                new ProductBodyValidationArgsHolder(
                        Map.of(
                                "name", "cuadro",
                                "description", "para decoración"),
                        "45",
                        500
                ),
                new ProductBodyValidationArgsHolder(
                        Map.of("description", "rojo"),
                        "1",
                        500
                ),
                new ProductBodyValidationArgsHolder(
                        Map.of("name", ""),
                        "1",
                        500
                )
        ).map(Arguments::of);
    }
}
