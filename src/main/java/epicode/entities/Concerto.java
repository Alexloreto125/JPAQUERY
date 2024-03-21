package epicode.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Concerto extends Event{
    @Enumerated(EnumType.STRING)
    private TipoConcerto tipoConcerto;
    private boolean inStreaming ;

    public Concerto (){}
    public Concerto(TipoConcerto tipoConcerto, boolean inStreaming){
        this.tipoConcerto=tipoConcerto;
        this.inStreaming=inStreaming
;    }

    public TipoConcerto getTipoConcerto() {
        return tipoConcerto;
    }

    public void setTipoConcerto(TipoConcerto tipoConcerto) {
        this.tipoConcerto = tipoConcerto;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
