/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ubuntu
 */
public class CoffeeShop {
    List<Review> reviews;
	String myName, myAddress, myDescription;
	double overallRating;

	public CoffeeShop(String name, String address, String description) {
		reviews = new ArrayList<>();
		myName = name;
		myAddress = address;
		myDescription = description;
		overallRating = 0.0;
	}

	/* Adds a review to the coffee shop */
	public void addReview() {
		// do some magic here & create the object
		Review r = new Review();
		updateRating(r.getRating());
	}

	/* Returns the name of the shop */
	public String getName() {
		return myName;
	}

	/* Sets the name of the shop to something else in case the owner
	 * decides that he or she really hates the name
	 *
	 * @param newName The new name of the shop */
	public void setName(String newName) {
		myName = newName;
	}

	/* Returns the current address of the shop */
	public String getAddress() {
		return myAddress;
	}

	/* Sets the address of the shop in case the company moves 
	 * 
	 * @param newAddress The new address of the coffee shop */
	public void setAddress(String newAddress) {
		myAddress = newAddress;
	}

	/* Private method that updates the rating 
	 *
	 * @param r The rating to add
	 */
	private void updateRating(int r) {
		overallRating += r;
	}

	/* Gets the rating of the shop */
	public double getRating() {		
		return overallRating/reviews.size();
	}

	/* Prints out the details of the shop */
	public void printMyDetails() {
		System.out.println("My name: " + myName);
		System.out.println("Address: " + myAddress);
		for(Review r : reviews) {
			System.out.println(r.toString());
		}
}
}
