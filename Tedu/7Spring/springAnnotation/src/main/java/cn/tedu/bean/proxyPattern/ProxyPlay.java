package cn.tedu.bean.proxyPattern;

public class ProxyPlay implements Play{
    private Play play;
    private Other other;

    public ProxyPlay(Play play){
        this.play = play;
    }

    public ProxyPlay(Play play, Other other) {
        this.play = play;
        this.other = other;
    }

    @Override
    public void showTime() {
        if (other == null){
            System.out.println("loading....");
            play.showTime();
            System.out.println("ending.....");
        }else {
            other.before();
            play.showTime();
            other.after();
        }

    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
}


