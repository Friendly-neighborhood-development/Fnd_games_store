INSERT INTO authorities
(authority_id, authority)
VALUES
('1', 'super_user');

INSERT INTO accounts
(account_id, username, password,authority_id)
VALUES
('1', 'admin', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6', '1');

