package laborator;

public class ListCommand extends CatalogCommand{
    @Override
    void execute(Item ... items) throws InvalidCatalogException {
        if(catalogItems.size()==0)
        {
            throw new InvalidCatalogException("Null :/");
        }
        for (Item catalogItem : catalogItems) {
            System.out.println(catalogItem);
        }
    }

}
