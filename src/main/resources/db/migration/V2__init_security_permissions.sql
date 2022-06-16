-- Authorities

-- Authority Authorities
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('3cce607f-f990-4c6f-8309-910b8c228365', 'authority.create', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('fc868f22-dd88-4d07-a717-01139d43b87f', 'authority.read', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('1c74e599-72d2-4486-8058-63cfc666f982', 'authority.update', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('29af5a20-67a7-4d57-9129-158afe071582', 'authority.delete', sysdate(), sysdate());

-- Role Authorities
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('ad475aa2-b42b-4eb9-b3f4-921c5b17b1eb', 'role.create', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('6d5a9383-83aa-4028-af2c-2876843fdd2c', 'role.read', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('2d580bb3-f394-4b3f-b569-0ebb792e81ec', 'role.update', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('fc855a4a-2df4-49c6-9a70-6315e1128f37', 'role.delete', sysdate(), sysdate());

-- User Authorities
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('38f56366-72f9-482d-93cb-70a8fd5489e8', 'user.create', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('b915d32f-618a-402d-a297-0339624989e8', 'user.read', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('b3a9cb6a-c790-45bd-8bd3-05f748374342', 'user.update', sysdate(), sysdate());
insert into acctmgmtdb.authority(authority_id, permission, created_date, updated_date) values ('7a41a98d-13a2-4828-9549-0596e4884bff', 'user.delete', sysdate(), sysdate());

-- Account Authorities
INSERT INTO acctmgmtdb.authority(authority_id, permission, created_date, updated_date) VALUES ('6976f1cd-947f-44c7-955c-965f5b2f3080', 'account.create', sysdate(), sysdate());
INSERT INTO acctmgmtdb.authority(authority_id, permission, created_date, updated_date) VALUES ('98f77d2b-bf2b-43b6-bc7f-736a4157c56f', 'account.read', sysdate(), sysdate());
INSERT INTO acctmgmtdb.authority(authority_id, permission, created_date, updated_date) VALUES ('cd359070-123f-4cd9-8f21-ec100e240c1d', 'account.update', sysdate(), sysdate());
INSERT INTO acctmgmtdb.authority(authority_id, permission, created_date, updated_date) VALUES ('df6cff22-1dc2-4342-ab04-1841e30ab3fd', 'account.delete', sysdate(), sysdate());


-- Roles

INSERT INTO acctmgmtdb.role(role_id, role_name, created_date, updated_date) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', 'ADMIN', sysdate(), sysdate());
INSERT INTO acctmgmtdb.role(role_id, role_name, created_date, updated_date) VALUES ('738d72fb-7b85-4531-a1b2-e77cc244bb29', 'CUSTOMER_SERVICE_SPECIALIST', sysdate(), sysdate());
INSERT INTO acctmgmtdb.role(role_id, role_name, created_date, updated_date) VALUES ('e04573a1-9114-4192-9509-2186b27d2c21', 'CUSTOMER_SERVICE_MANAGER', sysdate(), sysdate());
INSERT INTO acctmgmtdb.role(role_id, role_name, created_date, updated_date) VALUES ('f3f4aabc-2f99-459b-9d81-865d263ac4fb', 'SERVICE', sysdate(), sysdate());
INSERT INTO acctmgmtdb.role(role_id, role_name, created_date, updated_date) VALUES ('d5fe97f0-136c-4795-98f9-089afe5d524c', 'CUSTOMER', sysdate(), sysdate());


-- Role Authority Relationship

-- Admin Role
-- Account entity

INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '6976f1cd-947f-44c7-955c-965f5b2f3080');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '98f77d2b-bf2b-43b6-bc7f-736a4157c56f');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', 'cd359070-123f-4cd9-8f21-ec100e240c1d');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', 'df6cff22-1dc2-4342-ab04-1841e30ab3fd');

-- Authority Entity
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '3cce607f-f990-4c6f-8309-910b8c228365');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', 'fc868f22-dd88-4d07-a717-01139d43b87f');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '1c74e599-72d2-4486-8058-63cfc666f982');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '29af5a20-67a7-4d57-9129-158afe071582');

-- Role Entity
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', 'ad475aa2-b42b-4eb9-b3f4-921c5b17b1eb');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '6d5a9383-83aa-4028-af2c-2876843fdd2c');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '2d580bb3-f394-4b3f-b569-0ebb792e81ec');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', 'fc855a4a-2df4-49c6-9a70-6315e1128f37');

-- User Entity
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '38f56366-72f9-482d-93cb-70a8fd5489e8');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', 'b915d32f-618a-402d-a297-0339624989e8');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', 'b3a9cb6a-c790-45bd-8bd3-05f748374342');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc', '7a41a98d-13a2-4828-9549-0596e4884bff');

-- Customer Service Specialist Role

INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('738d72fb-7b85-4531-a1b2-e77cc244bb29', '98f77d2b-bf2b-43b6-bc7f-736a4157c56f');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('738d72fb-7b85-4531-a1b2-e77cc244bb29', 'cd359070-123f-4cd9-8f21-ec100e240c1d');


-- Customer Service Manager Role

INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('e04573a1-9114-4192-9509-2186b27d2c21', '6976f1cd-947f-44c7-955c-965f5b2f3080');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('e04573a1-9114-4192-9509-2186b27d2c21', '98f77d2b-bf2b-43b6-bc7f-736a4157c56f');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('e04573a1-9114-4192-9509-2186b27d2c21', 'cd359070-123f-4cd9-8f21-ec100e240c1d');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('e04573a1-9114-4192-9509-2186b27d2c21', 'df6cff22-1dc2-4342-ab04-1841e30ab3fd');

-- Service Role

INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('f3f4aabc-2f99-459b-9d81-865d263ac4fb', '6976f1cd-947f-44c7-955c-965f5b2f3080');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('f3f4aabc-2f99-459b-9d81-865d263ac4fb', '98f77d2b-bf2b-43b6-bc7f-736a4157c56f');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('f3f4aabc-2f99-459b-9d81-865d263ac4fb', 'cd359070-123f-4cd9-8f21-ec100e240c1d');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('f3f4aabc-2f99-459b-9d81-865d263ac4fb', 'df6cff22-1dc2-4342-ab04-1841e30ab3fd');

-- Customer Role

INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('d5fe97f0-136c-4795-98f9-089afe5d524c', '6976f1cd-947f-44c7-955c-965f5b2f3080');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('d5fe97f0-136c-4795-98f9-089afe5d524c', '98f77d2b-bf2b-43b6-bc7f-736a4157c56f');
INSERT INTO acctmgmtdb.role_authority(role_id, authority_id) VALUES ('d5fe97f0-136c-4795-98f9-089afe5d524c', 'cd359070-123f-4cd9-8f21-ec100e240c1d');


-- Users

INSERT INTO acctmgmtdb.security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled, created_date, updated_date) VALUES ('28ea3165-6227-41a0-bdd0-107d5e6955dd', 'api-gateway', '{bcrypt}$2a$10$df7hCzpc52lLN3CRWjTLCOxO7SOYq.UbFtqgHrjn9ltHuMHY9PJyq', true, true, true, true, sysdate(), sysdate());
INSERT INTO acctmgmtdb.security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled, created_date, updated_date) VALUES ('d27be6ef-60b0-482f-a1bd-186af1e5c9cb', 'john', '{bcrypt}$2a$10$i0tkvx3VcMfCUnoVj86fU.Sazo4vDSqZkSCqjIj1UOYy.IwREqm9S', true, true, true, true, sysdate(), sysdate());
INSERT INTO acctmgmtdb.security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled, created_date, updated_date) VALUES ('e8889dad-af9e-4cd6-9d24-948cdf3a2ce8', 'mary', '{bcrypt}$2a$10$QKQX/eORCWhU43KeTJLaoeXyeiifczHvktHW5Flu3/ayZzqs3AfFW', true, true, true, true, sysdate(), sysdate());
INSERT INTO acctmgmtdb.security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled,created_date, updated_date) VALUES ('555534ab-abc2-4bca-8164-19f9d787e244', 'cindy', '{bcrypt}$2a$10$j8PuF3tBc1yX.FTOoOPmHOQMPmKOhV10wz/NvtSoqWIn6jSoFSi4C', true, true, true, true, sysdate(), sysdate());
INSERT INTO acctmgmtdb.security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled,created_date, updated_date) VALUES ('97363047-532d-4586-b727-a748c028590a', 'balaji', '{bcrypt}$2a$10$JIDxIwbl6PWmt1TvWUJcqeav7OMKoOUM4FzPTabWCCx3abonUBYuK', true, true, true, true, sysdate(), sysdate());
INSERT INTO acctmgmtdb.security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled,created_date, updated_date) VALUES ('4e718df1-985c-4b3d-91f2-11d097cbc8e8', 'pooja', '{bcrypt}$2a$10$qRNGfJdHnVDiry6I3HvdIeU/ekw1zC/wY5Ksppu85z2pRJNkrO.pm', true, true, true, true, sysdate(), sysdate());
INSERT INTO acctmgmtdb.security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled,created_date, updated_date) VALUES ('d14842c6-335f-4043-beef-120087a49210', 'jia', '{bcrypt}$2a$10$5b.zCOADMBSFZG0OJY9upugIrOzzw7FRq/5emuKk6jNVXBPgFtsCW', true, true, true, true, sysdate(), sysdate());
INSERT INTO acctmgmtdb.security_user(user_id, username, password, account_not_expired, account_not_locked, credentials_not_expired, enabled,created_date, updated_date) VALUES ('7433ce90-3f43-4bf1-a600-fd7fc6457b90', 'joy', '{bcrypt}$2a$10$U3/5Q0L6QTcHIbHczpwnpe/UtbF6FJwdTz5PuMxROj.kSufkOjNwm', true, true, true, true, sysdate(), sysdate());

