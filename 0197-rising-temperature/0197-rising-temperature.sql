SELECT current.id
FROM Weather AS current
JOIN Weather AS previous
ON current.recordDate = DATE_ADD(previous.recordDate, INTERVAL 1 DAY)
WHERE current.temperature > previous.temperature;