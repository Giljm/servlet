package testProject;

import java.util.Random;
import java.util.Scanner;

import testProject.model.menutest_DAO;
import testProject.model.test_DAO;

public class test_01 {

	public static void main(String[] args) {
		test_DAO tdao = new test_DAO();
		menutest_DAO mdao = new menutest_DAO();

		while (true) {
			Integer select = mdao.menuService();
			if (select == null) {
				break;
			}

			if (select == 1) {
				tdao.INSERT();
			} else if (select == 2) {
				tdao.UPDATE();
			} else if (select == 3) {
				tdao.SELECT();
			} else if (select == 4) {
				tdao.DELETE();
			}
		}
	}
}