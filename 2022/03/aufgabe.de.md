--- Tag 3: Rucksackumbau ---
Ein Elf hat die wichtige Aufgabe, alle Rucksäcke mit Vorräten für die Dschungelreise zu beladen. Leider hat sich dieser Elf nicht ganz an die Verpackungsanweisungen gehalten, und so müssen jetzt einige Artikel umsortiert werden.

Jeder Rucksack hat zwei große Fächer. Alle Artikel einer bestimmten Art sollen in genau eines der beiden Fächer passen. Der Elf, der das Packen durchgeführt hat, hat diese Regel für genau einen Gegenstandstyp pro Rucksack nicht befolgt.

Die Elfen haben eine Liste aller Gegenstände erstellt, die sich derzeit in jedem Rucksack befinden (Ihre Rätseleingabe), aber sie brauchen Ihre Hilfe, um die Fehler zu finden. Jeder Elementtyp wird durch einen einzelnen Klein- oder Großbuchstaben identifiziert (d. h. a und A beziehen sich auf unterschiedliche Elementtypen).

Die Liste der Artikel für jeden Rucksack wird als Zeichen in einer einzigen Zeile angegeben. Ein gegebener Rucksack hat immer die gleiche Anzahl von Gegenständen in jedem seiner zwei Fächer, so dass die erste Hälfte der Zeichen Gegenstände im ersten Fach darstellt, während die zweite Hälfte der Zeichen Gegenstände im zweiten Fach darstellt.

Angenommen, Sie haben die folgende Inhaltsliste von sechs Rucksäcken:

vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
Der erste Rucksack enthält die Items vJrwpWtwJgWrhcsFMMfFFhFp, d. h. sein erstes Fach enthält die Items vJrwpWtwJgWr, während das zweite Fach die Items hcsFMMfFFhFp enthält. Der einzige Elementtyp, der in beiden Fächern erscheint, ist das kleine p.
Die Fächer des zweiten Rucksacks enthalten jqHRNqRjqzjGDLGL und rsFMfFZSrLrFZsSL. Der einzige Elementtyp, der in beiden Fächern erscheint, ist das große L.
Die Fächer des dritten Rucksacks enthalten PmmdzqPrV und vPwwTWBwg; Der einzige gemeinsame Elementtyp ist der Großbuchstabe P.
Die Fächer des vierten Rucksacks teilen sich nur den Gegenstandstyp v.
Die Fächer des fünften Rucksacks teilen sich nur den Gegenstandstyp t.
Die Fächer des sechsten Rucksacks teilen sich nur Item Type s.
Um die Neuanordnung von Gegenständen zu priorisieren, kann jeder Gegenstandstyp in eine Priorität umgewandelt werden:

Elementtypen a bis z in Kleinbuchstaben haben die Prioritäten 1 bis 26.
Großgeschriebene Elementtypen A bis Z haben die Prioritäten 27 bis 52.
Im obigen Beispiel ist die Priorität des Artikeltyps, der in beiden Fächern jedes Rucksacks erscheint, 16 (p), 38 (L), 42 (P), 22 (v), 20 (t) und 19 (s). ; die Summe davon ist 157.

Suchen Sie den Gegenstandstyp, der in beiden Fächern jedes Rucksacks erscheint. Was ist die Summe der Prioritäten dieser Elementtypen?

Ihre Rätselantwort war 8153.

Die erste Hälfte dieses Puzzles ist fertig! Es bietet einen goldenen Stern: *

--- Zweiter Teil ---
Nachdem Sie die verlegten Gegenstände identifiziert haben, kommen die Elfen mit einem weiteren Problem zu Ihnen.

Zur Sicherheit werden die Elfen in Dreiergruppen eingeteilt. Jeder Elf trägt ein Abzeichen, das seine Gruppe identifiziert. Aus Effizienzgründen ist das Abzeichen innerhalb jeder Gruppe von drei Elfen der einzige Gegenstandstyp, der von allen drei Elfen getragen wird. Das heißt, wenn das Abzeichen einer Gruppe Gegenstandstyp B ist, haben alle drei Elfen Gegenstandstyp B irgendwo in ihrem Rucksack, und höchstens zwei der Elfen tragen einen anderen Gegenstandstyp.

Das Problem ist, dass jemand vergessen hat, den diesjährigen aktualisierten Echtheitsaufkleber auf die Abzeichen zu kleben. Alle Abzeichen müssen aus den Rucksäcken gezogen werden, damit die neuen Echtheitsaufkleber angebracht werden können.

Außerdem hat niemand aufgeschrieben, welcher Gegenstandstyp den Abzeichen der einzelnen Gruppen entspricht. Der einzige Weg, um festzustellen, welcher Gegenstandstyp der richtige ist, besteht darin, den einen Gegenstandstyp zu finden, der allen drei Elfen in jeder Gruppe gemeinsam ist.

Jeder Satz von drei Zeilen in Ihrer Liste entspricht einer einzelnen Gruppe, aber jede Gruppe kann einen anderen Badge-Elementtyp haben. Im obigen Beispiel sind die Rucksäcke der ersten Gruppe also die ersten drei Zeilen:

vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
Und die Rucksäcke der zweiten Gruppe sind die nächsten drei Zeilen:

wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
In der ersten Gruppe ist der einzige Gegenstandstyp, der in allen drei Rucksäcken vorkommt, das kleine r; das müssen ihre Abzeichen sein. In der zweiten Gruppe muss der Badge-Artikeltyp Z sein.

Für diese Punkte müssen noch Prioritäten gefunden werden, um die Aufkleberanbringung zu organisieren: Hier sind es 18 (r) für die erste Gruppe und 52 (Z) für die zweite Gruppe. Die Summe davon ist 70.

Finden Sie den Gegenstandstyp, der den Abzeichen jeder Drei-Elfen-Gruppe entspricht. Was ist die Summe der Prioritäten dieser Elementtypen?
