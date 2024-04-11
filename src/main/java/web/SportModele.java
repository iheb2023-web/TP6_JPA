package web;
import java.util.List;
import metier.entities.Sport;

public class SportModele {
    private String motCle;
    private List<Sport> sp;

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Sport> getSp() {
        return sp;
    }

    public void setSp(List<Sport> sp) {
        this.sp = sp;
    }
}
