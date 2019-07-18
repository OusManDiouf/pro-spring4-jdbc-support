
/*Fonction testé et valide sur mysql db*/
CREATE DEFINER=`augustus`@`%` FUNCTION `jdbc1`.`getFirstNameById`(in_id int)
RETURNS varchar(60) CHARSET latin1
BEGIN
	RETURN (SELECT first_name FROM jdbc1.CONTACT WHERE id = in_id);
END