INSERT INTO authorities
(authority_id, authority)
VALUES
('2', 'regular_user');

INSERT INTO accounts
(account_id, username, password,authority_id)
VALUES
('2','Mr. Stinson', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6', '2');