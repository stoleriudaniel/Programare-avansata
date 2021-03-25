package laborator;

public class AddCommand extends CatalogCommand{
    @Override
    void execute(Item... items) throws InvalidCatalogException {
        if(items.length==0)
        {
            throw new InvalidCatalogException("Null :(");
        }
        for(Item myItem : items)
            catalogItems.add(myItem);
    }
}
