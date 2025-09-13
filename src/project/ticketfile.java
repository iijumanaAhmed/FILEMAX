/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import java.nio.file.*;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author meme
 */
public class ticketfile {
    
    int IN ;
    int ticketId;
    String date;
    String hallnum;
    String seatnum;
    double price;
    String username;
    String showtime;
    String movieId;

    private static Formatter output;
    private static Scanner input;
    
    public ticketfile() {
    }

    
    
    
    public ticketfile(int IN, int ticketId, String date, String hallnum, String seatnum, double price, String username, String showtime, String movieId) {
        this.IN = IN;
        this.ticketId = ticketId;
        this.date = date;
        this.hallnum = hallnum;
        this.seatnum = seatnum;
        this.price = price;
        this.username = username;
        this.showtime = showtime;
        this.movieId = movieId;
    }

    public int getIN() {
        return IN;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getDate() {
        return date;
    }

    public String getHallnum() {
        return hallnum;
    }

    public String getSeatnum() {
        return seatnum;
    }

    public double getPrice() {
        return price;
    }

    public String getUsername() {
        return username;
    }

    public String getShowtime() {
        return showtime;
    }
    
    public String getMovieId() {
        return movieId;
    }

    public void setIN(int IN) {
        this.IN = IN;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHallnum(String hallnum) {
        this.hallnum = hallnum;
    }

    public void setSeatnum(String seatnum) {
        this.seatnum = seatnum;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }
    
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    
    
    public void readFromFile(){
        openFileToRead();
                        
        try{
        while(input.hasNext()){

            
        String booking = """
                         Latest Booking: 
                         Invoice ID: """+input.nextInt()
                + "\nMovie ID: "+input.next() 
                + "\nTicket ID: "+input.nextInt()
                + "\nHall Number: "+input.next()
                + "\nUsername: "+input.next()
                + "\nSeat(s): "+input.next()
                + "\nShow Date: "+input.next()
                + "\nShow Time: "+input.next()
                + "\nPrice: "+input.nextDouble();
        
        JOptionPane.showMessageDialog(null, booking);
//        System.out.println("Latest Booking: ");
//        System.out.printf(
//                "%s %d %n"
//                + "%s %s %n"
//                + "%s %s %n"
//                + "%s %s %n"
//                + "%s %s %n"
//                + "%s %s %n"
//                + "%s %s %n"
//                + "%s %s %n"
//                + "%s %.2f %n", 
//                "Invoice ID: ",input.nextInt(),
//                "Movie ID: ",input.next(), 
//                "Ticket ID: ",input.nextInt(), 
//                "Hall Number: ",input.next(),
//                "Username: ",input.next(), 
//                "Seat(s): ",input.next(), 
//                "Show Date: ", input.next(),
//                "Show Time: ",input.next(), 
//                 "Price: ",input.nextDouble());

        }
        
        }

        catch (NoSuchElementException elementException){       
            System.err.println("File improperly formed. Terminating");
        }
        catch (IllegalStateException stateException){
            System.err.println("Error reading from file. Terminating");
        }
        
        closeFileAfterRead();
        
        
    }
    
    public void writeToFile(ticketfile ticketobj){
        
        openFileToWrite();
        
        try{
            output.format("%d %s %d %s %s %s %s %s %.2f %n", ticketobj.getIN(), 
                    ticketobj.getMovieId(), ticketobj.getTicketId(), ticketobj.getHallnum(), 
                    ticketobj.getUsername(), ticketobj.getSeatnum(), ticketobj.getDate().substring(0,10),
                    ticketobj.getShowtime(), ticketobj.getPrice() );
        } catch(FormatterClosedException e){
            System.err.println("Error writing to file. Terminating program.");
            System.exit(1);
        }
        catch(Exception e){
            System.err.println("Error occurred. Terminating program.");
            System.exit(1);
        }
        
        closeFileAfterWrite();
        
    }
    
    public void openFileToWrite(){
        try{
            output = new Formatter("c:\\txtfiles\\tickets.txt");
        }
        catch(SecurityException e){
            System.err.println("Write permission denied. Terminating program.");
            System.exit(1);
        }
        catch(FileNotFoundException e){
            System.err.println("Error opening file. Terminating program.");
            System.exit(1);
        }
    }
    
    public void openFileToRead(){
        try{
            input = new Scanner(Paths.get("c:\\txtfiles\\tickets.txt"));
        }
        catch(IOException e){
            System.err.println("Error opening file. Terminating program.");
            System.exit(1);
        }
    }
    
    public void closeFileAfterWrite(){
        if(output!=null)
            output.close();
    }
    
    public void closeFileAfterRead(){
        if(input!=null)
            input.close();
    }
    
}
