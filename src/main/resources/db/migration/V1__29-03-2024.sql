select constraint_name
from information_schema.constraint_column_usage
where table_name = 'user_role'
  and column_name = 'role_id'
  and constraint_column_usage.constraint_name <> 'unique_role_user';

alter table user_role drop constraint "uk_it77eq964jhfqtu54081ebtio";