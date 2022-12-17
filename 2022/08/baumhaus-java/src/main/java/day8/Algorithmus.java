package day8;

import tools.AlgorithmusAPI;

import java.util.ArrayList;
import java.util.List;

public class Algorithmus extends AlgorithmusAPI {

    final List<List<Integer>> schonung = new ArrayList<List<Integer>>();


    public Algorithmus() {
        schonung.add(new ArrayList<>()); // Zeile 0 ungenutzt
    }

    public void verarbeiteZeile(final int lineNr, final String zeile) {
        System.out.format("\n[%d] >%s<", lineNr, zeile);
        final List<Integer> line =  new ArrayList<>();
        for (char zeichen : zeile.toCharArray()) {
            line.add(((int) zeichen)-48);
        }
        assert schonung.size() <= lineNr;
        schonung.add(line);
    }

    public void zeilenNachbearbeitung() {
        schonung.stream()
            .filter(zeile-> zeile.size()>0) // Zeile 0 raus filtern
            .peek(zeile -> System.out.format("\n"))
            .forEach(zeile -> zeile.forEach(value -> System.out.format("%d",value)));
    }

    public void berechneTeil1() {

    }

    public void berechneTeil2() {

    }


}


