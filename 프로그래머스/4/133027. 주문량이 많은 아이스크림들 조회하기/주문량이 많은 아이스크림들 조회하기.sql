SELECT A.FLAVOR
FROM FIRST_HALF A JOIN JULY B ON A.FLAVOR = B.FLAVOR
GROUP BY A.FLAVOR
ORDER BY SUM(A.TOTAL_ORDER + B.TOTAL_ORDER) DESC
LIMIT 3


-- 7월에는 아이스크림 주문량이 많아 같은 아이스크림에 대하여 서로 다른 두 공장에서 아이스크림 가게로 출하를 진행하는 경우가 있습니다. 이 경우 같은 맛의 아이스크림이라도 다른 출하 번호를 갖게 됩니다.
-- 그래서 GROUP BY A.FLAVOR로 해결해도 되는 것임. A에서는 서로 다른 totalorder를 가진 데이터강 없으니.