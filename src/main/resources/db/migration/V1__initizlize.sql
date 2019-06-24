create TABLE bbs (
  id BIGINT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(40) NOT NULL,
  content VARCHAR(500) NOT NULL,
  date TIMESTAMP NOT NULL,
  deleted BOOLEAN NOT NULL DEFAULT FALSE
);

insert into bbs(name, content, date) values('太郎', 'こんにちは', '2019-06-01 12:00:00');
insert into bbs(name, content, date) values('二郎', 'さようなら', '2019-06-01 12:01:00');
insert into bbs(name, content, date) values('三郎', 'ああああああああああああああああああああああああ', '2019-06-02 12:00:00');
insert into bbs(name, content, date) values('名無しさん', 'あああああああsd；fヵjsdふぉいあsdfっjふぁあああああああああああああああああああああああsdふぁsl；dkjふぁlsk；djふぁs；ldfかjfd；さlkdfjさ；lfdさ', '2019-06-05 12:00:00');
insert into bbs(name, content, date) values('名無しさん', 'ああああ', '2019-06-05 13:00:00');
insert into bbs(name, content, date) values('名無しさん', 'いいいいいいいいいいい', '2019-06-05 13:00:01');
insert into bbs(name, content, date, deleted) values('名無しさん', 'いいいいいいいいいいい', '2019-06-05 13:00:01', true);
