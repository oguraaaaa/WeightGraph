/**

--1件目のデータ登録
INSERT INTO weightRecords(recordDay,weight,fat,memo)
VALUES
(CURRENT_TIMESTAMP,50.0,25.0,'今日からスタート');
--2件目のデータ登録
INSERT INTO weightRecords(recordDay,weight,fat,memo)
VALUES
(CURRENT_TIMESTAMP,49.8,25.0,'30分歩いた');

--3件目のデータ登録
INSERT INTO weightRecords(recordDay,weight,fat,memo)
VALUES
(CURRENT_TIMESTAMP,49.2,24.6,'疲れた');

--4件目のデータ登録
INSERT INTO weightRecords(recordDay,weight,fat,memo)
VALUES
(CURRENT_TIMESTAMP,49.5,24.6,'ストレッチした');

--5件目のデータ登録
INSERT INTO weightRecords(recordDay,weight,fat,memo)
VALUES
(CURRENT_TIMESTAMP,49.3,24.5,'筋トレした');

*/

-- 認証テーブルへのダミーデータの追加
INSERT INTO authentications (username, password,authority,displayname) VALUES
('admin', '$2a$10$d7qacSOr08i7KD1zW6jvdelgu1eaA85/uXWqHRdHVRJ5UuS2AkKkG','USER','ゆうか');
