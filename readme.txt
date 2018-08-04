APIEnabler Demo webservice II.

MySQL script:
create database apienabler;
use apienabler;
create table calldirect (ID number, action varchar(50));
insert into calldirect values(007,'connect');
insert into calldirect values(006,'busy');
insert into calldirect values(005,'connect');
insert into calldirect values(004,'connect');

grant all privileges on apienabler.* to apiuser@'%' identified by 'apiuser';
grant all privileges on apienabler.* to apiuser@localhost identified by 'apiuser';

URL:
Set action: (busy, connect, etc.. )
http://127.0.0.5:38080/APIEnablerDemo/rest/Notifications/setDirection/busy

Get action:
http://127.0.0.5:38080/APIEnablerDemo/rest/Notifications/callDirection
Content-Type: application/json
Request body: {"calledPartyNo": "989898988","callingPartyNo":"73737373737","callingPartyName":"Abhishek"}


grant all privileges on testdemo.* to apiuser@'%' identified by 'apiuser';
grant all privileges on testdemo.* to apiuser@localhost identified by 'apiuser';

delimiter ;;
drop PROCEDURE mulitiOut;;
CREATE PROCEDURE mulitiOut()
BEGIN
 SELECT ID FROM calldirect;
END;;
delimiter ;
