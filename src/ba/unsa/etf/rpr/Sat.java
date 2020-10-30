package ba.unsa.etf.rpr;

public class Sat{
    private int sati, minute, sekunde;
    public Sat(int sati, int minute, int sekunde){
        postavi(sati,minute,sekunde);
    }
    public void postavi(int sati, int minute, int sekunde){
        this.sati = sati;
        this.minute = minute;
        this.sekunde = sekunde;
    }
    public void sljedeci(){
        sekunde++;
        if (sekunde == 60) {
            sekunde = 0;
            minute = minute + 1;
        }
        if (minute == 60) {
            minute = 0;
            sati = sati + 1;
        }
        if (sati == 24) sati = 0;
    }
    public void prethodni() {
        sekunde = sekunde - 1;
        if (sekunde == -1) {
            sekunde = 59;
            minute = minute - 1;
        }
        if (minute == -1) {
            minute = 59;
            sati = sati - 1;
            if (sati == -1) sati = 23;
        }
    }
    public void pomjeriZa(int pomak){
        if(pomak > 0){
            for(int i = 0; i < pomak; i++) sljedeci();
        }
        else{
            for(int i = 0; i < -pomak; i++) prethodni();
        }
    }
    int dajSate(){
        return sati;
    }
    int dajMinute(){
        return minute;
    }
    int dajSekunde(){
        return sekunde;
    }
    public void ispisi(){
        System.out.println(sati + ":" + minute + ":" + sekunde);
    }
    public static void main(String[] args){
        Sat s=new Sat(15,30,45);
        s.ispisi();
        s.sljedeci();
        s.ispisi();
        s.pomjeriZa(-48);
        s.ispisi();
        s.postavi(0,0,0);
    }
}
