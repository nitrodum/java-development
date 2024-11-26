package com.pluralsight;

public class Film {
    private int filmID;
    private String title;
    private String description;
    private int release_year;
    private int length;

    public Film(int filmID, String title, String description, int release_year, int length) {
        this.filmID = filmID;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.length = length;
    }

    @Override
    public String toString() {
        String trimmedDescription = description.length() > 50 ? description.substring(0, 47) + "..." : description;
        return String.format(
                "%-9d%-30s%-55s%-14d%-7d", filmID, title, trimmedDescription, release_year, length
        );
    }
}
