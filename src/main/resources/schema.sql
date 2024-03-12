CREATE TABLE note (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255),
                      content TEXT,
                      created_date TIMESTAMP
);