package mx.net.cablevision.vo;

import java.io.Serializable;

import java.util.List;

public class Items implements Serializable{

    private static final long serialVersionUID = 1L;

    protected List<Item> item;

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public List<Item> getItem() {
        return item;
    }
}
