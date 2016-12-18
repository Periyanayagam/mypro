package perusu.mobolutions.com.resume;

public class Song {

    private String name, singer,year,rank;
    private int pic;

    public Song(String name, String singer, String rank, int pic,String year){

        this.name = name;
        this.singer = singer;
        this.rank = rank;
        this.pic = pic;
        this.year = year;

    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}