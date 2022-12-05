--- Tag 5: Vorratsstapel ---
Sobald die letzten Vorräte von den Schiffen entladen sind, kann die Expedition aufbrechen. Vorräte werden in Stapeln markierter Kisten gelagert, aber da die benötigten Vorräte unter vielen anderen Kisten vergraben sind, müssen die Kisten neu angeordnet werden.

Das Schiff verfügt über einen riesigen Frachtkran, der Kisten zwischen Stapeln bewegen kann. Damit keine der Kisten zerquetscht wird oder umfällt, ordnet der Kranführer sie in einer Reihe von sorgfältig geplanten Schritten neu an. Nachdem die Kisten neu angeordnet wurden, befinden sich die gewünschten Kisten oben auf jedem Stapel.

Die Elfen wollen die Kranführerin bei dieser heiklen Prozedur nicht unterbrechen, haben aber vergessen, sie zu fragen, welche Kiste wo landet, und wollen so schnell wie möglich zum Abladen bereit sein, damit sie an Bord gehen können.

Sie haben jedoch eine Zeichnung der Startstapel von Kisten und des Umordnungsverfahrens (Ihre Rätseleingabe). Zum Beispiel:
```
    [D]
[N] [C]
[Z] [M] [P]
 1   2   3

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2

```
In diesem Beispiel gibt es drei Kistenstapel. Stapel 1 enthält zwei Kisten: Kiste Z ist unten und Kiste N ist oben. Stapel 2 enthält drei Kisten; von unten nach oben sind es die Kisten M, C und D. Schließlich enthält Stapel 3 eine einzelne Kiste, P.

Dann wird das Umordnungsverfahren angegeben. In jedem Verfahrensschritt wird eine Menge Kisten von einem Stapel auf einen anderen Stapel bewegt. Im ersten Schritt des obigen Umordnungsverfahrens wird eine Kiste von Stapel 2 auf Stapel 1 bewegt, was zu dieser Konfiguration führt:
```
[D]
[N] [C]
[Z] [M] [P]
 1   2   3
```
Im zweiten Schritt werden drei Kisten von Stapel 1 auf Stapel 3 verschoben. Die Kisten werden einzeln verschoben, sodass die erste zu verschiebende Kiste (D) unter der zweiten und dritten Kiste landet:
```
        [Z]
        [N]
    [C] [D]
    [M] [P]
 1   2   3
```
Dann werden beide Kisten von Stapel 2 auf Stapel 1 bewegt. Da Kisten nacheinander bewegt werden, landet Kiste C wieder unter Kiste M:
```

        [Z]
        [N]
[M]     [D]
[C]     [P]
 1   2   3
```
Schließlich wird eine Kiste von Stapel 1 auf Stapel 2 verschoben:
```

        [Z]
        [N]
        [D]
[C] [M] [P]
 1   2   3
```
Die Elfen müssen nur wissen, welche Kiste oben auf jedem Stapel landet; In diesem Beispiel sind die obersten Kisten C in Stapel 1, M in Stapel 2 und Z in Stapel 3, also sollten Sie diese kombinieren und den Elfen die Nachricht CMZ geben.

Welche Kiste landet nach Abschluss des Umordnungsverfahrens oben auf jedem Stapel?


