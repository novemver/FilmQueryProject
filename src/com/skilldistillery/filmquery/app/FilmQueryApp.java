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
		int userInt;
		String keyword;

		do {
			System.out.println(" *** Please Select A Menu Option *** ");
			System.out.println("1. Look up a film by film ID.");
			System.out.println("2. Look up a film by a search keyword.");
			System.out.println("3. Exit Film Query Application");

			try {
				int select = input.nextInt();
				switch (select) {
				case 1:
					System.out.println("To look up a film, enter the film ID: ");
					userInt = input.nextInt();
					Film film = db.findFilmById(userInt);
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
					System.out.println("To look up a film by keyword, enter your search keyword: ");
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
					System.out.println("* Exiting Film Query Application * ");
					showMenu = false;
					break;

				default:
					break;
				}
			} catch (InputMismatchException i) {
				input.next();
				System.err.println("Invalid Entry");
			}

		} while (showMenu);

	}

	private void test() {
		Film film = db.findFilmById(1);
		System.out.println(film);

		try {
			Actor anActor = db.findActorById(13);
			if (anActor != null) {
				System.out.println(anActor);

			} else {
				System.out.println("Film not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}