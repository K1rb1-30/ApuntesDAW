package mokepon6;

public class Parella<T> {
	private T primer;
    private T segon;
   
    public T getPrimer() {
        return primer;
    }
    public void setPrimer(T primer) {
        this.primer = primer;
    }
    public T getSegon() {
        return segon;
    }
    public void setSegon(T segon) {
        this.segon = segon;
    }

}
