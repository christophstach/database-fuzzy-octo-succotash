/*Wer hat Bier gekauft und wohnt in Berlin (Schnittmenge anfrage)*/
SELECT first_name FROM persons p3 ,
  (
    (
      SELECT p.person_id
      FROM persons p,
        (
          SELECT flat_id
          FROM flats
          WHERE city = 'Berlin'
        ) AS f
      WHERE p.flat_id = f.flat_id
    )
    INTERSECT
    (
      SELECT p2.person_id
      FROM persons_buy_products p2,
        (
          SELECT product_id
          FROM products
          WHERE product_id = 8
        ) AS p
      WHERE p.product_id = p2.product_id
    )
  ) AS tmp
WHERE tmp.person_id = p3.person_id;

/*Wer kauft was? (Kartetisches produkt)*/
SELECT pro.name, p.first_name, p.last_name, c.name
FROM persons p, persons_buy_products buy, products pro, categories c, products_have_categories cp
WHERE buy.person_id = p.person_id
AND buy.product_id = pro.product_id
AND c.category_id = cp.category_id
AND cp.product_id = pro.product_id;
/*Wer kauft was? (JOIN)*/
SELECT pro.name, p.first_name, p.last_name, c.name FROM persons p
JOIN persons_buy_products buy ON p.person_id = buy.person_id
JOIN products pro ON buy.product_id = pro.product_id
JOIN products_have_categories cp ON pro.product_id = cp.product_id
JOIN categories c ON cp.category_id = c.category_id;

/*Alle Leute die keine zuständigkeit für ein Raum in Berlin haben(NOT IN)*/
SELECT p.first_name, p.last_name
FROM persons p
WHERE p.person_id NOT IN
  (
    SELECT DISTINCT pr.person_id FROM flats f
    JOIN rooms r ON f.flat_id = r.flat_id
    JOIN persons_are_responsible_for_rooms pr ON r.room_id = pr.room_id
    WHERE f.city = 'Berlin'
  );
/*Welche Wohnungen sind nicht leer* (IN)*/
SELECT * FROM flats f
WHERE f.flat_id IN
  (
    SELECT p.flat_id
    FROM persons p
  );

/*Summe aller Punkte die ein Raum geben (sum())*/
SELECT f.street, r.name, sum(t.points) FROM rooms r
JOIN flats f ON r.flat_id = f.flat_id
JOIN tasks t ON r.room_id = t.room_id
GROUP BY f.flat_id, r.room_id;

/*Anzahl der Zimmer pro Wohnung (count())*/
SELECT f.street, f.postal_code, f.city, count(*) FROM rooms r
JOIN flats f ON r.flat_id = f.flat_id
GROUP BY f.flat_id;

/*Durchschnittpreis einer Kategorie (avg())*/
SELECT c.name, avg(p.price) FROM products p
JOIN products_have_categories pc ON p.product_id = pc.product_id
JOIN categories c ON pc.category_id = c.category_id
GROUP BY c.category_id;

/*Teursten Preis in jede Kategorie (max())*/
SELECT c.name, max(p.price) FROM products p
JOIN products_have_categories pc ON p.product_id = pc.product_id
JOIN categories c ON pc.category_id = c.category_id
GROUP BY c.category_id;

/*Wohnungen wo mehr als 7 aufgaben insgesammt gibt*/
SELECT f.flat_id, f.street, f.city, count(*) FROM flats f
JOIN rooms r ON f.flat_id = r.flat_id
JOIN tasks t ON r.room_id = t.room_id
GROUP BY f.flat_id
HAVING count(*) > 7;

/*Leute die mehr als 15 euro ausgegeben haben*/
SELECT p.first_name, p.last_name, sum(pr.price * pb.quantity) FROM persons p
JOIN persons_buy_products pb ON p.person_id = pb.person_id
JOIN products pr ON pb.product_id = pr.product_id
GROUP BY p.person_id HAVING sum(pr.price * pb.quantity) > 15;