package J108;

public enum directions {
    UP("вверх",8593, new int[]{0,1}),
    DOWN("вниз",8595, new int[]{0,-1}),
    LEFT("влево",8592, new int[]{-1,0}),
    RIGHT("вправо",8594, new int[]{1,0});
    private String title;
    private int unicode;
    private int[] vector;
    directions(String ruTitle, int unicode, int[]vectorForm) {
        this.title = ruTitle;
        this.unicode = unicode;
        this.vector = vectorForm;
    }

    public String getTitle() {
        return title;
    }

    public int getUnicode() {
        return unicode;
    }

    public int[] getVector() {
        return vector;
    }
}
