import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MyWindow extends JFrame implements MouseListener {
    private ArrayList<Student> studentList = new ArrayList<>();

    public MyWindow() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(this);
    }

    public static void main(String[] args) {
        MyWindow customWindow = new MyWindow();
    }

    // MouseListener methods
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        double randomGPA = Math.random() * 4.0; // Generate a random GPA for demonstration purposes

        Student newStudent = new Student("New Student", randomGPA);
        studentList.add(newStudent);
        System.out.println("New Student added: " + newStudent);
        System.out.println("Mouse Clicked at: (" + mouseX + ", " + mouseY + ")");
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}
