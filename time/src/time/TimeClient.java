/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

/**
 *
 * @author Dimas
 */
import java.time.*;
public interface TimeClient {
    void setTime(int tabuh, int menit, int detik);
    void setDate(int poe, int bulan, int taon);
    void setDateAndTime(int poe, int bulan, int taon,
                               int tabuh, int menit, int detik);
    LocalDateTime getLocalDateTime();
}qqqqqq