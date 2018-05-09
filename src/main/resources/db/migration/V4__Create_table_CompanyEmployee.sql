DROP TABLE IF EXISTS Company_Employee;
CREATE TABLE Company_Employee (
  company_id int NOT NULL,
  employees_id int NOT NULL,
  UNIQUE KEY `UK_employees_id` (`employees_id`),
  CONSTRAINT `company_id_forNew`  FOREIGN KEY (`company_id`) REFERENCES `Company`(`id`),
  CONSTRAINT `employee_id_forNew`  FOREIGN KEY (`employees_id`) REFERENCES `Employee`(`id`)
) engine=InnoDB DEFAULT CHARSET = utf8;
