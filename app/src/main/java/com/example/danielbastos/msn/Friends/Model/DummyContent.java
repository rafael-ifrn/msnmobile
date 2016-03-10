package com.example.danielbastos.msn.Friends.Model;

import com.example.danielbastos.msn.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 15 sample items.
        addItem(new DummyItem(
                        "1",
                        "João da Silva",
                        "Estou te mandando o trabalho de Português. Por favor, repasse" +
                            "para os interessados" ,
                        R.drawable.user
                )
        );

        addItem(new DummyItem(
                        "1",
                        "Zé Maria",
                        "Ei, bora bater essa pelada mais tarde? Vlw!" ,
                        R.drawable.user
                )
        );

        addItem(new DummyItem(
                        "1",
                        "Rafaela",
                        "Beijo" ,
                        R.drawable.user
                )
        );

    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String name;
        public String lastText;
        public int picture;

        public DummyItem(String id, String name, String lastText, int picture) {
            this.id = id;
            this.name = name;
            this.picture = picture;
            this.lastText = lastText;
        }

        @Override
        public String toString() {
            return id + " - " + name;
        }
    }
}
