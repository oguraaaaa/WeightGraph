--テーブルが存在したら削除する
DROP TABLE IF EXISTS weightRecords;
DROP TABLE IF EXISTS authentications;
DROP TYPE IF EXISTS role;

--テーブルの作成
CREATE TABLE weightRecords(
	--id:主キー
	id serial PRIMARY KEY,
	--日付
	recordDay timestamp without time zone ,
	--w体重（kg）:NUll不可
	weight DECIMAL NOT NULL,
	--体脂肪（％）
	fat DECIMAL,
	--メモ
	memo text
);

--テーブルが存在したら削除する
DROP TABLE IF EXISTS goal;

--テーブルの作成
CREATE TABLE goal(
	--id:主キー
	id serial PRIMARY KEY,
	--目標の日付
	goalDay timestamp without time zone ,
	--体重（kg）:NUll不可
	goalWeight DECIMAL NOT NULL,
	--体脂肪（％）
	goalFat DECIMAL,
	--メモ
	memo text,
	--開始日 
	startDay timestamp without time zone
);
/**
--テーブルが存在したら削除する
DROP TABLE IF EXISTS user;

--テーブルの作成
CREATE TABLE user(
	--id:主キー
	id serial PRIMARY KEY,
	--名前
	name varchar,
	--身長:NUll不可
	hight DECIMAL
*/	

--権限用のENUM型
CREATE TYPE role AS ENUM('ADMIN','user');


--認証情報を格納するテーブル
CREATE TABLE authentications(
	--ユーザー名：主キー
	username VARCHAR(50)PRIMARY KEY,
	--パスワード
	password VARCHAR(255)NOT NULL,
	--権限
	authority role NOT NULL,
	-- 表示名
	displayname VARCHAR(50) NOT NULL
	);	

