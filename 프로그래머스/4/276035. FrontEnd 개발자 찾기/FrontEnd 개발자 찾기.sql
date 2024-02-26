select id, email, first_name, last_name
from developers d
where skill_code & ( # 비트연산해서 1이 하나라도 있어야 프론트엔드 개발자로 분류 가능. 
    select sum(code) # 2의 제곱이니까 더해도 됨. 각자의 자릿수에 영향x
    from skillcodes 
    where category = 'Front End'
    group by category
)
order by id

# 2:18~2:23 
# 16, 2048, 8192
# 400, 8452, 2048

# 비트 분해?

# 스킬코드는 2진수로 변환해야 함.