use test_join;

select * from person inner join card on person.cardId = card.id; 
select * from person left join card on person.cardId = card.id; 
select * from person right join card on person.cardId = card.id; 

select * from person left join card on person.cardId = card.id
union
select * from person right join card on person.cardId = card.id; 