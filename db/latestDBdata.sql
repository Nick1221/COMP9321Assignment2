-- 15 publications
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(0, 'bookA', 2000, 1, 10, 'picA', 'authorA', 'editorA');
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookB', 2001, 2, 11, 'picB', 'authorA', 'editorA' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookC', 2000, 3, 12, 'picC', 'authorA', 'editorA' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookD', 2000, 4, 13, 'picD', 'authorB', 'editorB' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookE', 2000, 5, 14, 'picE', 'authorB', 'editorB' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookF', 2000, 6, 15, 'picF', 'authorB', 'editorB' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookG', 2000, 7, 16, 'picG', 'authorC', 'editorC' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookH', 2000, 8, 17, 'picH', 'authorC', 'editorC' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookI', 2000, 9, 18, 'picI', 'authorC', 'editorC' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookJ', 2000, 10, 19, 'picJ', 'authorD', 'editorD' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookK', 2000, 11, 20, 'picK', 'authorD', 'editorD' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookL', 2000, 12, 21, 'picL', 'authorD', 'editorD' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookM', 2000, 13, 22, 'picM', 'authorE', 'editorE' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookN', 2000, 14, 23, 'picN', 'authorE', 'editorE' );
INSERT INTO publications (pID, title,year,volume,price,picture, author, editor)
VALUES(NULL, 'bookO', 2000, 15, 24, 'picO', 'authorE', 'editorE' );
-- normal user
INSERT INTO user(uID, Username, password, email, confirmedEmail, firstName, lastName, Bdate, isAdmin, nickname, fullAddress, cardNumber, code)
VALUES (NULL, 'user1', 'user1', 'user1@gmail.com', 1, 'user', 'one', '2016/10/03', 0, 'one', 'house one', 12345678, 'code1');
INSERT INTO user(uID, Username, password, email, confirmedEmail, firstName, lastName, Bdate, isAdmin, nickname, fullAddress, cardNumber, code)
VALUES (NULL, 'user2', 'user2', 'user2@gmail.com', 1, 'user', 'two', '2016/10/03', 0, 'two', 'house two', 23456789, 'code2');
INSERT INTO user(uID, Username, password, email, confirmedEmail, firstName, lastName, Bdate, isAdmin, nickname, fullAddress, cardNumber, code)
VALUES (NULL, 'user3', 'user3', 'uesr3@gmail.com', 1, 'user', 'three', '2016/10/03', 0, 'three', 'house three', 34567890, 'code3');
INSERT INTO user(uID, Username, password, email, confirmedEmail, firstName, lastName, Bdate, isAdmin, nickname, fullAddress, cardNumber, code)
VALUES (NULL, 'user4', 'user4', 'user4@gmail.com', 1, 'user', 'four', '2016/10/03', 0, 'four', 'house four', 45678901, 'code4');
-- Admin
INSERT INTO user(uID, Username, password, email, confirmedEmail, firstName, lastName, Bdate, isAdmin, nickname, fullAddress, cardNumber, code)
VALUES (0, 'admin', 'admin', 'admin@gmail.com', 1, 'ad', 'min', '2016/10/03', 1, 'adminOne', 'house admin', 56789012, 'codeadmin');
-- ban publication
INSERT INTO banPublication(uID, banPID, reason, timeStamp) VALUES(5, 15, 'too boring', '2016/10/04');
-- user ban
INSERT INTO userBan(uID, banUID, reason, timeStamp) VALUES(5, 4, 'did not purchase any', '2016/10/04');
-- user register publication
INSERT INTO userRegisteredPublication(uID, pID, timeStamp, isVisible) VALUES(1, 1, '2016/10/01', 1);
INSERT INTO userRegisteredPublication(uID, pID, timeStamp, isVisible) VALUES(2, 2, '2016/10/02', 1);
INSERT INTO userRegisteredPublication(uID, pID, timeStamp, isVisible) VALUES(3, 3, '2016/10/03', 1);
-- user bought publication
INSERT INTO userBoughtPublication(uID, pID, timeStamp) VALUES(1, 3, '2016/10/04');
INSERT INTO userBoughtPublication(uID, pID, timeStamp) VALUES(2, 2, '2016/10/04');
INSERT INTO userBoughtPublication(uID, pID, timeStamp) VALUES(3, 1, '2016/10/04');
-- user activity
-- register
INSERT INTO userActivity(uID, pID, activity, timeStamp) VALUES(1, 1, 'register', '2016/10/01');
INSERT INTO userActivity(uID, pID, activity, timeStamp) VALUES(2, 2, 'register', '2016/10/02');
INSERT INTO userActivity(uID, pID, activity, timeStamp) VALUES(3, 3, 'register', '2016/10/03');
-- bought
INSERT INTO userActivity(uID, pID, activity, timeStamp) VALUES(1, 3, 'bought', '2016/10/04');
INSERT INTO userActivity(uID, pID, activity, timeStamp) VALUES(2, 2, 'bought', '2016/10/04');
INSERT INTO userActivity(uID, pID, activity, timeStamp) VALUES(3, 1, 'bought', '2016/10/04');