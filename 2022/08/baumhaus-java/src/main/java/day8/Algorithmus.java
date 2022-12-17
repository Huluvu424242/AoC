package day8;

import tools.AlgorithmusAPI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Algorithmus extends AlgorithmusAPI {

    final List<List<Integer>> schonung = new ArrayList<>();
    int lastLineNr = 0;

    final Set<String> sichtbareBaeume = new HashSet<>();

    public Algorithmus() {
        schonung.add(new ArrayList<>()); // Zeile 0 ungenutzt
    }

    public void verarbeiteZeile(final int lineNr, final String zeile) {
        System.out.format("\n[%d] >%s<", lineNr, zeile);
        final List<Integer> line = new ArrayList<>();
        for (char zeichen : zeile.toCharArray()) {
            line.add(((int) zeichen) - 48);
        }
        schonung.add(line);
        if( schonung.size() <= lineNr){
            throw new RuntimeException(String.format("ZeilenNr %d kleiner size %d ",lineNr,schonung.size()));
        };
        lastLineNr = lineNr;
    }

    public void zeilenNachbearbeitung() {
        schonung.stream()
            .filter(zeile -> zeile.size() > 0) // Zeile 0 raus filtern
            .peek(zeile -> System.out.format("\n"))
            .forEach(zeile -> zeile.forEach(value -> System.out.format("%d", value)));
    }

    public String berechneTeil1() {
        for (int zeileNr = 1; zeileNr <= lastLineNr; zeileNr++) {
            final List<Integer> zeile = schonung.get(zeileNr);
            for (int spalteNr = 1; spalteNr <= zeile.size(); spalteNr++) {
                pruefeSichtbarkeit(zeileNr, spalteNr, zeile);
            }
        }
        return String.format("%d Bäume sichtbar.", sichtbareBaeume.size());
    }


    protected void pruefeSichtbarkeit(final int zeilenNr, final int spaltenNr, final List<Integer> zeile) {
        if (pruefeSichtbarkeitRand(zeilenNr, spaltenNr, zeile)) {
            sichtbareBaeume.add(String.format("%d,%d", zeilenNr, spaltenNr));
        }else {
            pruefeSichtbarkeitInnen(zeilenNr, spaltenNr, zeile);
        }
    }

    protected boolean pruefeSichtbarkeitRand(final int zeilenNr, final int spaltenNr, final List<Integer> zeile) {
        return zeilenNr == 1 || zeilenNr == lastLineNr || spaltenNr == 1 || spaltenNr == zeile.size();
    }

    protected void pruefeSichtbarkeitInnen(final int zeilenNr, final int spaltenNr, final List<Integer> zeile) {
        final int baumHoehe = zeile.get(spaltenNr-1);
        // von rechts sichtbar
        for (int i = spaltenNr+1; i <=zeile.size() ; i++) {
            final int rechteHoehe = zeile.get(i-1);
            if(rechteHoehe>=baumHoehe){
                break; // von rechts nicht sichtbar
            }else if( i == zeile.size()){
                // rechten Rand erreicht -> sichtbar von rechts
                sichtbareBaeume.add(String.format("%d,%d",zeilenNr,spaltenNr));
                return;
            }
        }
        // von links sichtbar
        for (int i = spaltenNr-1; i >0 ; i--) {
            final int linkeHoehe = zeile.get(i-1);
            if(linkeHoehe>=baumHoehe){
                break; // von links nicht sichtbar
            }else if( i == 1 ){
                // linken Rand erreicht -> sichtbar von links
                sichtbareBaeume.add(String.format("%d,%d",zeilenNr,spaltenNr));
                return;
            }
        }
        // von oben sichtbar
        for (int i = zeilenNr-1; i >0 ; i--) {
            final List<Integer> obereZeile = schonung.get(i);
            final int obereHoehe = obereZeile.get(spaltenNr-1);
            if(obereHoehe>=baumHoehe){
                break; // von oben nicht sichtbar
            }else if( i == 1 ){
                // oberen Rand erreicht -> sichtbar von oben
                sichtbareBaeume.add(String.format("%d,%d",zeilenNr,spaltenNr));
                return;
            }
        }
        // von unten sichtbar
        for (int i = zeilenNr+1; i <=lastLineNr ; i++) {
            final List<Integer> untereZeile = schonung.get(i);
            final int untereHoehe = untereZeile.get(spaltenNr-1);
            if(untereHoehe>=baumHoehe){
                break; // von unten nicht sichtbar
            }else if( i == lastLineNr){
                // unteren Rand erreicht -> sichtbar von unten
                sichtbareBaeume.add(String.format("%d,%d",zeilenNr,spaltenNr));
                return;
            }
        }
    }

    public String berechneTeil2() {
        return "";
    }


}


