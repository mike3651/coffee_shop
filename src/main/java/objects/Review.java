/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author ubuntu
 */
public class Review {
	int rating;
	String response, person, date;

	/* Generates a default review constructor */
	public Review() {}

	public Review(String date, int rating, String response, String person) {
		this.date = date;
		this.rating = rating;
		this.response = response;
		this.person = person;
	}

	/* Returns the date of this review */
	public String getDate() {
		return date;
	}

	/* Returns the rating of this review */
	public int getRating() {
		return rating;
	}

	/* Returns the response */
	public String getResponse() {
		return response;
	}

	/* Returns the name of the reviewer */
	public String getName() {
		return person;
	}

	/* Gets the review object in a string format
	 * 
  	 * Returns a toString form of the object */
	public String toString() {
		return "Reviewer: " + person + "\nDate: " + date + "\nRating: " + rating
			 + "\nReview: " + response; 
	}
}
