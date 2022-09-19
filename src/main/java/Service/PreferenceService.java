package Service;

import Model.Preference;

import java.util.Collection;

public interface PreferenceService {

        public static void addItem(Preference item) {

        }

        public static Collection<Preference> getItems() {
                return null;
        }

        public static Preference getItem(String id) {
                return null;
        }

        public Preference editItem (Preference item)
                throws Exception;

        public void deleteItem (String id);

        public boolean itemExist (String id);



}
