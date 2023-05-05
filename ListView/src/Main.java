/*Haz que el método show() obtenga la cantidad y cada uno de los ítems mediante un Adaptador.

import java.util.List;

class ListView {
    void show(List<String> items){
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> items = List.of("Java","Python","Javascript","C#", "C++", "TypeScript", "PHP");

        ListView listView = new ListView();
        listView.show(items);
    }
}*/

import java.util.List;

class ListView {
    interface Adapter {
        int cantidad();
        String palabra(int i);
    }

    void show(Adapter adapter) {
        for(int i=0 ; i < adapter.cantidad() ; i++) {
            System.out.println(adapter.palabra(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ListView listView = new ListView();
        List<String> items = List.of("Java","Python","Javascript","C#", "C++", "TypeScript", "PHP");

        listView.show(new ListView.Adapter() {
            @Override
            public int cantidad() {
                return items.size();
            }

            @Override
            public String palabra(int i) {
                return items.get(i);
            }
        });
    }
}