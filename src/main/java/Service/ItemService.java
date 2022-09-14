package Service;

import Model.Item;

import java.util.Collection;

public interface ItemService {

        public static void addItem(Item item) {

        }

        public static Collection<Item> getItems() {
                return null;
        }

        public static Item getItem(String id) {
                return null;
        }

        public Item editItem (Item item)
                throws Exception;

        public void deleteItem (String id);

        public boolean itemExist (String id);



}
