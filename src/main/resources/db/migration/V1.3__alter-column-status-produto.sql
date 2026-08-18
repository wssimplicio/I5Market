alter table produto add column status_new boolean default true not null;

update produto set status_new = coalesce(p.status, true) from produto p where produto.id = p.id;