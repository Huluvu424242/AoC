--- Tag 7: Kein Speicherplatz mehr auf dem Gerät ---
Sie können Vögel zwitschern und Regentropfen hören, die auf Blätter treffen, während die Expedition voranschreitet. Gelegentlich können Sie sogar viel lautere Geräusche in der Ferne hören; Wie groß werden die Tiere hier überhaupt?

Das Gerät, das dir die Elfen gegeben haben, hat nicht nur Probleme mit seinem Kommunikationssystem. Sie versuchen, ein Systemupdate auszuführen:

```
$ system-update --please --pretty-please-with-sugar-on-top
Error: No space left on device
```
Vielleicht können Sie einige Dateien löschen, um Platz für das Update zu schaffen?

Sie durchsuchen das Dateisystem, um die Situation einzuschätzen, und speichern die resultierende Terminalausgabe (Ihre Rätseleingabe). Zum Beispiel:

```
$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
```

Das Dateisystem besteht aus einem Baum von Dateien (einfachen Daten) und Verzeichnissen (die andere Verzeichnisse oder Dateien enthalten können). Das äußerste Verzeichnis heißt /. Sie können im Dateisystem navigieren, sich in Verzeichnisse hinein- oder herausbewegen und den Inhalt des Verzeichnisses auflisten, in dem Sie sich gerade befinden.

Innerhalb der Terminalausgabe sind Zeilen, die mit $ beginnen, Befehle, die Sie ausgeführt haben, ähnlich wie bei einigen modernen Computern:

  > cd bedeutet Verzeichnis wechseln. Dies ändert, welches Verzeichnis das aktuelle Verzeichnis ist, aber das spezifische Ergebnis hängt vom Argument ab:

  > cd x bewegt sich in einer Ebene: Es sucht im aktuellen Verzeichnis nach dem Verzeichnis namens x und macht es zum aktuellen Verzeichnis.

  > cd .. bewegt sich eine Ebene nach oben: Es findet das Verzeichnis, das das aktuelle Verzeichnis enthält, und macht dieses Verzeichnis dann zum aktuellen Verzeichnis.

  > cd / wechselt das aktuelle Verzeichnis in das äußerste Verzeichnis /.

  > ls bedeutet Liste. Es gibt alle Dateien und Verzeichnisse aus, die unmittelbar im aktuellen Verzeichnis enthalten sind:

  > 123 abc bedeutet, dass das aktuelle Verzeichnis eine Datei namens abc mit der Größe 123 enthält.

  > dir xyz bedeutet, dass das aktuelle Verzeichnis ein Verzeichnis namens xyz enthält.

Anhand der Befehle und der Ausgabe im obigen Beispiel können Sie feststellen, dass das Dateisystem visuell so aussieht:
```

- / (dir)
  - a (dir)
    - e (dir)
      - i (file, size=584)
    - f (file, size=29116)
    - g (file, size=2557)
    - h.lst (file, size=62596)
  - b.txt (file, size=14848514)
  - c.dat (file, size=8504156)
  - d (dir)
    - j (file, size=4060174)
    - d.log (file, size=8033020)
    - d.ext (file, size=5626152)
    - k (file, size=7214296)
```
Hier gibt es vier Verzeichnisse: / (das äußerste Verzeichnis), a und d (die sich in / befinden) und e (das sich in a befindet). Diese Verzeichnisse enthalten auch Dateien unterschiedlicher Größe.

Da die Festplatte voll ist, sollte Ihr erster Schritt wahrscheinlich darin bestehen, Verzeichnisse zu finden, die gute Kandidaten zum Löschen sind. Dazu müssen Sie die Gesamtgröße jedes Verzeichnisses ermitteln. Die Gesamtgröße eines Verzeichnisses ist die Summe der Größen der darin enthaltenen Dateien, direkt oder indirekt. (Verzeichnisse selbst zählen nicht als intrinsisch groß.)

