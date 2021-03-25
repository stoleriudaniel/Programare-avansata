package laborator;

import java.io.IOException;

public abstract class CatalogCommand extends Catalog{
    abstract void execute(Item ... items) throws InvalidCatalogException;
}
