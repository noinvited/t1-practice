CREATE TABLE IF NOT EXISTS public.functions (
    func_id BIGINT primary key,
    func_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.roles (
    role_id BIGINT primary key,
    role_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.mapping (
    id SERIAL primary key,
    func_id BIGINT,
    role_id BIGINT,
    foreign key (func_id) references public.functions (func_id) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (role_id) references public.roles (role_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.rings(
    ring_id BIGINT primary key,
    ring_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.categories(
    cat_id BIGINT primary key,
    cat_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.sections(
    sec_id BIGINT primary key,
    sec_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.statuses(
    stat_id bigint primary key,
    stat_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.users (
    user_id SERIAL primary key,
    role_id BIGINT,
    login VARCHAR(255),
    password VARCHAR(255),
    refresh_token VARCHAR(255),
    foreign key (role_id) references public.roles (role_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.technologies(
    tech_id SERIAL primary key,
    cat_id BIGINT,
    sec_id BIGINT,
    ring_id BIGINT,
    name VARCHAR(255),
    description VARCHAR(255),
    stat_id BIGINT,
    update_time TIMESTAMP,
    foreign key (cat_id) references public.categories (cat_id) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (sec_id) references public.sections (sec_id) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (ring_id) references public.rings (ring_id) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (stat_id) references public.statuses (stat_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.polls(
    poll_id SERIAL primary key,
    user_id INT,
    tech_id INT,
    ring_id BIGINT,
    time TIMESTAMP,
    foreign key (user_id) references public.users (user_id) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (tech_id) references public.technologies (tech_id) ON UPDATE CASCADE ON DELETE CASCADE,
    foreign key (ring_id) references public.rings (ring_id) ON UPDATE CASCADE ON DELETE CASCADE
);