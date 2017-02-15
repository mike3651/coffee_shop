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
	String review, name, date;

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview(String response) {
        this.review = response;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

	/* Generates a default review constructor */
	public Review() {}

	public Review(String date, int rating, String response, String person) {
		this.date = date;
		this.rating = rating;
		this.review = response;
		this.name = person;
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
	public String getReview() {
		return review;
	}

	/* Returns the name of the reviewer */
	public String getName() {
		return name;
	}

	/* Gets the review object in a string format
	 * 
  	 * Returns a toString form of the object */
	public String toString() {
		return "Reviewer: " + name + "\nDate: " + date + "\nRating: " + rating
			 + "\nReview: " + review; 
	}
}
