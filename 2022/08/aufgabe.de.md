--- Tag 8: Treetop Tree House ---
Die Expedition stößt auf einen eigentümlichen Fleck hoher Bäume, die alle sorgfältig in einem Gitter gepflanzt wurden. Die Elfen erklären, dass eine frühere Expedition diese Bäume als Wiederaufforstungsmaßnahme gepflanzt hat. Jetzt sind sie neugierig, ob dies ein guter Standort für ein Baumhaus wäre.

Stellen Sie zunächst fest, ob hier genügend Baumbestand vorhanden ist, um ein Baumhaus zu verstecken. Dazu müssen Sie die Anzahl der Bäume zählen, die von außerhalb des Rasters sichtbar sind, wenn Sie direkt entlang einer Zeile oder Spalte schauen.

Die Elfen haben bereits einen Quadcopter gestartet, um eine Karte mit der Höhe jedes Baums zu erstellen (Ihre Rätseleingabe). Zum Beispiel:

```
30373
25512
65332
33549
35390
```
Jeder Baum wird als einzelne Ziffer dargestellt, deren Wert seine Höhe ist, wobei 0 die kürzeste und 9 die höchste ist.

Ein Baum ist sichtbar, wenn alle anderen Bäume zwischen ihm und einer Kante des Rasters kürzer sind als er. Berücksichtigen Sie nur Bäume in derselben Reihe oder Spalte; Das heißt, schauen Sie nur von einem bestimmten Baum nach oben, unten, links oder rechts.

Alle Bäume am Rand des Gitters sind sichtbar - da sie bereits am Rand stehen, gibt es keine Bäume, die die Sicht versperren. In diesem Beispiel bleiben nur die neun inneren Bäume zu berücksichtigen:

- Die obere linke 5 ist von links und oben sichtbar. (Er ist von rechts oder unten nicht sichtbar, da andere Bäume der Höhe 5 im Weg sind.)
- Die obere Mitte 5 ist von oben und rechts sichtbar.
- Die obere rechte 1 ist aus keiner Richtung sichtbar; Damit es sichtbar ist, müssten sich zwischen ihm und einer Kante nur Bäume der Höhe 0 befinden.
- Die linke mittlere 5 ist sichtbar, aber nur von rechts.
- Das Zentrum 3 ist aus keiner Richtung sichtbar; Damit es sichtbar ist, müssten sich zwischen ihm und einer Kante nur Bäume mit einer Höhe von höchstens 2 befinden.
- Die rechte mittlere 3 ist von rechts sichtbar.
- In der unteren Reihe ist die mittlere 5 sichtbar, aber die 3 und 4 nicht.

Mit 16 am Rand sichtbaren Bäumen und weiteren 5 im Inneren sichtbaren Bäumen sind in dieser Anordnung insgesamt 21 Bäume sichtbar.

Betrachten Sie Ihre Karte; Wie viele Bäume sind von außerhalb des Rasters sichtbar?
