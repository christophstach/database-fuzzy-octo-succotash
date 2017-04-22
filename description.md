In der folgende Datenbank werden die Daten die gebraucht werden um eine WG zu verwalten gespeichert.

Es gibt insgesamt 6 Entitätstypen: Personen, Zimmern, Wohnungen, Aufgaben, Produkten und Produktkategorien.

Die Beziehungen zwischen allen sind auf einem ER-Diagramm dargestellt.

Die Datenbank dient dazu eine WG so zu organisieren, so dass, alle Mitbewohner die Aufgaben und Einkäufe nachverfolgen können und die Ausgaben auch organisiert bleiben.


Alle Aufgaben haben einen Namen und bestimmte Punkte und gleichzeitig stehen in einer Beziehung mit Zimmern,
da alle Zimmern bestimmten Aufgaben haben wie z.B. Putzen. Zimmer haben einen Namen und stehen in einer Beziehung mit Wohnungen und Personen.
Eine Wohnung hat mehrere Zimmern und mehrere Personen sind zuständig für mehrere Zimmern. 
Wohnungen haben die Attributen Street, City und PLZ. Personen haben FirstName und LastName und stehen in einer n zu m Beziehung mit Produkten.
Produkten haben eine Name und Price. Dabei können Produkten beliebliche Kategorien zugeordnet werden und eine Kategorie besteht aus einer beliebigen Anzahl an Produkten. 
Jede Woche ändern sich die Aufgaben von jeder Person.    
