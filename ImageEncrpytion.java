

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;



class Image{
    public static void operate(int key)
    {
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.showOpenDialog(null);
         File file = fileChooser.getSelectedFile();

         //file input stream reader
         try{

            FileInputStream fis = new FileInputStream(file);
            byte [] data = new byte[fis.available()];
            fis.read(data);
            int i =0; 
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

         }catch(Exception e)
         {
            e.printStackTrace();
         }
    }
    public static void main(String[] args)
    {
        System.out.println("This is my first project");

        JFrame f = new JFrame(); // GUI to create button we have created a JFrame object
        f.setTitle("Image Encryption and Decryption");
        f.setSize(700,700);
        f.setLocationRelativeTo(null); //so that the box will display in center
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD,25); // to give font we have to import java.awt.Font

        //creating button
        JButton  button = new JButton();
        button.setText("Open Image");
        button.setFont(font);

        // creating text feild
        JTextField textField = new JTextField(10); //creating class
        textField.setFont(font);

        //whenever u will click on open image it will have to call a function. so for this use action Listerner
        // so we will add in button action Listener

        button.addActionListener(e-> {
            System.out.println("button clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        }); 
        //here we are using lambda function (e->) which is use to implement functional Interface 
        /* Basically here we have to pass listener object but as Action listener is Interface we cannot create object of Interface 
        so here we will create child class object, so I created here a child classs and implemneted ActionListerner and pass it as objeft */
        
        //setting layout

        f.setLayout(new FlowLayout());

        f.add(button);
        f.add(textField);
        f.setVisible(true);
    }
}
