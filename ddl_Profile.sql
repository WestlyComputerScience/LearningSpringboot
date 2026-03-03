CREATE TABLE profile
(
    id         INTEGER NOT NULL,
    bio        VARCHAR(255),
    student_id INTEGER,
    CONSTRAINT pk_profile PRIMARY KEY (id)
);

ALTER TABLE profile
    ADD CONSTRAINT uc_profile_student UNIQUE (student_id);

ALTER TABLE profile
    ADD CONSTRAINT FK_PROFILE_ON_STUDENT FOREIGN KEY (student_id) REFERENCES t_student (id);