-- User Role Relationship

INSERT INTO acctmgmtdb.user_role(user_id, role_id) VALUES ('28ea3165-6227-41a0-bdd0-107d5e6955dd', 'f3f4aabc-2f99-459b-9d81-865d263ac4fb');
INSERT INTO acctmgmtdb.user_role(user_id, role_id) VALUES ('d27be6ef-60b0-482f-a1bd-186af1e5c9cb', '72cd5d0a-ef7f-43d4-9a0d-d8482ca6f5bc');
INSERT INTO acctmgmtdb.user_role(user_id, role_id) VALUES ('e8889dad-af9e-4cd6-9d24-948cdf3a2ce8', '738d72fb-7b85-4531-a1b2-e77cc244bb29');
INSERT INTO acctmgmtdb.user_role(user_id, role_id) VALUES ('555534ab-abc2-4bca-8164-19f9d787e244', 'e04573a1-9114-4192-9509-2186b27d2c21');
INSERT INTO acctmgmtdb.user_role(user_id, role_id) VALUES ('97363047-532d-4586-b727-a748c028590a', 'd5fe97f0-136c-4795-98f9-089afe5d524c');
INSERT INTO acctmgmtdb.user_role(user_id, role_id) VALUES ('4e718df1-985c-4b3d-91f2-11d097cbc8e8', 'd5fe97f0-136c-4795-98f9-089afe5d524c');
INSERT INTO acctmgmtdb.user_role(user_id, role_id) VALUES ('d14842c6-335f-4043-beef-120087a49210', 'd5fe97f0-136c-4795-98f9-089afe5d524c');
INSERT INTO acctmgmtdb.user_role(user_id, role_id) VALUES ('7433ce90-3f43-4bf1-a600-fd7fc6457b90', 'd5fe97f0-136c-4795-98f9-089afe5d524c');