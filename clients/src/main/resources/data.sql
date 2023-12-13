truncate users;

INSERT INTO users(username, email)
SELECT
    'user' || generate_series(1, 10),
    'user' || generate_series(1, 10) || '@example.com';
