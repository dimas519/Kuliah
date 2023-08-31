/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication52;

/**
 *
 * @author Dimas
 */


 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


    @Deprecated
public interface TimeClient {
void setMyTime(int hour, int minute, int second);
void setMyDate(int day, int month, int year);
void setMyDateAndTime(int day, int month, int year,
int hour, int minute, int second);
LocalDateTime getMyLocalDateTime();
}
interface TimeClients extends TimeClient{
    void getMyZonedDateTime(String zoneString);
}
