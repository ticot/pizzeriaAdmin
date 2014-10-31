SELECT p.name, p.price, p.is_shown, GROUP_CONCAT(DISTINCT c.content ORDER BY c.content SEPARATOR ', ') AS contents
FROM Products p
INNER JOIN ProductContentRows r ON p.product_id = r.product_id
INNER JOIN Contents c ON r.content_id = c.content_id
WHERE p.product_id = r.product_id
AND r.content_id = c.content_id
GROUP BY p.product_id
ORDER BY p.name;