package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import javax.swing.JPanel;

public class GraphPanel extends JPanel implements MouseListener, MouseMotionListener {
    private ArrayList<NodePanel> nodes;
    private Set<Set<NodePanel>> edges;

    private Point prevPt;

    private Component focusedComponent;

    public GraphPanel() {
        this.nodes = new ArrayList<>(20);
        this.edges = new HashSet<>();

        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setLocation(0, 0);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    // public void editMode(MouseEvent e) {
    // switch (this.latestKeyPressed) {
    // case 'c': // connect
    // if (!(this.focusedComponent instanceof Node)) {
    // this.focusedComponent = this.getComponentAt(e.getPoint());
    // return;
    // }

    // Component nextComponent = this.getComponentAt(e.getPoint());

    // if ((nextComponent instanceof Node) && nextComponent !=
    // this.focusedComponent) {
    // this.connectNode((Node) this.focusedComponent, (Node) nextComponent);
    // this.setFocusedComponent(null);
    // }
    // break;

    // case 'r': // remove
    // if (!(this.getComponentAt(e.getPoint()) instanceof Node))
    // return;
    // this.removeNode((Node) this.getComponentAt(e.getPoint()));
    // this.focusedComponent = null;
    // break;

    // case 'd': // disconnect
    // if (!(this.focusedComponent instanceof Node)) {
    // this.focusedComponent = this.getComponentAt(e.getPoint());
    // return;
    // }

    // Component nextComponent2 = this.getComponentAt(e.getPoint());

    // if ((nextComponent2 instanceof Node) && nextComponent2 !=
    // this.focusedComponent) {
    // this.disconnectNode((Node) this.focusedComponent, (Node) nextComponent2);
    // this.setFocusedComponent(null);
    // }
    // break;

    // }
    // }
    public ArrayList<NodePanel> getNodes(){
        return this.nodes;
    }

    public void connectNode(NodePanel obj1, NodePanel obj2) {
        if (obj1 == obj2)
            return;

        obj1.addConnection(obj2);
        obj2.addConnection(obj1);

        Set<NodePanel> newSet = new HashSet<>(2);
        newSet.add(obj1);
        newSet.add(obj2);
        this.edges.add(newSet);
    }

    public void connectNode(int idx1, int idx2) {
        if (idx1 == idx2)
            return;

        NodePanel obj1 = this.getNodes().get(idx1);
        NodePanel obj2 = this.getNodes().get(idx2);

        obj1.addConnection(obj2);
        obj2.addConnection(obj1);

        Set<NodePanel> newSet = new HashSet<>(2);
        newSet.add(obj1);
        newSet.add(obj2);
        this.edges.add(newSet);
    }

    public void disconnectNode(NodePanel obj1, NodePanel obj2) {
        Set<NodePanel> edge = new HashSet<>(2);
        edge.add(obj1);
        edge.add(obj2);
        this.edges.remove(edge);
        obj1.removeConnection(obj2);
        obj2.removeConnection(obj1);
    }

    public void insertNode(NodePanel n) {
        this.nodes.add(n);
        this.add(n);
        this.validate();
    }

    public void removeNode(NodePanel n) {
        this.nodes.remove(n);
        this.remove(n);
        NodePanel.removeDefaultNumber(n.getIdentifier());

        ArrayList<NodePanel> adjacentNodes = new ArrayList<>(n.getConnectedNodes());

        if (adjacentNodes.isEmpty())
            return;

        for (NodePanel node : adjacentNodes) {
            System.out.println(node.getIdentifier());
            this.disconnectNode(n, node);
        }

    }

    public void colorNode(int idx, Color color){
        this.nodes.get(idx).setFillColor(color);
        this.validate();
    }

    public void paint(Graphics g) {

        // Set anti-aliasing
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(rh);

        this.paintComponent(g2);

        if (!this.edges.isEmpty()) {
            // Draw edges
            g2.setStroke(new BasicStroke(2));
            for (Set<NodePanel> sets : this.edges) {
                NodePanel obj1, obj2;
                Iterator<NodePanel> it = sets.iterator();

                obj1 = (NodePanel) it.next();
                obj2 = (NodePanel) it.next();
                g2.drawLine(obj1.getX() + obj1.getRadius(), obj1.getY() + obj1.getRadius(),
                        obj2.getX() + obj2.getRadius(), obj2.getY() + obj2.getRadius());
            }
        }

        g2.setStroke(new BasicStroke(1));

        this.paintChildren(g2);

        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    private void setFocusedComponent(Component c) {
        this.focusedComponent = c;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setFocusedComponent(this.getComponentAt(e.getPoint()));
        int screenX = e.getXOnScreen();
        int screenY = e.getYOnScreen();

        System.out.println(screenX + " " + screenY);

        prevPt = new Point(screenX, screenY);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        if (!(this.focusedComponent instanceof NodePanel))
            return;
        int screenX = e.getXOnScreen();
        int screenY = e.getYOnScreen();

        int dx = screenX - (int) prevPt.getX();
        int dy = screenY - (int) prevPt.getY();

        System.out.println(dx + " " + dy);

        NodePanel targetNode = (NodePanel) this.focusedComponent;

        targetNode.setLocation(Math.max(targetNode.getBounds().x + dx, 0),
                Math.max(targetNode.getBounds().y + dy, 0));

        prevPt = new Point((int) prevPt.getX() + dx, (int) prevPt.getY() + dy);

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}
