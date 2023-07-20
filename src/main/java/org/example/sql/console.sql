# 181. 超过经理收入的员工
# Create table If Not Exists Employee
# (
#     id        int,
#     name      varchar(255),
#     salary    int,
#     managerId int
# );
# Truncate table Employee;
# insert into Employee (id, name, salary, managerId)
# values ('1', 'Joe', '70000', '3');
# insert into Employee (id, name, salary, managerId)
# values ('2', 'Henry', '80000', '4');
# insert into Employee (id, name, salary, managerId)
# values ('3', 'Sam', '60000', null);
# insert into Employee (id, name, salary, managerId)
# values ('4', 'Max', '90000', null);

select e1.name as `Employee`
from employee e1
         join employee e2 on e1.managerId = e2.id
where e1.salary > e2.salary
;

select e1.name as `Employee`
from employee e1,
     employee e2
where e1.managerId = e2.id
  and e1.salary > e2.salary;


# 182. 查找重复的电子邮箱
# Create table If Not Exists Person
# (
#     id    int,
#     email varchar(255)
# );
# Truncate table Person;
# insert into Person (id, email)
# values ('1', 'a@b.com');
# insert into Person (id, email)
# values ('2', 'c@d.com');
# insert into Person (id, email)
# values ('3', 'a@b.com');

select email as Email
from person p1
group by email
having count(*) > 1;

# 197. 上升的温度
# Create table If Not Exists Weather
# (
#     id          int,
#     recordDate  date,
#     temperature int
# );
# Truncate table Weather;
# insert into Weather (id, recordDate, temperature)
# values ('1', '2015-01-01', '10');
# insert into Weather (id, recordDate, temperature)
# values ('2', '2015-01-02', '25');
# insert into Weather (id, recordDate, temperature)
# values ('3', '2015-01-03', '20');
# insert into Weather (id, recordDate, temperature)
# values ('4', '2015-01-04', '30');

select w1.id
from weather w1,
     weather w2
where DATEDIFF(w1.recordDate, w2.recordDate) = 1
  and w1.temperature > w2.temperature
;

# 584. 寻找用户推荐人
# Create table If Not Exists Customer (id int, name varchar(25), referee_id int);
# Truncate table Customer;
# insert into Customer (id, name, referee_id) values ('1', 'Will', null);
# insert into Customer (id, name, referee_id) values ('2', 'Jane', null);
# insert into Customer (id, name, referee_id) values ('3', 'Alex', '2');
# insert into Customer (id, name, referee_id) values ('4', 'Bill', null);
# insert into Customer (id, name, referee_id) values ('5', 'Zack', '1');
# insert into Customer (id, name, referee_id) values ('6', 'Mark', '2');
select customer.name
from customer
where referee_id is null
   or referee_id != 2
;


select customer.name
from customer
where not referee_id <=> 2
;

# 619. 只出现一次的最大数字
# Create table If Not Exists MyNumbers (num int);
# Truncate table MyNumbers;
# insert into MyNumbers (num) values ('8');
# insert into MyNumbers (num) values ('8');
# insert into MyNumbers (num) values ('3');
# insert into MyNumbers (num) values ('3');
# insert into MyNumbers (num) values ('1');
# insert into MyNumbers (num) values ('4');
# insert into MyNumbers (num) values ('5');
# insert into MyNumbers (num) values ('6');

select max(t.num) as num
from (select num from mynumbers group by num having count(*) = 1) as t;

select num
from mynumbers
group by num
having count(*) = 1
order by num desc
limit 1;


select ifnull(
               (select num from mynumbers group by num having count(*) = 1 order by num desc limit 1),
               null
           ) num;

# 627. 变更性别
# Create table If Not Exists Salary (id int, name varchar(100), sex char(1), salary int);
# Truncate table Salary;
# insert into Salary (id, name, sex, salary) values ('1', 'A', 'm', '2500');
# insert into Salary (id, name, sex, salary) values ('2', 'B', 'f', '1500');
# insert into Salary (id, name, sex, salary) values ('3', 'C', 'm', '5500');
# insert into Salary (id, name, sex, salary) values ('4', 'D', 'f', '500');
update salary
set sex = char(211 - ascii(sex));

update salary
set sex= if(sex = 'm', 'f', 'm');

# 1084. 销售分析III
# Create table If Not Exists Product (product_id int, product_name varchar(10), unit_price int);
# Create table If Not Exists Sales (seller_id int, product_id int, buyer_id int, sale_date date, quantity int, price int);
# Truncate table Product;
# insert into Product (product_id, product_name, unit_price) values ('1', 'S8', '1000');
# insert into Product (product_id, product_name, unit_price) values ('2', 'G4', '800');
# insert into Product (product_id, product_name, unit_price) values ('3', 'iPhone', '1400');
# Truncate table Sales;
# insert into Sales (seller_id, product_id, buyer_id, sale_date, quantity, price) values ('1', '1', '1', '2019-01-21', '2', '2000');
# insert into Sales (seller_id, product_id, buyer_id, sale_date, quantity, price) values ('1', '2', '2', '2019-02-17', '1', '800');
# insert into Sales (seller_id, product_id, buyer_id, sale_date, quantity, price) values ('2', '2', '3', '2019-06-02', '1', '800');
# insert into Sales (seller_id, product_id, buyer_id, sale_date, quantity, price) values ('3', '3', '4', '2019-05-13', '2', '2800');

select product_id, product_name
from product
where product_id in (select product.product_id
                     from product
                              join sales on product.product_id = sales.product_id
                     where sales.sale_date between '2019-01-01' and '2019-03-31')
  and product_id not in (select product_id
                         from sales
                         where not sale_date between '2019-01-01' and '2019-03-31')
;


select product.product_id, product.product_name
from sales
         left join product on sales.product_id = product.product_id
group by product.product_id
having count(sales.sale_date between '2019-01-01' and '2019-03-31' or null) = count(*)
;


