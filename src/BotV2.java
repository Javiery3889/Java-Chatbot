/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Javiery
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BotV2 {

    JFrame frame = new JFrame();
    Font font = new Font("Consolas", Font.PLAIN, 18); //set font for display on JTextArea 
    //image icon is based on the location on the file, hence it might not be able to display on your computer.
    ImageIcon image = new ImageIcon("C:\\Poly\\Assignment\\src\\assignment\\Image.jpg"); //get background image by giving filename
    JLabel label1 = new JLabel(image); //initialize background image using JLabel 
    JTextField txtEnter = new JTextField(); //initialize variable txtEnter (where user keys in input)
    JTextArea txtChat = new JTextArea(); //initialize variable txtChat (where conversation between chatbot and user is displayed)
    JScrollPane scroll = new JScrollPane(txtChat); //initialize variable scroll to allow user to scroll through chat box(txtChat)
    ArrayList<Questions> questions = new ArrayList<>(); //arraylist of object questions - stores questions and answers 
    String QuestionString = "";
    String[] AnswerString = new String[3];
    boolean ifquestionSet; //declare boolean to see if user inputs a question already

    public BotV2() {

        frame.add(label1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //JFrame stops running upon pressing exit button 
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setResizable(false); //allow JFrame to be minimize/maximise 
        frame.setLayout(null);
        frame.setTitle("Java ChatBot");
        txtChat.setFont(font);
        frame.add(txtEnter);
        frame.add(scroll);

        //txtEnter Attributes:
        txtEnter.setLocation(2, 730); // 2 refers to horizontal location of input box, 540 means the vertical location of input box
        txtEnter.setSize(800, 30);
        //txtChat Attributes:
        scroll.setLocation(15, 5);
        scroll.setSize(760, 710);
        txtChat.setEditable(false);

        botReply("Hello there, I am Medic Bot, to exit please type 'bye'");

        //txtEnter Action Event:
        txtEnter.addActionListener(new ActionListener() { //define what should be done when a user inputs strings in txtEnter
            @Override
            public void actionPerformed(ActionEvent e) { //runs when you ActionListener is invoked
                chat(); //call chat method
            }
        }); //end of actionlistener

    } //end of Constructor

    public void botReply(String s) {
        txtChat.append("MedicBot: " + s + "\n");
    } //end of botReply

    public void chat() {

        //code that reacts to ActionListener(when user enter input)
        String uText = txtEnter.getText(); //initialize variable uText to get user's input from txtEnter
        txtChat.append("You: " + uText + "\n");
        uText = uText.toLowerCase(); //convert user input to lower case

        for (int i = 0; i < questions.size(); i++) {
            //get object out from arraylist, call object method   
            String qn = questions.get(i).getQnString(); //references to object q's data which is in the arraylist q.
            String ans = questions.get(i).getansString(); //references to object q's data is in the arraylist q.

            if (ifquestionSet) { //if boolean is true run code
                if (uText.equals(qn)) {
                    botReply(ans);
                    txtEnter.setText("");
                    return; //rest of code will not be executed

                }
            }
        } //end of for loop

        if (uText.contains("add question")) {
            int count = 0;
            AnswerString = new String[3]; //empty array to allow  new answers to be stored
            QuestionString = JOptionPane.showInputDialog(null, "Please enter question: ");
            while (count < 3) { // loop three times for 3 answers 
                AnswerString[count] = JOptionPane.showInputDialog(null, "Please enter answer: ");
                count++;
            } //end of while loop

            botReply("Question '" + QuestionString + "' sucessfully");
            Questions q = new Questions(QuestionString, AnswerString); //construct Questions object 
            questions.add(q); //store Question objects in array list
            ifquestionSet = true; //boolean set true when a question is set by user

        } else if (uText.contains("help")) {
            botReply("\n add question - enter a question and answer"
                    + "\n bmi - Calculate your bmi."
                    + "\n fact - Gives you a fact about our nation's healthcare."
                    + "\n date - Tells you the current date."
                    + "\n time - Tells you current time."
                    + "\n emergency - Find out nearest general hospitals from your location and how to get there via public transport.");

        } else if (uText.contains("time")) {
            Date date = new Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss a"); //SimpleDateFotmat is a class that formats and parse dates
            botReply("The time is " + sdf.format(date));

        } else if (uText.contains("date")) {
            Date date = new Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd.MM.yyyy");
            botReply("Today's date is " + sdf.format(date));

        } else if (uText.equals("hi") || uText.equals("hello") || uText.equals("hey there")) {
            String[] GreetingList = {"Hi!", "Hello There!", "Greetings!", "Salutation!"};
            int index = (int) (Math.random() * 4);
            String random = (GreetingList[index]);
            botReply(random);

        } else if (uText.contains("how are you")) {
            String[] mylist = {"Not to bad", "I feel great!", "I'm doing well, thanks", "I am well"};
            int index = (int) (Math.random() * 5);
            String random = (mylist[index]);
            botReply(random);

        } else if (uText.contains("bmi")) {
            String weightString = JOptionPane.showInputDialog(
                    null,
                    "Enter weight in kg");
            double weight = Double.parseDouble(weightString);
            String heightString = JOptionPane.showInputDialog(
                    null,
                    "Enter height in m");
            double height = Double.parseDouble(heightString);
            botReply(Methods.bmi(weight, height));

        } else if (uText.contains("emergency")) {
            String locationString = JOptionPane.showInputDialog(null, "Enter your location (e.g North, South, East, West, Central)");
            botReply(Methods.location(locationString));

        } else if (uText.contains("fact")) {
            botReply(Methods.getOutput());

        } else if (uText.contains("bye")) {
            botReply("Goodbye");
            ActionListener AL2 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0); //Programs ends after 2 seconds delay
                }
            }; //end of AL2
            Timer timer = new Timer(1000, AL2); //set timer duration and add 
            timer.start();

        } else {
            String[] replylist = {"I don't understand", "Type 'help' to find out more", "Sorry, please rephrase that"};
            int decider = (int) (Math.random() * 3);
            String random = (replylist[decider]);
            botReply(random);
        }
        txtEnter.setText(""); //set text in input box to be empty by defualt
    } //end of chat 

    public static void main(String[] args) {

        BotV2 botv2 = new BotV2();

    } //end of main

} //end of class
