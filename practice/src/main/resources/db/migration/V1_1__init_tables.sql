insert into functions (func_id, func_name)
    values
        (1, 'Вход/регистрация'),
        (2, 'Просмотр техрадара'),
        (3, 'Фильтрация техрадара (секция, категория, дата)'),
        (4, 'Экспорт техрадара PDF/CSV'),
        (5, 'Группировка техрадара по командам'),
        (6, 'Голосование за распределение продуктов'),
        (7, 'Добавление продукта каталог технологий'),
        (8, 'Просмотр каталога технологий'),
        (9, 'Просмотр дашборда по продукту'),
        (10, 'Архивирование/ Удаление/ редактирование продукта на техрадаре'),
        (11, 'Поиск, сортировка, фильтрация по каталогу технологий');

insert into roles (role_id, role_name)
values
    (1, 'tech_lead'),
    (2, 'developer');

insert into categories (cat_id, cat_name)
values
    (1, 'Backend'),
    (2, 'Frontend'),
    (3, 'IOS'),
    (4, 'Android');

insert into sections (sec_id, sec_name)
values
    (1, 'Languages'),
    (2, 'Tools'),
    (3, 'Techniques'),
    (4, 'Platforms');

insert into rings (ring_id, ring_name)
values
    (1, 'ADOPT'),
    (2, 'TRIAL'),
    (3, 'ASSETS'),
    (4, 'HOLD'),
    (5, 'BACKLOG');

insert into statuses (stat_id, stat_name)
values
    (1, 'MOVED UP'),
    (2, 'MOVED DOWN'),
    (3, 'NEW'),
    (4, 'NO CHANGE'),
    (5, 'ARCHIVED');

insert into mapping (func_id, role_id)
values
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (6, 1),
    (7, 1),
    (8, 1),
    (9, 1),
    (10, 1),
    (11, 1),
    (2, 2),
    (3, 2),
    (4, 2),
    (5, 2),
    (6, 2);