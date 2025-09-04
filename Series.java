package tvseriesapp;

public class Series {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int numberOfEpisodes;

    
    public Series(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    
    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    // Print series details
    public void displaySeriesDetails() {
        System.out.println("SERIES ID: " + seriesId);
        System.out.println("SERIES NAME: " + seriesName);
        System.out.println("SERIES AGE RESTRICTION: " + seriesAge);
        System.out.println("NUMBER OF EPISODES: " + numberOfEpisodes);
    }
}

