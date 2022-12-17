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

Ihre Rätselantwort war 1789.

Die erste Hälfte dieses Puzzles ist fertig! Es bietet einen goldenen Stern: *

--- Zweiter Teil ---
Zufrieden mit der Menge an verfügbarem Baumbestand müssen die Elfen nur den besten Ort für den Bau ihres Baumhauses kennen: Sie würden gerne viele Bäume sehen können.

Um den Betrachtungsabstand von einem bestimmten Baum zu messen, schauen Sie von diesem Baum aus nach oben, unten, links und rechts. Halten Sie an, wenn Sie eine Kante oder den ersten Baum erreichen, der gleich hoch oder höher ist als der betrachtete Baum. (Wenn ein Baum direkt am Rand steht, ist mindestens einer seiner Betrachtungsabstände Null.)

Die Elfen kümmern sich nicht um entfernte Bäume, die höher sind als die, die durch die obigen Regeln gefunden werden; Das vorgeschlagene Baumhaus hat große Traufen, um es trocken zu halten, sodass sie sowieso nicht höher als das Baumhaus sehen können.

Betrachten Sie im obigen Beispiel die mittlere 5 in der zweiten Reihe:

```
30373
25512
65332
33549
35390
```

- Wenn Sie nach oben schauen, ist seine Sicht nicht blockiert; es kann 1 Baum (der Höhe 3) sehen.
- Beim Blick nach links wird ihm sofort die Sicht versperrt; es kann nur 1 Baum (Höhe 5, direkt daneben) sehen.
- Wenn Sie nach rechts schauen, ist die Sicht nicht blockiert; es kann 2 Bäume sehen.
- Wenn man nach unten schaut, wird ihm schließlich die Sicht versperrt; es kann 2 Bäume sehen (einen der Höhe 3, dann den Baum der Höhe 5, der seine Sicht versperrt).
Der landschaftliche Wert eines Baums wird ermittelt, indem seine Betrachtungsentfernung in jeder der vier Richtungen miteinander multipliziert wird. Für diesen Baum ist dies 4 (ermittelt durch Multiplizieren von 1 * 1 * 2 * 2).

Sie können es aber noch besser machen: Betrachten Sie den Baum der Höhe 5 in der Mitte der vierten Reihe:
```
30373
25512
65332
33549
35390
```

- Beim Blick nach oben ist seine Sicht bei 2 Bäumen (durch einen anderen Baum mit einer Höhe von 5) blockiert.
- Wenn Sie nach links schauen, ist die Sicht nicht blockiert; es kann 2 Bäume sehen.
- Auch der Blick nach unten ist ihm nicht versperrt; es kann 1 Baum sehen.
- Wenn man nach rechts schaut, ist seine Sicht bei 2 Bäumen (durch einen massiven Baum der Höhe 9) blockiert.


Die landschaftliche Punktzahl dieses Baums beträgt 8 (2 * 2 * 1 * 2); Dies ist der ideale Ort für das Baumhaus.

Betrachten Sie jeden Baum auf Ihrer Karte. Was ist die höchstmögliche landschaftliche Punktzahl für einen Baum?