Die Gesamtgrößen der oben genannten Verzeichnisse finden Sie wie folgt:

Die Gesamtgröße des Verzeichnisses e beträgt 584, da es eine einzelne Datei i der Größe 584 und keine anderen Verzeichnisse enthält.
Das Verzeichnis a hat eine Gesamtgröße von 94853, da es die Dateien f (Größe 29116), g (Größe 2557) und h.lst (Größe 62596) sowie indirekt die Datei i enthält (a enthält e, das i enthält).
Verzeichnis d hat eine Gesamtgröße von 24933642.
Als äußerstes Verzeichnis enthält / alle Dateien. Seine Gesamtgröße beträgt 48381165, die Summe der Größe jeder Datei.
Suchen Sie zunächst alle Verzeichnisse mit einer Gesamtgröße von höchstens 100000 und berechnen Sie dann die Summe ihrer Gesamtgrößen. Im obigen Beispiel sind diese Verzeichnisse a und e; die Summe ihrer Gesamtgrößen beträgt 95437 (94853 + 584). (Wie in diesem Beispiel kann dieser Prozess Dateien mehr als einmal zählen!)

Finden Sie alle Verzeichnisse mit einer Gesamtgröße von höchstens 100000. Wie groß ist die Summe der Gesamtgröße dieser Verzeichnisse?

Ihre Rätselantwort war 1307902.

Die erste Hälfte dieses Puzzles ist fertig! Es bietet einen goldenen Stern: *

--- Zweiter Teil ---
Jetzt können Sie ein zu löschendes Verzeichnis auswählen.

Der für das Dateisystem verfügbare Gesamtspeicherplatz beträgt 70000000. Um das Update auszuführen, benötigen Sie mindestens 30000000 ungenutzten Speicherplatz. Sie müssen ein Verzeichnis finden, das Sie löschen können und das genügend Speicherplatz freigibt, um das Update auszuführen.

Im obigen Beispiel beträgt die Gesamtgröße des äußersten Verzeichnisses (und damit der gesamte belegte Speicherplatz) 48381165; Das bedeutet, dass die Größe des ungenutzten Speicherplatzes derzeit 21618835 betragen muss, was nicht ganz den 30000000 entspricht, die für das Update erforderlich sind. Daher muss für das Update weiterhin ein Verzeichnis mit einer Gesamtgröße von mindestens 8381165 gelöscht werden, bevor es ausgeführt werden kann.

Um dies zu erreichen, haben Sie folgende Möglichkeiten:

```
Löschen Sie das Verzeichnis e, was den ungenutzten Speicherplatz um 584 erhöhen würde.
Löschen Sie das Verzeichnis a, was den ungenutzten Speicherplatz um 94853 erhöhen würde.
Löschen Sie das Verzeichnis d, was den ungenutzten Speicherplatz um 24933642 erhöhen würde.
Löschen Sie das Verzeichnis /, was den ungenutzten Speicherplatz um 48381165 erhöhen würde.
```
Die Verzeichnisse e und a sind beide zu klein; Wenn Sie sie löschen, wird nicht genügend Speicherplatz freigegeben. Allerdings sind die Verzeichnisse d und / beide groß genug! Wählen Sie zwischen diesen den kleinsten: d, wodurch der ungenutzte Speicherplatz um 24933642 erhöht wird.

Suchen Sie das kleinste Verzeichnis, das, wenn es gelöscht wird, genügend Speicherplatz auf dem Dateisystem freigeben würde, um das Update auszuführen. Wie groß ist dieses Verzeichnis insgesamt?

Ihre Rätselantwort war 7068748.

Beide Teile dieses Puzzles sind vollständig! Sie bieten zwei goldene Sterne: **

An dieser Stelle sollten Sie zu Ihrem Adventskalender zurückkehren und ein weiteres Rätsel ausprobieren.

Wenn Sie es trotzdem sehen möchten, können Sie Ihren Rätseleingang abrufen.
