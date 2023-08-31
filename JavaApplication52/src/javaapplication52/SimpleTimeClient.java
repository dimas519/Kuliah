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




public class SimpleTimeClient implements TimeClient {
private LocalDateTime dateAndTime;
public SimpleTimeClient() {
dateAndTime = LocalDateTime.now();
}
@Override
public void setMyTime(int hour, int minute, int second) {
LocalDate currentDate = LocalDate.from(dateAndTime);
LocalTime timeToSet = LocalTime.of(hour, minute, second);
dateAndTime = LocalDateTime.of(currentDate, timeToSet);
}
@Override
public void setMyDate(int day, int month, int year) {
LocalDate dateToSet = LocalDate.of(day, month, year);
LocalTime currentTime = LocalTime.from(dateAndTime);
dateAndTime = LocalDateTime.of(dateToSet, currentTime);
}
@Override
public void setMyDateAndTime(int day, int month, int year,
int hour, int minute, int second) {
LocalDate dateToSet = LocalDate.of(day, month, year);
LocalTime timeToSet = LocalTime.of(hour, minute, second);
dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
}
@Override
public LocalDateTime getMyLocalDateTime() {
return dateAndTime;
}
@Override
public String toString() {
return dateAndTime.toString();
}
public static void main(String... args) {

TimeClient myTimeClient = new SimpleTimeClient();
System.out.println(myTimeClient.toString());
}
}
}
