SELECT PRICE AS MAX_PRICE -- MAX_PRICE라는 이름으로 PRICE를 고른다.
FROM PRODUCT              -- PRODUCT 테이블에서
ORDER BY PRICE DESC limit 1; -- PRICE를 내림차순 정렬하는데 데이터 1행만 가져온다.
