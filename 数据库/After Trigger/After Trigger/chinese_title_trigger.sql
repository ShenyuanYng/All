create or replace function chinese_title_split()
    returns trigger
as
$$
begin
    if tg_op = 'UPDATE'
    then
        delete
        from chinese_blocks
        where movieid = old.movieid
          and rn = old.rn;
    end if;
    insert into chinese_blocks (movieid, rn, block)
    select new.movieid,
           new.rn,
           bl
    from chinese_split(new.title) as bl;
    return null;
end;
$$
    language plpgsql;

create trigger chinese_titles_trg
 after insert or update
 on chinese_titles
 for each row
execute procedure chinese_title_split();