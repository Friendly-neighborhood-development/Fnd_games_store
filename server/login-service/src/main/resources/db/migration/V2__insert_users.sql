INSERT INTO authorities
(authority_id, authority)
VALUES
('1', 'super_user'),
('2', 'staff_user'),
('3', 'regular_user');

INSERT INTO accounts
(account_id, username, password)
VALUES
('1', 'admin', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6'),
('2', 'staff', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6'),
('3', 'regular', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6');

INSERT INTO accounts_authorities
(account_id, authority_id)
VALUES
('1','1'),
('1','2'),
('1','3'),
('2','2'),
('2','3'),
('3','3');