package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();

	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		startUserInterface(input);
		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean showMenu = true;
		int userSelect;
		String keyword;

		do {
			System.out.println("\n----- Please Select A Menu Option -----");
			System.out.println("1. Look up a film by film ID.");
			System.out.println("2. Look up a film by keyword search.");
			System.out.println("3. Exit Film Query Application");

			try {
				int select = input.nextInt();
				switch (select) {

				case 1:
					System.out.println("Enter Film ID to display film information. ");
					userSelect = input.nextInt();
					Film film = db.findFilmById(userSelect);
					try {
						if (film != null) {
							System.out.println(film);

						} else {
							System.out.println("Please try again, film not found. ");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 2:
					System.out.println("Enter a Search Keyword to display Film(s) with occurance of Keyword. ");
					keyword = input.next();
					try {
						List<Film> searchFilm = db.findFilmByKeyword(keyword);
						if (searchFilm.isEmpty()) {
							System.out.println("Please try again, film not found. ");
						} else {
							for (Film film2 : searchFilm)
								System.out.println(film2);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 3:
					System.out.println("-*- Exiting Film Query Application -*- \n Thank you for your query.");
					showMenu = false;
					break;
				default:
					System.out.println("Invalid entry. Please try again.");
					break;
				}
			} catch (InputMismatchException e) {
				input.next();
				System.out.println(e.toString());
			}

		} while (showMenu);

	}

}