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
