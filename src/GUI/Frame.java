package GUI;

import javax.swing.JFrame;

public class Frame extends JFrame {
    private GraphPanel graph;
    public Frame(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);

        GraphPanel g = new GraphPanel();
        this.graph = g;
        this.add(g);

        g.setFocusable(true);
        g.requestFocusInWindow();

    }

    public GraphPanel getGraph(){
        return this.graph;
    }
}
